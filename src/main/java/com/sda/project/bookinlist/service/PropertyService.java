package com.sda.project.bookinlist.service;

import com.sda.project.bookinlist.converter.SimpleEntityToModelConverter;
import com.sda.project.bookinlist.entity.AddressEntity;
import com.sda.project.bookinlist.entity.PropertyEntity;
import com.sda.project.bookinlist.model.PropertyModel;
import com.sda.project.bookinlist.model.SearchPropertyModel;
import com.sda.project.bookinlist.repository.CustomPropertyRepository;
import com.sda.project.bookinlist.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sda.project.bookinlist.repository.specification.PropertySpecification.prepareSearchPropertyQuery;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private SimpleEntityToModelConverter simpleEntityToModelConverter;

    @Autowired
    private CustomPropertyRepository customPropertyRepository;

    public PropertyModel getPropertyByPropertyIdAndAddressId(final Long propertyId, final Long addressId) {

        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyId);

        if (propertyEntity.isPresent()) {
            return simpleEntityToModelConverter.propertyEntityToModel(propertyEntity.get(), addressId);
        } else {
            throw new NullPointerException("You don't have selected property");
        }
    }

    public List<PropertyModel> getAllProperties() {
        return simpleEntityToModelConverter.propertyEntitiesToModels(propertyRepository.findAll());
    }

    public Page<PropertyModel> getSearchedProperties(final SearchPropertyModel searchPropertyModel) {

        List<AddressEntity> addressEntities = customPropertyRepository
                .findAll(prepareSearchPropertyQuery(searchPropertyModel));

        List<PropertyModel> propertyModels = simpleEntityToModelConverter
                .addressEntitiesToPropertyModels(addressEntities);

        return new PageImpl<>(propertyModels, PageRequest.of(0, 10), propertyModels.size());
    }
}
