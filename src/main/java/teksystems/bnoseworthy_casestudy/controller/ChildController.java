package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.taglibs.standard.lang.jstl.IntegerLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.ChildDAO;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.formbean.AddChildFormBean;
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;

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



    /**
     * Search results by child age. Seems to be working
     */
    @GetMapping(value = "/child/search")
    public ModelAndView search(@RequestParam(name = "searchId", required = false, defaultValue = "") Integer searchByAge){
        ModelAndView response = new ModelAndView();
        response.setViewName("child/search");
        log.info(String.valueOf(searchByAge));
//        String search = "a";

        // very basic example of error checking
//        if ( searchFirstName != null && ! searchFirstName.equals("")){

        if(searchByAge != null){
            List<Child> users = childDao.findByAge(searchByAge);
            response.addObject("users", users);


        }else {
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

}
