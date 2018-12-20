package com.sda.project.bookinglist.service;

import com.sda.project.bookinglist.converter.NewsletterEntityToModelConverter;
import com.sda.project.bookinglist.entity.NewsletterEntity;
import com.sda.project.bookinglist.model.NewsletterModel;
import com.sda.project.bookinglist.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsletterService {
    @Autowired
    private NewsletterRepository newsletterRepository;
    @Autowired
    private NewsletterEntityToModelConverter newsletterEntityToModelConverter;

    public void insertNewsletter(final String email){
        NewsletterEntity newsletterEntity = new NewsletterEntity();
        newsletterRepository.save(NewsletterEntity.builder().email(email).build());
    }

    public List<NewsletterModel> getAllNewsletters(){
        List<NewsletterEntity> newsletterEntities = newsletterRepository.findAll();
        List<NewsletterModel> newsletterModels = newsletterEntities.stream()
                .map(newsletterEntityToModelConverter::toModel).collect(Collectors.toList());
        return newsletterModels;
    }



}
