package com.example.genealogyback.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ErrorDto
 */

@JsonTypeName("Error")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-26T01:27:15.406096200+03:00[Europe/Moscow]")
public class ErrorDto {

  private String title;

  private String detail;

  private Integer errorCode;

  private String exception;

  private String stacktrace;

  public ErrorDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorDto(String title, String detail) {
    this.title = title;
    this.detail = detail;
  }

  public ErrorDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Краткое описание проблемы, понятное человеку
   * @return title
  */
  @NotNull 
  @Schema(name = "title", example = "Entity not found", description = "Краткое описание проблемы, понятное человеку", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ErrorDto detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * Описание конкретно возникшей ошибки, понятное человеку
   * @return detail
  */
  @NotNull 
  @Schema(name = "detail", example = "Entity [Post] with id = [123456] not found. You MUST use POST to add entity instead of PUT", description = "Описание конкретно возникшей ошибки, понятное человеку", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public ErrorDto errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Код ошибки по бизнес логике приложения
   * @return errorCode
  */
  
  @Schema(name = "errorCode", example = "57", description = "Код ошибки по бизнес логике приложения", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorCode")
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public ErrorDto exception(String exception) {
    this.exception = exception;
    return this;
  }

  /**
   * Тип ошибки
   * @return exception
  */
  
  @Schema(name = "exception", example = "NullPointerException", description = "Тип ошибки", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("exception")
  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public ErrorDto stacktrace(String stacktrace) {
    this.stacktrace = stacktrace;
    return this;
  }

  /**
   * Stacktrace в случае возникновения на сервере исключения
   * @return stacktrace
  */
  
  @Schema(name = "stacktrace", example = "...", description = "Stacktrace в случае возникновения на сервере исключения", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stacktrace")
  public String getStacktrace() {
    return stacktrace;
  }

  public void setStacktrace(String stacktrace) {
    this.stacktrace = stacktrace;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDto error = (ErrorDto) o;
    return Objects.equals(this.title, error.title) &&
        Objects.equals(this.detail, error.detail) &&
        Objects.equals(this.errorCode, error.errorCode) &&
        Objects.equals(this.exception, error.exception) &&
        Objects.equals(this.stacktrace, error.stacktrace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, detail, errorCode, exception, stacktrace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDto {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
    sb.append("    stacktrace: ").append(toIndentedString(stacktrace)).append("\n");
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

