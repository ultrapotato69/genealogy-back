package com.example.genealogyback.dto;

import java.net.URI;
import java.util.Objects;
import com.example.genealogyback.dto.GenderDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BasePersonDto
 */

@JsonTypeName("BasePerson")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-27T15:23:13.003773200+03:00[Europe/Moscow]")
public class BasePersonDto {

  private String firstName;

  private String surname;

  private GenderDto gender;

  private UUID spouseId;

  private String maidenName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate deathDate;

  private String bio;

  private String avatar;

  public BasePersonDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BasePersonDto(String firstName, String surname, GenderDto gender) {
    this.firstName = firstName;
    this.surname = surname;
    this.gender = gender;
  }

  public BasePersonDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @NotNull 
  @Schema(name = "firstName", example = "Елена", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public BasePersonDto surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  */
  @NotNull 
  @Schema(name = "surname", example = "Петрова", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public BasePersonDto gender(GenderDto gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @NotNull @Valid 
  @Schema(name = "gender", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("gender")
  public GenderDto getGender() {
    return gender;
  }

  public void setGender(GenderDto gender) {
    this.gender = gender;
  }

  public BasePersonDto spouseId(UUID spouseId) {
    this.spouseId = spouseId;
    return this;
  }

  /**
   * Идентификатор супруга/супруги
   * @return spouseId
  */
  @Valid 
  @Schema(name = "spouseId", example = "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4", description = "Идентификатор супруга/супруги", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("spouseId")
  public UUID getSpouseId() {
    return spouseId;
  }

  public void setSpouseId(UUID spouseId) {
    this.spouseId = spouseId;
  }

  public BasePersonDto maidenName(String maidenName) {
    this.maidenName = maidenName;
    return this;
  }

  /**
   * Get maidenName
   * @return maidenName
  */
  
  @Schema(name = "maidenName", example = "Смирнова", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maidenName")
  public String getMaidenName() {
    return maidenName;
  }

  public void setMaidenName(String maidenName) {
    this.maidenName = maidenName;
  }

  public BasePersonDto birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  */
  @Valid 
  @Schema(name = "birthDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("birthDate")
  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public BasePersonDto deathDate(LocalDate deathDate) {
    this.deathDate = deathDate;
    return this;
  }

  /**
   * Get deathDate
   * @return deathDate
  */
  @Valid 
  @Schema(name = "deathDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deathDate")
  public LocalDate getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(LocalDate deathDate) {
    this.deathDate = deathDate;
  }

  public BasePersonDto bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * Get bio
   * @return bio
  */
  
  @Schema(name = "bio", example = "Биография моего предка очень интересна", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public BasePersonDto avatar(String avatar) {
    this.avatar = avatar;
    return this;
  }

  /**
   * Get avatar
   * @return avatar
  */
  
  @Schema(name = "avatar", example = "https://sartur.sgu.ru/wp-content/uploads/2021/09/avatar1-1536x1536.png", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avatar")
  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasePersonDto basePerson = (BasePersonDto) o;
    return Objects.equals(this.firstName, basePerson.firstName) &&
        Objects.equals(this.surname, basePerson.surname) &&
        Objects.equals(this.gender, basePerson.gender) &&
        Objects.equals(this.spouseId, basePerson.spouseId) &&
        Objects.equals(this.maidenName, basePerson.maidenName) &&
        Objects.equals(this.birthDate, basePerson.birthDate) &&
        Objects.equals(this.deathDate, basePerson.deathDate) &&
        Objects.equals(this.bio, basePerson.bio) &&
        Objects.equals(this.avatar, basePerson.avatar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, surname, gender, spouseId, maidenName, birthDate, deathDate, bio, avatar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasePersonDto {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    spouseId: ").append(toIndentedString(spouseId)).append("\n");
    sb.append("    maidenName: ").append(toIndentedString(maidenName)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    deathDate: ").append(toIndentedString(deathDate)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
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

