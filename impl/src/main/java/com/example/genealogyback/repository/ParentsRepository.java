package com.example.genealogyback.repository;

import com.example.genealogyback.dto.ParentsDto;

import java.util.UUID;

public interface ParentsRepository {
    ParentsDto insert(UUID id, ParentsDto parentsDto);

    void delete(UUID id, UUID parentId);
}
