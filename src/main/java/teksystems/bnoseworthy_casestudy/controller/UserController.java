package teksystems.bnoseworthy_casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.*;
import teksystems.bnoseworthy_casestudy.database.entity.*;
import teksystems.bnoseworthy_casestudy.formbean.AddChildFormBean;
import teksystems.bnoseworthy_casestudy.formbean.AddChildToPlaydatePostFormBean;
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;


    @Autowired
    private ChildDAO childDao;


    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PlaydatePostDAO playdatePostDao;

    @Autowired
    private ChildrenAttendingDAO childrenAttendingDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;





    @RequestMapping(value = "/login/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/register");

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/login/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
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

            response.setViewName("login/register");
            return response;
        }

        User user = userDao.findById(form.getId());

        if (user == null ) {
            user = new User();
        }

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
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

        response.setViewName(("redirect:/login/login"));
        return response;
    }

//    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping(value = "/login/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/register");

        User user = userDao.findById(userId);

        RegisterFormBean form = new RegisterFormBean();


        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setZip(user.getZip());
        form.setDescription(user.getDescription());
        form.setFavoritePlaceForPlaydates(user.getFavoritePlaceForPlaydates());

        response.addObject("form", form);

        return response;
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/user/search")
    public ModelAndView search(@RequestParam(name = "searchId", required = false, defaultValue = "") String searchFirstName){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");
        log.info(searchFirstName);

        if(!StringUtils.isBlank(searchFirstName)){
            List<User> users = userDao.findByFirstNameContainingIgnoreCase(searchFirstName);
            response.addObject("users", users);

        }else {
            searchFirstName = "Search";
        }

        response.addObject("searchValue", searchFirstName);

        return response;
    }


    @GetMapping(value = "/user/searchforplaydate")
    public ModelAndView playdateSearch(@RequestParam(name = "searchId", required = false, defaultValue = "") String searchLocation){
        ModelAndView response = new ModelAndView();
        response.setViewName("/user/searchforplaydate");
        log.info(searchLocation);


        if(!StringUtils.isBlank(searchLocation)){
            List<PlayDatePost> playDatePosts = playdatePostDao.findPlaydatePostsByLocationContainsOrderByPlaydateDateDesc(searchLocation);
            response.addObject("playDatePosts", playDatePosts);

        }else {
            searchLocation = "Search for Location";
        }

        response.addObject("searchValue", searchLocation);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);

        List<Child> userChild = childDao.findChildrenByUserId(user.getId());
        response.addObject("userChild", userChild);

        log.info(searchLocation);



        return response;
    }

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
        childrenAttending.setChildId(childDao.findById(childId));
        childrenAttending.setPlaydatePostId(playdatePostDao.findById(playdatepostId));
        log.info("hello");


        childrenAttendingDAO.save(childrenAttending);

        log.info(String.valueOf(childrenAttending));

        response.setViewName("user/searchforplaydate");



        return response;
    }



//







    //    Takes You to the User Profile After Login
    @GetMapping(value = "/user/profile")
    public ModelAndView profile(@RequestParam(name = "searchId", required = false, defaultValue = "") String searchFirstName){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/profile");


        return response;
    }



//    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/user/profile/{userId}")
    public ModelAndView userProfile(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/user/profile/{userId}");

        User user = userDao.findById(userId);
//        Child child = childDao.findByUserId(userId);

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
//        response.addObject("childForm", childForm);

        return response;
    }


}
















