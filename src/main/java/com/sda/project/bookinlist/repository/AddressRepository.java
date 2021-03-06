package com.sda.project.bookinlist.repository;

import com.sda.project.bookinlist.entity.AddressEntity;
import com.sda.project.bookinlist.model.TopDestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("select new com.sda.project.bookinlist.model.TopDestinationModel(" +
            "count(distinct a.room.property),a.city,a.country) " +
            "from AddressEntity a group by a.city,a.country order by count(distinct a.room.property) desc")
    List<TopDestinationModel> findTopDestinations();
}
