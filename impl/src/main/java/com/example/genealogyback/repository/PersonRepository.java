package com.example.genealogyback.repository;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.PersonWithRelativesDto;
import com.example.genealogyback.dto.RelativeDto;
import com.example.genealogyback.dto.ResponsePersonDto;

import java.util.List;
import java.util.UUID;

public interface PersonRepository {
    ResponsePersonDto insert(BasePersonDto personDto);

    PersonWithRelativesDto readById(UUID id);

    ResponsePersonDto update(UUID id, BasePersonDto basePersonDto);

    void deleteById(UUID id);

    RelativeDto findSpouseById(UUID id);

    List<RelativeDto> findChildrenById(UUID id);

    List<RelativeDto> findParentsById(UUID id);
}
