package teksystems.bnoseworthy_casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

//        log.debug("lombok logging at debug level");
//        log.info("lombok logging at info level");
//        log.warn("lombok logging at warn level");
//
//        List<User> users = userDao.findByFirstNameContainingIgnoreCase("Brandi");
//
//        for ( User user : users ){
//            log.debug(user.toString());
//        }

        response.setViewName("index");

        return response;
    }


}
