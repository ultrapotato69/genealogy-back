package com.example.genealogyback.dto;

import java.net.URI;
import java.util.Objects;
import com.example.genealogyback.dto.ParentTypeDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ParentsDto
 */

@JsonTypeName("Parents")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-26T01:27:15.406096200+03:00[Europe/Moscow]")
public class ParentsDto {

  private UUID id;

  private ParentTypeDto parentType;

  public ParentsDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ParentsDto(ParentTypeDto parentType) {
    this.parentType = parentType;
  }

  public ParentsDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор карточки родителя
   * @return id
  */
  @Valid 
  @Schema(name = "id", example = "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4", description = "Идентификатор карточки родителя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ParentsDto parentType(ParentTypeDto parentType) {
    this.parentType = parentType;
    return this;
  }

  /**
   * Get parentType
   * @return parentType
  */
  @NotNull @Valid 
  @Schema(name = "parentType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parentType")
  public ParentTypeDto getParentType() {
    return parentType;
  }

  public void setParentType(ParentTypeDto parentType) {
    this.parentType = parentType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParentsDto parents = (ParentsDto) o;
    return Objects.equals(this.id, parents.id) &&
        Objects.equals(this.parentType, parents.parentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parentType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParentsDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    parentType: ").append(toIndentedString(parentType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

