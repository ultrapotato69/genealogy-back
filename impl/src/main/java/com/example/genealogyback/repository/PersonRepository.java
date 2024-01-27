package com.example.genealogyback.repository;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.ResponsePersonDto;

import java.util.UUID;

public interface PersonRepository {
    ResponsePersonDto insert(BasePersonDto personDto);

    ResponsePersonDto readById(UUID id);

    ResponsePersonDto update(UUID id, BasePersonDto basePersonDto);

    void deleteById(UUID id);
}
