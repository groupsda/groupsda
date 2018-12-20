package com.sda.project.bookinglist.controller;

import com.sda.project.bookinglist.model.NewsletterModel;
import com.sda.project.bookinglist.service.NewsletterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;


@RestController
@RequestMapping("/api")
public class NewsletterRestController {

    @Autowired
private  NewsletterService newsletterService;


@GetMapping("/newsletter")
    public HttpStatus createNewsletter(@RequestParam("email")String email ) {
newsletterService.insertNewsletter(email);
return HttpStatus.OK;
    }

    @PostMapping(value = "/newsletter")
    public HttpStatus addNewsletter (@RequestParam("email") final String email) {
    newsletterService.insertNewsletter(email);
    return HttpStatus.OK;
    }

    @GetMapping(value = "/newsletter")
    public List<NewsletterModel> getAllNewsletters(){
    List<NewsletterModel> newsletterModels = newsletterService.getAllNewsletters();
    return newsletterModels;
    }


    @PutMapping(value = "/newsletter")
    public HttpStatus updateEmail(@RequestParam("email") final  String email){


    }
}
