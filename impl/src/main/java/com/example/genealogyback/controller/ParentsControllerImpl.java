package com.example.genealogyback.controller;

import com.example.genealogyback.dto.ParentsDto;
import com.example.genealogyback.service.ParentsService;
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
public class ParentsControllerImpl implements ParentsApi {


    private final NativeWebRequest nativeWebRequest;
    private final ParentsService parentsService;

    public ParentsControllerImpl(NativeWebRequest nativeWebRequest, ParentsService parentsService) {
        this.nativeWebRequest = nativeWebRequest;
        this.parentsService = parentsService;
    }


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(nativeWebRequest);
    }

    @Override
    public ResponseEntity<Void> personIdParentsParentIdDelete(UUID id, UUID parentId) {
        log.info("Request for deleting parent with id: {} for person with id: {}", parentId, id);

        parentsService.delete(id, parentId);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ParentsDto> personIdParentsPost(UUID id, ParentsDto parentsDto) {
        log.info("Request for adding parent: {} to person: {}", parentsDto, id);

        ParentsDto created = parentsService.addParent(id, parentsDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).body(created);
    }
}
