package com.example.genealogyback.config.jooq;

import com.example.genealogyback.utils.constraint_exception_handler.ConstraintExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jetbrains.annotations.Nullable;
import org.jooq.ExecuteContext;
import org.jooq.ExecuteListener;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.SQLStateClass;
import org.postgresql.util.PSQLException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;


@Slf4j
public class ExceptionTranslator implements ExecuteListener {

    @Override
    public void exception(ExecuteContext context) {
        SQLDialect dialect = context.configuration().dialect();
        SQLExceptionTranslator translator = new SQLErrorCodeSQLExceptionTranslator(dialect.name());

        // Если запрос вернул несколько записей, а в коде попытка fetch-ить результат запроса в 1 объект, то context.sqlException() равен null
        if (context.exception() != null) {
            RuntimeException exception = context.exception();
            log.error(ExceptionUtils.getStackTrace(exception));

            handleDatabaseConstraintException(exception);
        }
        if (context.sqlException() != null) {
            context.exception(translator.translate("jOOQ", context.sql(), context.sqlException()));
        }
    }

    private void handleDatabaseConstraintException(@Nullable RuntimeException exception) {

        if (exception instanceof DataAccessException dataAccessException
                && SQLStateClass.C23_INTEGRITY_CONSTRAINT_VIOLATION == dataAccessException.sqlStateClass()
                && dataAccessException.getCause() instanceof PSQLException psqlException) {
            ConstraintExceptionHandler.handleConstraintViolation(psqlException);
        }
    }
}
