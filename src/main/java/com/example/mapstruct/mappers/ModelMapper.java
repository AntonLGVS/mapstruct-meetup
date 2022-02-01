package com.example.mapstruct.mappers;

import com.example.mapstruct.dto.DTO;
import com.example.mapstruct.dto.Model2DTO;
import com.example.mapstruct.dto.Model2DTOVariant;
import com.example.mapstruct.model.Model;
import org.mapstruct.*;

import java.util.Map;

@Mapper(componentModel = "spring",
        uses = Model2Mapper.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR
        )
//@MapperConfig() //additional configs
public interface ModelMapper {

    @Mapping(target = "bb", source = "b")
    @Mapping(source = "model2", target = "model2DTO", resultType = Model2DTOVariant.class)
    DTO toDTO(Model model, @Context Map<String, String> map);

    @Mapping(target = "bb", expression = "java(model.getB() * 12L)")
    @Mapping(source = "model2", target = "model2DTO", resultType = Model2DTO.class)
    DTO toDTOWithExpression(Model model);

    @InheritInverseConfiguration(name = "toDTO")
    @Mapping(source = "model2DTO", target = "model2", qualifiedByName = "inverse")
    Model toModel(DTO dto);

    @BeforeMapping
    default void valid(Model model) {
        // Do before mapping
        //Example: Check JSR-303 Bean Validation
    }

    @AfterMapping
    default void validAfterMapping(Model model) {
        // Do after mapping
    }
}

