package com.example.genealogyback.repository.projection;

import com.example.genealogyback.dto.GenderDto;
import com.example.genealogyback.dto.ParentTypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class PersonWithAncestorsProjection {
    private UUID id;

    private String firstName;

    private String surname;

    private GenderDto gender;

    private LocalDate birthDate;

    private UUID spouseId;

    private String maidenName;

    private LocalDate deathDate;

    private String bio;

    private String avatar;

    private UUID childId;

    private ParentTypeDto parentType;
}
