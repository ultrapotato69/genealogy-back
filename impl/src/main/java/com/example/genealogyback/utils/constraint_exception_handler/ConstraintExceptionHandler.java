package com.example.genealogyback.utils.constraint_exception_handler;

import com.example.genealogyback.exception.UndefinedRepoException;
import lombok.experimental.UtilityClass;
import org.postgresql.util.PSQLException;

import java.util.function.Supplier;

@UtilityClass
public class ConstraintExceptionHandler {

    public static void handleConstraintViolation(PSQLException psqlException) {

        if (psqlException != null && psqlException.getServerErrorMessage() != null) {

            String constraint = psqlException.getServerErrorMessage().getConstraint();
            Supplier<RuntimeException> supplierConstraintException = ConstraintsExceptionResponse
                    .constraintsMap.get(constraint);

            if (supplierConstraintException != null) {
                throw supplierConstraintException.get();
            }
        }

        throw new UndefinedRepoException("Ошибка при работе с базой данных.");
    }

}
