package com.example.genealogyback.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * тип родителя
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-24T12:36:59.203769500+03:00[Europe/Moscow]")
public enum ParentTypeDto {
  
  MOTHER("mother"),
  
  FATHER("father");

  private String value;

  ParentTypeDto(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ParentTypeDto fromValue(String value) {
    for (ParentTypeDto b : ParentTypeDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

