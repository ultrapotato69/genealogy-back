package com.example.genealogyback.controller;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.ResponsePersonDto;
import com.example.genealogyback.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class PersonControllerImpl implements PersonApi {
    public PersonControllerImpl(NativeWebRequest nativeWebRequest, PersonService personService) {
        this.nativeWebRequest = nativeWebRequest;
        this.personService = personService;
    }

    private final NativeWebRequest nativeWebRequest;
    private final PersonService personService;


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(nativeWebRequest);
    }

    @Override
    public ResponseEntity<ResponsePersonDto> personIdGet(UUID id) {
        log.info("Request for reading person with id: {}", id);
        return ResponseEntity.ok(personService.readById(id));
    }

    @Override
    public ResponseEntity<ResponsePersonDto> personPost(BasePersonDto personDto) {
        log.info("Request for creating person: {}", personDto);

        ResponsePersonDto createdPerson = personService.create(personDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPerson.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdPerson);
    }


}
