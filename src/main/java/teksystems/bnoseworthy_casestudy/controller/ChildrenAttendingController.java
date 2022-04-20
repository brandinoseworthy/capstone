package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.ChildDAO;
import teksystems.bnoseworthy_casestudy.database.dao.ChildrenAttendingDAO;
import teksystems.bnoseworthy_casestudy.database.dao.PlaydatePostDAO;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.ChildrenAttending;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.formbean.AddChildFormBean;
import teksystems.bnoseworthy_casestudy.formbean.AddChildToPlaydatePostFormBean;
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;
import teksystems.bnoseworthy_casestudy.security.UserDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@ControllerAdvice
public class ChildrenAttendingController {

    @Autowired
    private ChildrenAttendingDAO childrenAttendingDao;

    @Autowired
    private ChildDAO childDao;

    @Autowired
    private PlaydatePostDAO playdatePostDao;



    @RequestMapping(value = "/user/playdateSearchRegisterChild",  method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView  playdateSearchRegisterChild( @RequestParam(name = "child", required=false) Integer childId,
                                                      @RequestParam(name = "playdatepost", required=false)  Integer playdatepostId) throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("user/searchforplaydate");


        log.info("Child Id " + childId);
        log.info("PlaydatePost Id " + playdatepostId);

        ChildrenAttending childrenAttending = new ChildrenAttending();

        childrenAttending.setChild(childDao.findById(childId));
        childrenAttending.setPlaydatePost(playdatePostDao.findById(playdatepostId));
        log.info("hello");

        childrenAttendingDao.save(childrenAttending);

        log.info("here");

        response.setViewName("success/childRegisteredForPlaydatePost");

        return response;
    }


//    Not working yet
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/childrenattending/willbetheres/{playdatePostId}")
    public ModelAndView viewChildrenAttending(@PathVariable("playdatePostId") Integer playdatePostId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/childrenattending/willbetheres");

        log.info("PlaydatePost " + playdatePostId);
        List <ChildrenAttending> childAttending = childrenAttendingDao.findAll(playdatePostId);
        response.addObject("childAttendings", childAttending);



//        User user = userDao.findById(userId);
//
//        RegisterFormBean form = new RegisterFormBean();
//
//        form.setId(user.getId());
//        form.setEmail(user.getEmail());
//        form.setFirstName(user.getFirstName());
//        form.setLastName(user.getLastName());
//        form.setZip(user.getZip());
//        form.setDescription(user.getDescription());
//        form.setFavoritePlaceForPlaydates(user.getFavoritePlaceForPlaydates());
//
//        form.setImageURL(user.getProfileImg());
//
//        response.addObject("form", form);

        return response;

    }

}
