package teksystems.bnoseworthy_casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;


    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");



        return response;
    }


    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
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
        user.setPassword(form.getPassword());
        user.setZip(form.getZip());
        user.setDescription(form.getDescription());
        user.setFavoritePlaceForPlaydates(form.getFavoritePlaceForPlaydates());


        userDao.save(user);

        log.info(form.toString());

        response.setViewName("redirect:/user/edit/" + user.getId());

        return response;
    }

    @GetMapping(value = "/user/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDao.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId()); //this is a hidden value - used to populate in the JSP
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setZip(user.getZip());
        form.setDescription(user.getDescription());
        form.setFavoritePlaceForPlaydates(user.getFavoritePlaceForPlaydates());

        response.addObject("form", form);

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


    }




