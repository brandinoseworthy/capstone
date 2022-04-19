package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.taglibs.standard.lang.jstl.IntegerLiteral;
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
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.database.entity.UserRole;
import teksystems.bnoseworthy_casestudy.formbean.AddChildFormBean;
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;
import teksystems.bnoseworthy_casestudy.security.UserDetailsServiceImpl;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ChildController {


    @Autowired
    ChildDAO childDao;

    @Autowired
    UserController userController;

    @Autowired
    UserDAO userDao;

    @Autowired
    UserDetailsServiceImpl userDetailsService;


    /**
     * Search results by child age. Seems to be working
     */
    @GetMapping(value = "/child/search")
    public ModelAndView search(@RequestParam(name = "searchId", required = false, defaultValue = "") Integer searchByAge) {
        ModelAndView response = new ModelAndView();
        response.setViewName("child/search");
        log.info(String.valueOf(searchByAge));


//        String search = "a";

        // very basic example of error checking
//        if ( searchFirstName != null && ! searchFirstName.equals("")){

        if (searchByAge != null) {
            List<Child> users = childDao.findByAge(searchByAge);
            response.addObject("users", users);


        } else {
            searchByAge = 0;
        }

        response.addObject("searchValue", searchByAge);

        return response;
    }


//    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET})
//    public ModelAndView registerSubmit(@Valid AddChildFormBean childForm, BindingResult bindingResult) throws Exception {
//        ModelAndView response = new ModelAndView();
//
//
////        int i = 10/0;
//
//        if ( bindingResult.hasErrors() ) {
//
//            List<String> errorMessages = new ArrayList<>();
//
//
//            for (ObjectError error :bindingResult.getAllErrors() ) {
//
//                errorMessages.add(error.getDefaultMessage());
//                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
//            }
//
//            response.addObject("childForm", childForm);
//
//            response.addObject("errorMessages", errorMessages);
//            response.addObject("bindingResult", bindingResult);
//
//
//            response.setViewName("user/register");
//            return response;
//        }
//
//        Child child = childDao.findById(childForm.getId());
//
//        if (child == null ) {
//             child = new Child();
//        }
//
//        child.setFirstName(childForm.getFirstName());
//        child.setLastName(childForm.getLastName());
//        child.setAge(childForm.getAge());
//        child.setUserId(form.);
//
//        childDao.save(child);
//
//        log.info(childForm.toString());
//
//        return response;
//    }

    @RequestMapping(value = "/success/registeredChildToUser", method = RequestMethod.GET)
    public ModelAndView successfullyAddChild() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("success/registeredChildToUser");


        return response;
    }

    @RequestMapping(value = "/user/addChild", method = RequestMethod.GET)
    public ModelAndView addChild() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/addChild");

        AddChildFormBean childForm = new AddChildFormBean();
        response.addObject("childForm", childForm);

        return response;
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/user/addChildSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addChildSubmit(@Valid AddChildFormBean childForm, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {

                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("childForm", childForm);
            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);


            response.setViewName("user/addChild");
            return response;
        }


        Child child = new Child();

        child.setFirstName(childForm.getChildFirstName());
        child.setLastName(childForm.getChildLastName());
        child.setAge(childForm.getChildAge());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);

        child.setUserId(user.getId());

        childDao.save(child);


        log.info(String.valueOf(child));

        response.setViewName(("redirect:/success/registeredChildToUser"));
        return response;
    }

//    @GetMapping(value = "/login/edit/{userId}")
//    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("login/register");
//
//        User user = userDao.findById(userId);
//        Child child = childDao.findByUserId(userId);
//
//        RegisterFormBean form = new RegisterFormBean();
//
//        AddChildFormBean childForm = new AddChildFormBean();
//
//        form.setId(user.getId()); //this is a hidden value - used to populate in the JSP
//        form.setEmail(user.getEmail());
//        form.setFirstName(user.getFirstName());
//        form.setLastName(user.getLastName());
//        form.setZip(user.getZip());
//        form.setDescription(user.getDescription());
//        form.setFavoritePlaceForPlaydates(user.getFavoritePlaceForPlaydates());
//
////        childForm.setChildFirstName(child.getFirstName());
////        childForm.setChildLastName(child.getLastName());
////        childForm.setChildAge(child.getAge());
//
//        response.addObject("form", form);
////        response.addObject("childForm", childForm);
//
//        return response;
//    }


    @RequestMapping(value = "/user/userChildren", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView viewUserChildren(@Valid AddChildFormBean childForm, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);
        List<Child> children = childDao.findChildrenByUserId(user.getId());
        response.addObject("children", children);

        return response;

    }

    @Transactional
    @RequestMapping(value = "/user/removeChild", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView removeChild(@RequestParam(name = "childId", required = false) Integer childId) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(String.valueOf(childId));
        childDao.deleteById(childId);

        response.setViewName("success/childRemoved");
        return response;


    }

}
