package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.taglibs.standard.lang.jstl.IntegerLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.ChildDAO;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import java.util.List;

@Slf4j
@Controller

public class ChildController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    ChildDAO childDao;



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
}
