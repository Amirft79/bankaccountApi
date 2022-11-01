package ir.cactus.restspringapi.mapper;

import ir.cactus.restspringapi.dto.CustomersEntityDto;
import ir.cactus.restspringapi.model.CustomersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    @Mapping(source = "customerName", target = "customerName")
    CustomersEntityDto modelToDto(CustomersEntity customersEntity);


    List<CustomersEntityDto> modelsToDtos(List<CustomersEntity> commerces);
}
