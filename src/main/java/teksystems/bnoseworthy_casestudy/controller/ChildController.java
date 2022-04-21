package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
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
import teksystems.bnoseworthy_casestudy.formbean.AddChildFormBean;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ChildController {


    @Autowired
    private ChildDAO childDao;


    @Autowired
    private UserDAO userDao;


    /**
     * Search results by child age. Seems to be working
     */
    @GetMapping(value = "/child/search")
    public ModelAndView search(@RequestParam(name = "searchId", required = false, defaultValue = "") Integer searchByAge) {
        ModelAndView response = new ModelAndView();
        response.setViewName("child/search");
        log.info(String.valueOf(searchByAge));

        if (searchByAge != null) {
            List<Child> users = childDao.findByAge(searchByAge);
            response.addObject("users", users);

        } else {
            searchByAge = 0;
        }

        response.addObject("searchValue", searchByAge);

        return response;
    }


    @RequestMapping(value = "/child/add", method = RequestMethod.GET)
    public ModelAndView addChild() {
        ModelAndView response = new ModelAndView();
        response.setViewName("child/add");

        AddChildFormBean childForm = new AddChildFormBean();
        response.addObject("childForm", childForm);

        return response;
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/child/addsubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addChildSubmit(@Valid AddChildFormBean childForm, BindingResult bindingResult) {
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

            response.setViewName("child/add");

            return response;
        }

        Child child = new Child();

        child.setFirstName(childForm.getChildFirstName());
        child.setLastName(childForm.getChildLastName());
        child.setAge(childForm.getChildAge());

        if (childForm.getImage() == "") {
            child.setImage("https://images.pexels.com/photos/6284647/pexels-photo-6284647.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        } else
            child.setImage(childForm.getImage().trim());
        child.setAbout(childForm.getAbout().trim());


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userDao.findByEmail(username);

        child.setUserId(user.getId());
        childDao.save(child);

        log.info("Child Added to Account: " + child);

        response.setViewName("redirect:/user/mychildren");
        return response;
    }


    @RequestMapping(value = "/user/mychildren", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView viewUserChildren() {
        ModelAndView response = new ModelAndView();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        User user = userDao.findByEmail(username);
        List<Child> children = childDao.findChildrenByUserId(user.getId());
        response.addObject("children", children);

        children.forEach((child) -> log.info("Child Name: " + child.getFirstName() + " Age: " + child.getAge()));

        return response;

    }

    @Transactional
    @RequestMapping(value = "/user/removechild", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView removeChild(@RequestParam(name = "childId", required = false) Integer childId) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info("Child being removed - Child ID: " + childId);
        childDao.deleteById(childId);

        response.setViewName("redirect:/user/mychildren");

        return response;

    }

}
