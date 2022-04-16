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
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
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
    ChildController childController;

    @Autowired
    ChildDAO childDao;

    @Autowired
    UserController userController;

    @Autowired
    UserDAO userDao;

    @Autowired
    UserDetailsServiceImpl userDetailsService;




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

}
