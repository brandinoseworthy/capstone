package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@ControllerAdvice
public class ChildrenAttendingController {



//    not working yet
    @RequestMapping(value = "/child/playdateSignup")
    public ModelAndView playdateSignup() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("child/playdateSignup");


        return response;
    }
}
