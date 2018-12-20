package com.sda.project.bookinglist.repository;

import com.sda.project.bookinglist.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {


}
