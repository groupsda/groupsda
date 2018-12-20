package com.sda.project.bookinglist.controller;

import com.sda.project.bookinglist.service.NewsletterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@Data
@RestController("/api")
public class NewsletterRestController {

    @Autowired
private  NewsletterService newsletterService;


@GetMapping("/newsletter")
    public HttpStatus createNewsletter(@RequestParam("email")String email ) {
newsletterService.insertNewsletter(email);
return HttpStatus.OK;
    }
}
