package teksystems.bnoseworthy_casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.ChildDAO;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.dao.UserRoleDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.database.entity.UserRole;
import teksystems.bnoseworthy_casestudy.formbean.AddChildFormBean;
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private ChildDAO childDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;





    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");



        return response;
    }


    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, AddChildFormBean childForm, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();


//        int i = 10/0;

        if ( bindingResult.hasErrors() ) {

            List<String> errorMessages = new ArrayList<>();


            for (ObjectError error :bindingResult.getAllErrors() ) {

                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);



            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);


            response.setViewName("user/register");
            return response;
        }

        User user = userDao.findById(form.getId());

        if (user == null ) {
            user = new User();
        }

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
//        user.setPassword(form.getPassword());
        user.setZip(form.getZip());
        user.setDescription(form.getDescription());
        user.setFavoritePlaceForPlaydates(form.getFavoritePlaceForPlaydates());


        String password = passwordEncoder.encode((form.getPassword()));
        user.setPassword(password);


        userDao.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");

        userRoleDao.save(userRole);


        log.info(form.toString());

        Child child = new Child();

        child.setFirstName(childForm.getChildFirstName());
        child.setLastName(childForm.getChildLastName());
        child.setAge(childForm.getChildAge());
        child.setUserId(user.getId());

        childDao.save(child);

        log.info(childForm.toString());

//        response.setViewName("redirect:/user/edit/" + user.getId());

        response.setViewName(("redirect:/login/login"));
        return response;
    }

    @GetMapping(value = "/user/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDao.findById(userId);
        Child child = childDao.findByUserId(userId);

        RegisterFormBean form = new RegisterFormBean();

        AddChildFormBean childForm = new AddChildFormBean();

        form.setId(user.getId()); //this is a hidden value - used to populate in the JSP
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setZip(user.getZip());
        form.setDescription(user.getDescription());
        form.setFavoritePlaceForPlaydates(user.getFavoritePlaceForPlaydates());

        childForm.setChildFirstName(child.getFirstName());
        childForm.setChildLastName(child.getLastName());
        childForm.setChildAge(child.getAge());

        response.addObject("form", form);
        response.addObject("childForm", childForm);

        return response;
    }

    @GetMapping(value = "/user/search")
    public ModelAndView search(@RequestParam(name = "searchId", required = false, defaultValue = "") String searchFirstName){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");
        log.info(searchFirstName);
//        String search = "a";

        // very basic example of error checking
//        if ( searchFirstName != null && ! searchFirstName.equals("")){

        if(!StringUtils.isBlank(searchFirstName)){
            List<User> users = userDao.findByFirstNameContainingIgnoreCase(searchFirstName);
            response.addObject("users", users);

        }else {
            searchFirstName = "Search";
        }

        response.addObject("searchValue", searchFirstName);

        return response;
    }



//    Takes You to the User Profile After Login
    @GetMapping(value = "/user/profile")
    public ModelAndView profile(@RequestParam(name = "searchId", required = false, defaultValue = "") String searchFirstName){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/profile");


        return response;
    }


    }
















