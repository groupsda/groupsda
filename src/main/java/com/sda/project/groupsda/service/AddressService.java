package com.sda.project.groupsda.service;

import com.sda.project.groupsda.model.TopDestinationModel;
import com.sda.project.groupsda.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<TopDestinationModel> getTopDestination(){
        List<TopDestinationModel> topDestinationModels = addressRepository.findTopDestinations();
        return topDestinationModels.size() > 8? topDestinationModels.subList(0,7) : topDestinationModels;

    }

}
