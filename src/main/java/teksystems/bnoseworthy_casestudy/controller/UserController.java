package teksystems.bnoseworthy_casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;

import javax.transaction.Transactional;
import javax.validation.Valid;
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

        if (form.getImageURL() == ""){
            user.setProfileImg("https://images.pexels.com/photos/6284647/pexels-photo-6284647.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        } else
            user.setProfileImg(form.getImageURL().trim());

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


    // half working...........

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
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


    // working on a native query and then I want to be able to delete accounts
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/user/search")
    public ModelAndView search(){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

            List<UserRole> users = userRoleDao.findByUserRole();
            response.addObject("users", users);

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




    //    Takes You to the User Profile After Login
    @GetMapping(value = "/user/profile")
    public ModelAndView profile(@RequestParam(name = "searchId", required = false, defaultValue = "") String searchFirstName){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/profile");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setZip(user.getZip());
        form.setDescription(user.getDescription());
        form.setFavoritePlaceForPlaydates(user.getFavoritePlaceForPlaydates());

        form.setImageURL(user.getProfileImg());

        response.addObject("form", form);

        return response;

    }


// does nothing right now
//    @PreAuthorize("hasAuthority('USER')")
//    @GetMapping(value = "/user/profile/{userId}")
//    public ModelAndView userProfile(@PathVariable("userId") Integer userId) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("/user/profile");
//
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
//
//        return response;
//
//    }


}
















