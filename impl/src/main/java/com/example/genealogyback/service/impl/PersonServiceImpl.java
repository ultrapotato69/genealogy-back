package com.example.genealogyback.service.impl;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.PersonWithRelativesDto;
import com.example.genealogyback.dto.ResponsePersonDto;
import com.example.genealogyback.repository.PersonRepository;
import com.example.genealogyback.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;


    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public ResponsePersonDto create(BasePersonDto personDto) {
        return personRepository.insert(personDto);
    }

    @Override
    public PersonWithRelativesDto readById(UUID id) {
        PersonWithRelativesDto responsePersonDto = personRepository.readById(id);

        if (responsePersonDto.getSpouseId() != null) {
            responsePersonDto.setSpouse(personRepository.findSpouseById(id));
        }

        responsePersonDto.setChildren(personRepository.findChildrenById(id));
        responsePersonDto.setParents(personRepository.findParentsById(id));

        return responsePersonDto;
    }

    @Override
    public ResponsePersonDto update(UUID id, BasePersonDto basePersonDto) {
        return personRepository.update(id, basePersonDto);
    }

    @Override
    public void delete(UUID id) {
        personRepository.deleteById(id);
    }
}
