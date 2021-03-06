package com.sda.project.bookinlist.controller;

import com.sda.project.bookinlist.model.NewsletterModel;
import com.sda.project.bookinlist.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class NewsletterRestController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping(value = "/newsletter")
    public HttpStatus createNewsletter(@RequestParam("email") final String email) {
        newsletterService.insertNewsletter(email);
        return HttpStatus.OK;
    }

    @PostMapping(value = "/newsletter")
    public HttpStatus addNewsletter(@RequestParam("email") final String email) {
        newsletterService.insertNewsletter(email);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/newsletter/{id}")
    public NewsletterModel getNewsletterById(@PathVariable("id") final Long id) {
        return newsletterService.getNewsletterById(id);
    }

    @GetMapping(value = "/newsletters")
    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterModel> newsletterModels = newsletterService.getAllNewsletters();
        return newsletterModels;
    }

    @PutMapping(value = "/newsletter")
    public HttpStatus updateNewsletterById(@Valid @RequestBody final NewsletterModel newsletterModel) {
        newsletterService.updateNewsletter(newsletterModel);
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/newsletter/{id}")
    public HttpStatus deleteNewsletterById(@PathVariable("id") final Long id) {
        newsletterService.deleteNewsletterById(id);
        return HttpStatus.OK;
    }
}
