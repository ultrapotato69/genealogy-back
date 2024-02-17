package com.example.genealogyback.service;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.PersonWithRelativesDto;
import com.example.genealogyback.dto.ResponsePersonDto;

import java.util.UUID;

public interface PersonService {
    ResponsePersonDto create(BasePersonDto personDto);

    PersonWithRelativesDto readById(UUID id);

    ResponsePersonDto update(UUID id, BasePersonDto basePersonDto);

    void delete(UUID id);
}
