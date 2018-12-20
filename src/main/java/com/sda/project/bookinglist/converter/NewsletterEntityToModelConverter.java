package com.sda.project.bookinglist.converter;

import com.sda.project.bookinglist.entity.NewsletterEntity;
import com.sda.project.bookinglist.model.NewsletterModel;
import org.springframework.stereotype.Component;

@Component
public class NewsletterEntityToModelConverter {

    public NewsletterModel toMode(final NewsletterEntity newsletterEntity){
        NewsletterModel newsletterModel = new NewsletterModel();
        newsletterModel.setId(newsletterEntity.getId());
        newsletterModel.setCreatedAt(newsletterEntity.getCreatedAt());
        newsletterModel.setEmail(newsletterEntity.getEmail());
        return newsletterModel;
    }


}
