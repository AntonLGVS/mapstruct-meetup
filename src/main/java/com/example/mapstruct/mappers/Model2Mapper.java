package com.example.mapstruct.mappers;

import com.example.mapstruct.dto.Model2DTO;
import com.example.mapstruct.dto.Model2DTOAbstract;
import com.example.mapstruct.dto.Model2DTOVariant;
import com.example.mapstruct.model.Model2;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface Model2Mapper {
    @BeanMapping(resultType = Model2DTOVariant.class)
    Model2DTOAbstract toModelResultVariant(Model2 model2);

    Model2DTO toModelDTO(Model2 model2);

    Model2DTOVariant toModelVariant(Model2 model2);

    @Named("inverse")
    @InheritInverseConfiguration(name = "toModelResultVariant")
    Model2 toModel2(Model2DTOAbstract dto);
}
