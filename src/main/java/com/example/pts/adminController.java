package com.example.pts;

import java.util.*;

import java.util.List;
import org.springframework.ui.Model;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin")
public class adminController {
    @Autowired
    ticketService temp;

    @ResponseBody
    @RequestMapping(value="",method=RequestMethod.POST)
//    @RequestMapping("/viewRecords")
    public ModelAndView report(){
        System.out.println("creating model");
        ModelAndView model = new ModelAndView("admin");
        System.out.println("creating model");
        List<RevenueData> revenuelist = temp.getRevenueByStationAndMonth();
        System.out.println(revenuelist.get(0).getRevenue());
        model.addObject("revenuelist",revenuelist);
        for(RevenueData x:revenuelist)
            System.out.println(x.toString());
        return model;
    }

//    @GetMapping("/list")
//    public String listRevenue(ticketModel model) {
//        List<RevenueData> revenuelist = temp.getRevenueByStationAndMonth();
//        model.addAttribute("employees", employees);
//        return "list-employees";
//    }
}