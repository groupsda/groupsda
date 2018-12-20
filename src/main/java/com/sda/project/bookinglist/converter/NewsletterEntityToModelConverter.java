package com.sda.project.bookinglist.converter;


import com.sda.project.bookinglist.entity.NewsletterEntity;
import com.sda.project.bookinglist.model.NewsletterModel;
import org.springframework.stereotype.Component;

@Component
public class NewsletterEntityToModelConverter {

    public NewsletterModel toModelWithBuilder(final NewsletterEntity newsletterEntity){

        return NewsletterModel.builder().id(newsletterEntity.getId()).createdAt(newsletterEntity.getCreatedAt()).email(newsletterEntity.getEmail()).build();

    }

}
