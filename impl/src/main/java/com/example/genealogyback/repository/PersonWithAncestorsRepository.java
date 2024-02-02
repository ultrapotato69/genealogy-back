package com.example.genealogyback.repository;

import com.example.genealogyback.repository.projection.PersonWithAncestorsProjection;

import java.util.List;
import java.util.UUID;

public interface PersonWithAncestorsRepository {

    List<PersonWithAncestorsProjection> get(UUID id);
}