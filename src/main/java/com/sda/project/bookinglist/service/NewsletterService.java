package com.sda.project.bookinglist.service;

import com.sda.project.bookinglist.entity.NewsletterEntity;
import com.sda.project.bookinglist.model.NewsletterModel;
import com.sda.project.bookinglist.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsletterService {
    @Autowired
    private NewsletterRepository newsletterRepository;

    public void insertNewsletter(final String email){
        Optional <NewsletterEntity> newsletterEntity = newsletterRepository.findByEmail(email);


       if (!newsletterEntity.isPresent()){

           newsletterRepository.save(NewsletterEntity.builder().email(email).build());
    }
    }
public List<NewsletterModel> getAllNewsletters(){
        List<NewsletterEntity> newsletterEntities = newsletterRepository.findAll();
        return null;
}

}
