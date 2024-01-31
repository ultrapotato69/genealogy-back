package com.example.genealogyback.service;

import com.example.genealogyback.dto.ParentsDto;

import java.util.UUID;

public interface ParentsService {
    ParentsDto addParent(UUID id, ParentsDto parentsDto);

    void delete(UUID id, UUID parentId);
}
