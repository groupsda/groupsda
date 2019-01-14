package com.sda.project.bookinlist.repository;

import com.sda.project.bookinlist.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomPropertyRepository extends JpaRepository<AddressEntity, Long>, JpaSpecificationExecutor {
}
