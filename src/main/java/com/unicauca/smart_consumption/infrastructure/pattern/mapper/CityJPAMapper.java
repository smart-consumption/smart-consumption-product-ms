package com.unicauca.smart_consumption.infrastructure.pattern.mapper;

import com.unicauca.smart_consumption.domain.city.City;
import com.unicauca.smart_consumption.infrastructure.modules.city.dataproviders.jpa.CityJPAEntity;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link CityJPAEntity} and {@link City}.
 * <p>The implementation of this interface is automatically generated by MapStruct during the build process, ensuring
 * that the mappings are efficient and error-free.</p>
 *
 * @see CityJPAEntity
 * @see City
 * @see EntityMapper
 */

@Mapper(componentModel = "spring")
public interface CityJPAMapper extends EntityMapper<CityJPAEntity, City> {
}
