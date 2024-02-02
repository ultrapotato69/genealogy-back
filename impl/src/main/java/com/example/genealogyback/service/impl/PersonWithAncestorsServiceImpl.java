package com.example.genealogyback.service.impl;

import com.example.genealogyback.dto.PersonWithAncestorsDto;
import com.example.genealogyback.exception.NoSuchResourceException;
import com.example.genealogyback.repository.PersonWithAncestorsRepository;
import com.example.genealogyback.repository.projection.PersonWithAncestorsProjection;
import com.example.genealogyback.service.PersonWithAncestorsService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonWithAncestorsServiceImpl implements PersonWithAncestorsService {


    private final PersonWithAncestorsRepository repository;

    public PersonWithAncestorsServiceImpl(PersonWithAncestorsRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonWithAncestorsDto get(UUID id) {
        List<PersonWithAncestorsProjection> personList = repository.get(id);
        if (personList == null || personList.isEmpty()) {
            throw new NoSuchResourceException("Person with [%s] is not found.".formatted(id));
        }
        return buildTree(personList);
    }

    @Override
    public PersonWithAncestorsDto buildTree(List<PersonWithAncestorsProjection> personList) {
        Map<UUID, List<PersonWithAncestorsDto>> parents = personList.stream()
                .collect(Collectors.toMap(
                        PersonWithAncestorsProjection::getChildId,
                        person -> {
                            List<PersonWithAncestorsDto> list = new ArrayList<>();
                            PersonWithAncestorsDto personWithAncestors = new PersonWithAncestorsDto();
                            personWithAncestors.setId(person.getId());
                            personWithAncestors.setFirstName(person.getFirstName());
                            personWithAncestors.setSurname(person.getSurname());
                            personWithAncestors.setGender(person.getGender());
                            personWithAncestors.setSpouseId(person.getSpouseId());
                            personWithAncestors.setMaidenName(person.getMaidenName());
                            personWithAncestors.setBirthDate(person.getBirthDate());
                            personWithAncestors.setDeathDate(person.getDeathDate());
                            personWithAncestors.setBio(person.getBio());
                            personWithAncestors.setAvatar(person.getAvatar());
                            personWithAncestors.setTreeOwner(person.getChildId() == null);

                            list.add(personWithAncestors);
                            return list;
                        },
                        (left, right) -> {
                            left.addAll(right);
                            return left;
                        },
                        HashMap::new));


        for (Map.Entry<UUID, List<PersonWithAncestorsDto>> parentsEntry : parents.entrySet()) {
            for (PersonWithAncestorsDto person : parentsEntry.getValue()) {
                List<PersonWithAncestorsDto> parentsPerson = parents.get(person.getId());
                person.setParents(parentsPerson);
            }
        }

        return parents.get(null).getFirst();
    }
}
