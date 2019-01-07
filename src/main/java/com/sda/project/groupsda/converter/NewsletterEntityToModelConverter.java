package com.sda.project.groupsda.converter;


import com.sda.project.groupsda.entity.NewsletterEntity;
import com.sda.project.groupsda.model.NewsletterModel;
import org.springframework.stereotype.Component;

@Component
public class NewsletterEntityToModelConverter {

    public NewsletterModel toModel(final NewsletterEntity newsletterEntity){

        return NewsletterModel.builder().id(newsletterEntity.getId()).createdAt(newsletterEntity.
                getCreatedAt()).email(newsletterEntity.getEmail()).build();

    }

}
