package com.example.library.mapper;

import com.example.library.dto.SimpleBook;
import com.example.library.model.Book;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapperMapStruct {

    SimpleBook toSimpleBook(Book book);
}
