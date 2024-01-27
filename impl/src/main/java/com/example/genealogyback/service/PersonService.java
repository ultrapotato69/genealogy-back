package com.example.genealogyback.service;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.ResponsePersonDto;

import java.util.UUID;

public interface PersonService {
    ResponsePersonDto create(BasePersonDto personDto);

    ResponsePersonDto readById(UUID id);
}
