package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.PlaydatePostDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.formbean.AddChildFormBean;
import teksystems.bnoseworthy_casestudy.formbean.PlayDatePostBean;
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class PlaydatePostController {

    @Autowired
    private PlaydatePostDAO playdatePostDao;

    @RequestMapping(value = "/user/playdatePost", method = RequestMethod.GET)
    public ModelAndView playdatePost() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/playdatePost");


        return response;


    }

    @RequestMapping(value = "/user/createplaydatePost", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView createPlaydatePost(PlayDatePostBean form, BindingResult bindingResult) throws Exception {
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

        PlayDatePost playDatePost = playdatePostDao.findById(form.getId());

        if (playDatePost == null ) {
            playDatePost = new PlayDatePost();
        }

//        playDatePost.setCreateAt(form.getCreateAt());
//        playDatePost.setId(form.getId());
        playDatePost.setUserId(form.getUserId());
        playDatePost.setPostMessage(form.getPostMessage());
        playDatePost.setLocation(form.getLocation());

        playdatePostDao.save(playDatePost);

        log.info(form.toString());


        response.setViewName("success/playdatePostedSuccessfully");

        return response;
    }


}
