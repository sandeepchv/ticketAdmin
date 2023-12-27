package com.example.pts;

import java.util.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin")
public class adminController {
    @Autowired
    ticketServiceImplementation temp;

    @ResponseBody
    @RequestMapping(value="/finance",method=RequestMethod.POST)
    public ModelAndView report(){
        ModelAndView model = new ModelAndView("admin");
        List<RevenueData> revenuelist = temp.getRevenueByStationAndMonth();
        model.addObject("revenuelist",revenuelist);
        for(RevenueData x:revenuelist)
            System.out.println(x.toString());
        return model;
    }
}