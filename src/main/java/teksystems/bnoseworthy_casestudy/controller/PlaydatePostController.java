package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import teksystems.bnoseworthy_casestudy.formbean.AddChildFormBean;
import teksystems.bnoseworthy_casestudy.formbean.PlayDatePostFormBean;

import javax.validation.Valid;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
        response.setViewName("user/playdatePost");


        return response;


    }

    @RequestMapping(value = "/user/createplaydatePost", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView createPlaydatePost(PlayDatePostFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();


        if ( bindingResult.hasErrors() ) {

            List<String> errorMessages = new ArrayList<>();


            for (ObjectError error :bindingResult.getAllErrors() ) {

                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);

            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);


            response.setViewName("user/playdatePost");
            return response;
        }



        PlayDatePost playDatePost =  new PlayDatePost();


//        playDatePost.setCreateAt(form.getCreateAt());
//        playDatePost.setId(form.getId());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);

        playDatePost.setUserId(user.getId());
        playDatePost.setPostMessage(form.getPostMessage());
        playDatePost.setLocation(form.getLocation());

//        playDatePost.setPlaydateDate(form.getPlaydateDate());
        Object date = form.getPlaydateDate();
        String stringDate = date.toString();
        playDatePost.setPlaydateDate(stringDate);

        Object time = form.getPlaydateTime();
        String stringTime = time.toString();

        playDatePost.setPlaydateTime(stringTime);

        playdatePostDao.save(playDatePost);

        log.info(playDatePost.toString());


        response.setViewName("success/playdatePostedSuccessfully");

        return response;
    }






//    @GetMapping(value ="/user/userPlaydatePosts/{userId}")
    @RequestMapping(value = "/user/userPlaydatePosts", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView displayUserPlaydatePosts(@Valid PlayDatePostFormBean playDatePostFormBean, BindingResult bindingResult) throws Exception {

        ModelAndView response = new ModelAndView();

        response.setViewName("user/userPlaydatePosts");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);



            List<PlayDatePost> postList = playdatePostDao.findUserPlaydatePostsByUserId(user.getId());

            response.addObject("postList", postList);





        return response;

        }


   }