package com.example.genealogyback.controller;

import com.example.genealogyback.dto.PersonWithAncestorsDto;
import com.example.genealogyback.service.PersonWithAncestorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class PersonWithAncestorsControllerImpl implements PersonWithAncestorsApi {


    private final NativeWebRequest nativeWebRequest;
    private final PersonWithAncestorsService personWithAncestorsService;

    public PersonWithAncestorsControllerImpl(NativeWebRequest nativeWebRequest,
                                             PersonWithAncestorsService personWithAncestorsService) {
        this.nativeWebRequest = nativeWebRequest;
        this.personWithAncestorsService = personWithAncestorsService;
    }


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(nativeWebRequest);
    }

    @Override
    public ResponseEntity<PersonWithAncestorsDto> personIdAncestorsGet(UUID id) {
        log.info("Request for reading person with Ancestors with id: {}", id);

        PersonWithAncestorsDto person = personWithAncestorsService.get(id);
        return ResponseEntity.ok(person);
    }

}
