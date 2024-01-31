package com.example.genealogyback.service.impl;

import com.example.genealogyback.dto.ParentsDto;
import com.example.genealogyback.repository.ParentsRepository;
import com.example.genealogyback.service.ParentsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParentsServiceImpl implements ParentsService {

    private final ParentsRepository parentsRepository;

    public ParentsServiceImpl(ParentsRepository parentsRepository) {
        this.parentsRepository = parentsRepository;
    }

    @Override
    public ParentsDto addParent(UUID id, ParentsDto parentsDto) {
        return parentsRepository.insert(id, parentsDto);
    }

    @Override
    public void delete(UUID id, UUID parentId) {
        parentsRepository.delete(id, parentId);
    }
}
