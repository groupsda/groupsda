package com.sda.project.bookinlist.controller;

import com.sda.project.bookinlist.model.NewsletterModel;
import com.sda.project.bookinlist.model.PropertyModel;
import com.sda.project.bookinlist.model.SearchPropertyModel;
import com.sda.project.bookinlist.model.TopDestinationModel;
import com.sda.project.bookinlist.service.AddressService;
import com.sda.project.bookinlist.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/")
    public ModelAndView indexPage() {

        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        return new ModelAndView("index")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinationModels", topDestinationModels);
    }

    @GetMapping("/search")
    public ModelAndView searchProperty(@ModelAttribute SearchPropertyModel searchPropertyModel) {

        Page<PropertyModel> propertyModelPage = propertyService.getSearchedProperties(searchPropertyModel);

        return new ModelAndView("/" +
                "result")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("propertyModelPage", propertyModelPage);
    }
}
