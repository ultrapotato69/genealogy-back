package com.example.genealogyback.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-18T15:20:34.794267600+03:00[Europe/Moscow]")
public class Error {

  private String title;

  private String detail;

  private String request;

  private String time;

  private String errorTraceId;

  private Integer errorCode;

  private String exception;

  private String stacktrace;

  private String causeException;

  private String causeStacketrace;

  public Error() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Error(String title, String detail, String request, String time, String errorTraceId) {
    this.title = title;
    this.detail = detail;
    this.request = request;
    this.time = time;
    this.errorTraceId = errorTraceId;
  }

  public Error title(String title) {
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

  public Error detail(String detail) {
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

  public Error request(String request) {
    this.request = request;
    return this;
  }

  /**
   * Метод и URL запроса
   * @return request
  */
  @NotNull 
  @Schema(name = "request", example = "PUT /posts/123456", description = "Метод и URL запроса", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("request")
  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public Error time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Время возникновения ошибки с точностью до миллисекунд
   * @return time
  */
  @NotNull 
  @Schema(name = "time", example = "1996-12-20T00:39:57.870Z", description = "Время возникновения ошибки с точностью до миллисекунд", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("time")
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Error errorTraceId(String errorTraceId) {
    this.errorTraceId = errorTraceId;
    return this;
  }

  /**
   * Идентификатор конкретного возникновения ошибки
   * @return errorTraceId
  */
  @NotNull 
  @Schema(name = "errorTraceId", example = "ce1ff211-b5dd-4397-b8a8-3f640705efa2", description = "Идентификатор конкретного возникновения ошибки", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errorTraceId")
  public String getErrorTraceId() {
    return errorTraceId;
  }

  public void setErrorTraceId(String errorTraceId) {
    this.errorTraceId = errorTraceId;
  }

  public Error errorCode(Integer errorCode) {
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

  public Error exception(String exception) {
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

  public Error stacktrace(String stacktrace) {
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

  public Error causeException(String causeException) {
    this.causeException = causeException;
    return this;
  }

  /**
   * Тип первоначального исключения
   * @return causeException
  */
  
  @Schema(name = "causeException", example = "...", description = "Тип первоначального исключения", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("causeException")
  public String getCauseException() {
    return causeException;
  }

  public void setCauseException(String causeException) {
    this.causeException = causeException;
  }

  public Error causeStacketrace(String causeStacketrace) {
    this.causeStacketrace = causeStacketrace;
    return this;
  }

  /**
   * Stacktrace первоначального исключения
   * @return causeStacketrace
  */
  
  @Schema(name = "causeStacketrace", example = "...", description = "Stacktrace первоначального исключения", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("causeStacketrace")
  public String getCauseStacketrace() {
    return causeStacketrace;
  }

  public void setCauseStacketrace(String causeStacketrace) {
    this.causeStacketrace = causeStacketrace;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.title, error.title) &&
        Objects.equals(this.detail, error.detail) &&
        Objects.equals(this.request, error.request) &&
        Objects.equals(this.time, error.time) &&
        Objects.equals(this.errorTraceId, error.errorTraceId) &&
        Objects.equals(this.errorCode, error.errorCode) &&
        Objects.equals(this.exception, error.exception) &&
        Objects.equals(this.stacktrace, error.stacktrace) &&
        Objects.equals(this.causeException, error.causeException) &&
        Objects.equals(this.causeStacketrace, error.causeStacketrace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, detail, request, time, errorTraceId, errorCode, exception, stacktrace, causeException, causeStacketrace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    errorTraceId: ").append(toIndentedString(errorTraceId)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
    sb.append("    stacktrace: ").append(toIndentedString(stacktrace)).append("\n");
    sb.append("    causeException: ").append(toIndentedString(causeException)).append("\n");
    sb.append("    causeStacketrace: ").append(toIndentedString(causeStacketrace)).append("\n");
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

