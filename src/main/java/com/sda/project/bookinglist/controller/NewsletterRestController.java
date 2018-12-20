package com.sda.project.bookinglist.controller;

import com.sda.project.bookinglist.entity.NewsletterEntity;
import com.sda.project.bookinglist.repository.NewsletterRepository;
import com.sda.project.bookinglist.service.NewsletterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

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
    public HttpStatus addNewsletter(@RequestParam("email")final String email){
    newsletterService.insertNewsletter(email);
    return HttpStatus.OK;
    }


}
