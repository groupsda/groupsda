package com.sda.project.bookinlist.controller;

import com.sda.project.bookinlist.model.NewsletterModel;
import com.sda.project.bookinlist.model.SearchPropertyModel;
import com.sda.project.bookinlist.model.TopDestinationModel;
import com.sda.project.bookinlist.service.AddressService;
import com.sda.project.bookinlist.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/newsletter")
    public ModelAndView indexPage() {
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        return new ModelAndView("redirect:/")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinationModels", topDestinationModels);
    }

    @PostMapping("/newsletter")
    public ModelAndView insertNewsletter(@ModelAttribute("email") final String email) {

        newsletterService.insertNewsletter(email);

        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        return new ModelAndView("redirect:/")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinationModels", topDestinationModels);
    }
}
