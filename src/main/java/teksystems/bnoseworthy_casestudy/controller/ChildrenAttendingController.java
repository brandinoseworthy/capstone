package teksystems.bnoseworthy_casestudy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.bnoseworthy_casestudy.database.dao.ChildDAO;
import teksystems.bnoseworthy_casestudy.database.dao.ChildrenAttendingDAO;
import teksystems.bnoseworthy_casestudy.database.dao.PlaydatePostDAO;

import teksystems.bnoseworthy_casestudy.database.entity.ChildrenAttending;

import java.util.List;

@Slf4j
@Controller
@ControllerAdvice
public class ChildrenAttendingController {

    @Autowired
    private ChildrenAttendingDAO childrenAttendingDao;

    @Autowired
    private ChildDAO childDao;

    @Autowired
    private PlaydatePostDAO playdatePostDao;


    @RequestMapping(value = "/playdatepost/addchildregister", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView playdateSearchRegisterChild(@RequestParam(name = "child", required = false) Integer childId,
                                                    @RequestParam(name = "playdatepost", required = false) Integer playdatepostId) throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("playdatepost/search");


        log.info("Child Id " + childId);
        log.info("PlaydatePost Id " + playdatepostId);

        ChildrenAttending childrenAttending = new ChildrenAttending();

        childrenAttending.setChild(childDao.findById(childId));
        childrenAttending.setPlaydatePost(playdatePostDao.findById(playdatepostId));

        childrenAttendingDao.save(childrenAttending);

        log.info("Child ID: " + " " + childId + " " + "is registered for Post ID: " + " " + playdatepostId);
        response.setViewName("playdatepost/childregistered");

        return response;
    }


    //    Not working yet
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/childrenattending/willbetheres/{playdatePostId}")
    public ModelAndView viewChildrenAttending(@PathVariable("playdatePostId") Integer playdatePostId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/childrenattending/willbetheres");

        log.info("PlaydatePost " + playdatePostId);
        List<ChildrenAttending> childAttending = childrenAttendingDao.findAll(playdatePostId);
        response.addObject("childAttendings", childAttending);

        return response;

    }

}
