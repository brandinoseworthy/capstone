package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.formbean.LoginFormBean;
import teksystems.bnoseworthy_casestudy.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class LoginController {


    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView login(@Valid LoginFormBean form, BindingResult bindingResult) throws Exception {

            ModelAndView response = new ModelAndView();

            if (bindingResult.hasErrors()) {

                List<String> errorMessages = new ArrayList<>();


                for (ObjectError error : bindingResult.getAllErrors()) {

                    errorMessages.add(error.getDefaultMessage());
                    log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
                }

                response.addObject("form", form);
                response.addObject("errorMessages", errorMessages);
                response.addObject("bindingResult", bindingResult);

            }

        response.setViewName("login/loginForm");

        return response;

        }

    }