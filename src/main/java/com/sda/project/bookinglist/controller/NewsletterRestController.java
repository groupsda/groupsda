package com.sda.project.bookinglist.controller;

import com.sda.project.bookinglist.model.NewsletterModel;
import com.sda.project.bookinglist.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = "/newsletter/{id}")
    public NewsletterModel getNewsletterById(@PathVariable("id") final Long id) {return newsletterService.getNewslettersById (id);
}

    @PostMapping(value = "/newsletter")
    public HttpStatus addNewsletter (@RequestParam("email") final String email) {
    newsletterService.insertNewsletter(email);
    return HttpStatus.OK;
    }

    @GetMapping(value = "/newsletters")
    public List<NewsletterModel> getAllNewsletters(){
    List<NewsletterModel> newsletterModels = newsletterService.getAllNewsletters();
    return newsletterModels;
    }


    @PutMapping(value = " /newsletter")
    public HttpStatus deleteNewsletterById(@Valid @RequestBody final NewsletterModel newsletterModel){
    newsletterService.updateNewsletter(newsletterModel);
    return HttpStatus.OK;
    }

    @DeleteMapping(value = "/newsletter/{id}")
    public HttpStatus deleteNewsletterById (@PathVariable("id") final Long id){
    newsletterService.deleteNewsletterById(id);
    return HttpStatus.OK;
    }
}