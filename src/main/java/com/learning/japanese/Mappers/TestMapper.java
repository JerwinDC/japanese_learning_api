package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.AddTestResponse;
import com.learning.japanese.Entities.Test;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface TestMapper {

    AddTestResponse toDto(Test test);

}
