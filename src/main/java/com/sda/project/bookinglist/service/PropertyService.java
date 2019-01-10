package com.sda.project.bookinglist.service;

import com.sda.project.bookinglist.converter.SimpleEntityToModelConverter;
import com.sda.project.bookinglist.entity.AddressEntity;
import com.sda.project.bookinglist.entity.PropertyEntity;
import com.sda.project.bookinglist.model.PropertyModel;
import com.sda.project.bookinglist.model.SearchPropertyModel;
import com.sda.project.bookinglist.repository.CustomPropertyRepository;
import com.sda.project.bookinglist.repository.PropertyRepository;
import com.sda.project.bookinglist.repository.specification.PropertySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private SimpleEntityToModelConverter simpleEntityToModelConverter;

    @Autowired
    private CustomPropertyRepository customPropertyRepository;

    public PropertyModel getPropertyById(final Long propertyId){
     Optional<PropertyEntity> propertyEntity = PropertyRepository
        return propertyRepository.findAllById(propertyId);
    }

    public List<PropertyModel> getAllProperties() {
        return simpleEntityToModelConverter.propertyEntitiesToModels(propertyRepository.findAll());
    }

    public Page<PropertyModel> getSearchedProperties(final SearchPropertyModel searchPropertyModel) {

        List<AddressEntity> addressEntities = customPropertyRepository
                .findAll(PropertySpecification.prepareSearchPropertyQuery(searchPropertyModel));

        List<PropertyModel> propertyModels = simpleEntityToModelConverter
                .addressEntitiesToPropertyModels(addressEntities);

        return new PageImpl<>(propertyModels, PageRequest.of(0, 10), propertyModels.size());
    }
}