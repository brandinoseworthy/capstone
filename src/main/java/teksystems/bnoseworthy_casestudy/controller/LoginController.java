package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserDAO userDAO;


    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();


        response.setViewName("login/loginForm");

        return response;
    }


//    @RequestMapping(value = ("/user/loginSubmit"), method = {RequestMethod.POST, RequestMethod.GET})
//    public ModelAndView loginSubmit(@Valid LoginBean form, BindingResult bindingResult) throws Exception {
//        ModelAndView response = new ModelAndView();
//
//        log.info(form.toString());
////        int i = 10 / 0;
//
//        if ( bindingResult.hasErrors() ) {
////            HashMap errors = new HashMap();
//
////            List<String> errorMessages = new ArrayList<>();
//
//            for (ObjectError error: bindingResult.getAllErrors() ){
////                errorMessages.add(error.getDefaultMessage());
//                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
//            }
//
//            response.addObject("form", form);
//            response.addObject("bindingResult", bindingResult);
//            response.setViewName("login/loginForm");
//
//            return response;
//
//
//        }
//
//        User user = userDAO.findByEmail(form.getEmail());
//
//        if ( user == null ){
////           ERROR
//            log.info("Error Found");
//
//        }
//
//
//        log.info(form.toString());
//
//        response.setViewName("redirect:/user/profile/" + user.getId());
//
//
//
//        return response;
//
//
//    }



}

