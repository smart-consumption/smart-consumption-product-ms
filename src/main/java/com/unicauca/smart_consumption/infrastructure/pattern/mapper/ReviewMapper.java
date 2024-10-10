package com.unicauca.smart_consumption.infrastructure.pattern.mapper;

import com.unicauca.smart_consumption.domain.review.Review;
import com.unicauca.smart_consumption.infrastructure.pattern.dto.ReviewDto;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link ReviewDto} and {@link Review}.
 * <p>The implementation of this interface is automatically generated by Map Struct during the build process, ensuring
 * that the mappings are efficient and error-free.</p>
 *
 * @see ReviewDto
 * @see Review
 * @see EntityMapper
 */

@Mapper(componentModel = "spring" )
public interface ReviewMapper extends EntityMapper<ReviewDto, Review>{
}