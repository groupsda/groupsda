package com.sda.project.groupsda.repository;

import com.sda.project.groupsda.entity.AddressEntity;
import com.sda.project.groupsda.model.TopDestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    @Query("select new com.sda.project.groupsda.model.TopDestinationModel(count(a.city),a.city,a.country)"+
            "from AddressEntity a group by a.city,a.country order by count (a.city) desc")
    List<TopDestinationModel> findTopDestinations();
}
