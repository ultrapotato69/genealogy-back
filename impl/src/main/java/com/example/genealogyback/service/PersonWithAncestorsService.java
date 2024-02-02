package com.example.genealogyback.service;

import com.example.genealogyback.dto.PersonWithAncestorsDto;
import com.example.genealogyback.repository.projection.PersonWithAncestorsProjection;

import java.util.List;
import java.util.UUID;

public interface PersonWithAncestorsService {

    PersonWithAncestorsDto get(UUID id);

    PersonWithAncestorsDto buildTree(List<PersonWithAncestorsProjection> personList);
}
