package com.sda.project.groupsda.controller;

import com.sda.project.groupsda.model.NewsletterModel;
import com.sda.project.groupsda.model.SearchPropertyModel;
import com.sda.project.groupsda.model.TopDestinationModel;
import com.sda.project.groupsda.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private AddressService addressService;
    @GetMapping("/")
    public ModelAndView indexPage() {
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestination();

        return new ModelAndView("index")
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinationModels",topDestinationModels)
                .addObject("searchPropertyModel", new SearchPropertyModel());

    }
    @GetMapping("/search")
    public ModelAndView searchProperty(@ModelAttribute SearchPropertyModel searchPropertyModel) {
        return new ModelAndView("result");
    }

    @GetMapping("/search/{city}")
    public ModelAndView searchPropertyByCity (@ModelAttribute String city) {
        return new ModelAndView("result");
    }
}