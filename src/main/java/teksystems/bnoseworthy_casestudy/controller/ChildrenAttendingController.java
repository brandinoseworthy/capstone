package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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




    //    not working yet
    @RequestMapping(value = "/child/playdateSignup", method = RequestMethod.GET)
    public ModelAndView playdateSignup() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("child/playdateSignup");

        AddChildToPlaydatePostFormBean form = new AddChildToPlaydatePostFormBean();
        response.addObject("form", form);

        return response;
    }

//    @GetMapping(value = "/user/searchforplaydateSubmit")
//    public ModelAndView searchforplaydateSubmit(@RequestParam (name = "playdatePostId")Integer playdatePostId,
//                                                @RequestParam(name = "userChildId")  Integer userChildId) throws Exception {
//        ModelAndView response = new ModelAndView();
//
//
//
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = ((UserDetails) principal).getUsername();
//
//        User user = userDao.findByEmail(username);
//        List<Child> children = childDao.findChildrenByUserId(user.getId());
//        response.addObject("children", children);
//
//
//
//        return response;
//    }


    @RequestMapping(value = "/user/playdateSearchRegisterChild",  method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView  playdateSearchRegisterChild( @RequestParam(name = "child", required=false) Integer childId,
                                                      @RequestParam(name = "playdatepost", required=false) Integer playdatepostId) throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("user/searchforplaydate");



        log.info(String.valueOf("Child Id " + childId));
        log.info(String.valueOf("PlaydatePost Id " + playdatepostId));

//        Child child = childDao.findById(childId);
//        log.info(String.valueOf("Child is " + child));
//
//        PlayDatePost playdatePost = playdatePostDao.findById(playdatepostId);
//        log.info(String.valueOf(playdatepostId));
//        log.info("hello");







        ChildrenAttending childrenAttending = new ChildrenAttending();


        childrenAttending.setChild(childDao.findById(childId));
        childrenAttending.setPlaydatePost(playdatePostDao.findById(playdatepostId));
        log.info("hello");

        childrenAttendingDao.save(childrenAttending);

        log.info("here");

        response.setViewName("user/searchforplaydate");



        return response;
    }

}
