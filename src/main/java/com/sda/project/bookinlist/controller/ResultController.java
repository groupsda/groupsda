package com.sda.project.bookinlist.controller;

import com.sda.project.bookinlist.model.PropertyModel;
import com.sda.project.bookinlist.model.SearchPropertyModel;
import com.sda.project.bookinlist.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/search/property/{propertyId}/address/{addressId}")
    public ModelAndView searchPropertyById(@PathVariable("propertyId") Long propertyId,
                                           @PathVariable("addressId") Long addressId) {

        PropertyModel propertyModel = propertyService.getPropertyByPropertyIdAndAddressId(propertyId, addressId);

        return new ModelAndView("property-detail")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("propertyModel", propertyModel);
    }
}
