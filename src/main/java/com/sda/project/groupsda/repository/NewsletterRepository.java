package com.sda.project.groupsda.repository;

import com.sda.project.groupsda.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {

    Optional<NewsletterEntity> findByEmail(final String email);

}
