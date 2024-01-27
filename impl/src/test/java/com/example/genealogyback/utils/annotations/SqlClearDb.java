package com.example.genealogyback.utils.annotations;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.lang.annotation.*;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Sql({"/sql/clear-all.sql"})
@Sql(value = {"/sql/clear-all.sql"}, executionPhase = AFTER_TEST_METHOD)
@SqlMergeMode(value = SqlMergeMode.MergeMode.MERGE)
public @interface SqlClearDb {
}
