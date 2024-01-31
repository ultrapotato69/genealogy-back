package com.example.genealogyback.utils.constraint_exception_handler;

import com.example.genealogyback.exception.NoSuchResourceException;
import com.example.genealogyback.exception.NonUniqueEntityException;
import com.example.genealogyback.exception.UnprocessableActionException;
import com.example.genealogyback.jooq.Keys;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.function.Supplier;

@UtilityClass
public class ConstraintsExceptionResponse {

    public static final Map<String, Supplier<RuntimeException>> constraintsMap = Map.ofEntries(

            Map.entry(Keys.ONE_PARENT_PER_TYPE_UNIQUE_CONSTRAINT.getName(),
                    () -> new NonUniqueEntityException("Parent of this type (father/mother) already exists for this person.")),
            Map.entry(Keys.PARENTS__PARENTS_CHILD_ID_FK.getName(),
                    () -> new NoSuchResourceException("No person with this id.")),
            Map.entry(Keys.PARENTS__PARENTS_PARENT_ID_FK.getName(),
                    () -> new UnprocessableActionException("No person with parent_id."))


    );
}
