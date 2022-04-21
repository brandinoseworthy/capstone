package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.PlaydatePostDAO;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.formbean.PlayDatePostFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class PlaydatePostController {

    @Autowired
    private PlaydatePostDAO playdatePostDao;

    @Autowired
    private UserDAO userDao;


    @RequestMapping(value = "/user/playdatePost", method = RequestMethod.GET)
    public ModelAndView playdatePost() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("playdatepost/create");

        return response;
    }

    @RequestMapping(value = "playdatepost/createpost", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView createPlaydatePost(@Valid PlayDatePostFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {

            List<String> errorMessages = new ArrayList<>();


            for (ObjectError error : bindingResult.getAllErrors()) {

                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);

            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);


            response.setViewName("playdatepost/create");


            return response;
        }

        PlayDatePost playDatePost = playdatePostDao.findById(form.getId());


        if (playDatePost == null) {
            playDatePost = new PlayDatePost();
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);

        playDatePost.setId(form.getId());
        playDatePost.setUserId(user.getId());
        playDatePost.setPostMessage(form.getPostMessage().trim());
        playDatePost.setLocation(form.getLocation().trim());

        //convert the date and time to a String
        Object date = form.getPlaydateDate();
        String stringDate = date.toString();
        playDatePost.setPlaydateDate(stringDate);

        Object time = form.getPlaydateTime();
        String stringTime = time.toString();

        playDatePost.setPlaydateTime(stringTime);


        playdatePostDao.save(playDatePost);

        log.info("New Playdate Post created: " + playDatePost);

        response.setViewName("redirect:/playdatepost/userposts");

        return response;
    }

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping(value = "/playdatepost/createpost/{playdatePostId}")
    public ModelAndView editPlaydatePost(@PathVariable("playdatePostId") Integer playdatePostId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("playdatepost/create");

        PlayDatePost playDatePost = playdatePostDao.findById(playdatePostId);
        log.info("Editing playdatepost Id: " + playdatePostId);
        PlayDatePostFormBean form = new PlayDatePostFormBean();

        form.setId(playDatePost.getId());
        form.setPostMessage(playDatePost.getPostMessage());
        form.setLocation(playDatePost.getLocation());
        form.setPlaydateDate(playDatePost.getPlaydateDate());
        form.setPlaydateTime(playDatePost.getPlaydateTime());

        response.addObject("form", form);

        return response;
    }


    @RequestMapping(value = "/playdatepost/userposts", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView displayUserPlaydatePosts(@Valid PlayDatePostFormBean playDatePostFormBean, BindingResult bindingResult) throws Exception {

        ModelAndView response = new ModelAndView();

        response.setViewName("playdatepost/userposts");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);

        List<PlayDatePost> postList = playdatePostDao.findUserPlaydatePostsByUserIdOrderByPlaydateDateDesc(user.getId());

        response.addObject("postList", postList);

        return response;

    }


}