package com.example.genealogyback.dto;

import java.net.URI;
import java.util.Objects;
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
 * PersonDto
 */

@JsonTypeName("Person")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-20T11:31:35.011117+03:00[Europe/Moscow]")
public class PersonDto {

  private String firstName;

  private String surname;

  private String maidenName;

  /**
   * Gets or Sets gender
   */
  public enum GenderEnum {
    MALE("male"),
    
    FEMALE("female");

    private String value;

    GenderEnum(String value) {
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
    public static GenderEnum fromValue(String value) {
      for (GenderEnum b : GenderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private GenderEnum gender;

  private String birthDate;

  private String dearthDate;

  private String bio;

  private String avatar;

  private UUID spouseId;

  public PersonDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PersonDto(String firstName, String surname, String maidenName, GenderEnum gender, String birthDate, String dearthDate, String bio, String avatar, UUID spouseId) {
    this.firstName = firstName;
    this.surname = surname;
    this.maidenName = maidenName;
    this.gender = gender;
    this.birthDate = birthDate;
    this.dearthDate = dearthDate;
    this.bio = bio;
    this.avatar = avatar;
    this.spouseId = spouseId;
  }

  public PersonDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @NotNull 
  @Schema(name = "firstName", example = "Ivan", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PersonDto surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  */
  @NotNull 
  @Schema(name = "surname", example = "Petrov", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public PersonDto maidenName(String maidenName) {
    this.maidenName = maidenName;
    return this;
  }

  /**
   * Get maidenName
   * @return maidenName
  */
  @NotNull 
  @Schema(name = "maidenName", example = "Smirnova", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("maidenName")
  public String getMaidenName() {
    return maidenName;
  }

  public void setMaidenName(String maidenName) {
    this.maidenName = maidenName;
  }

  public PersonDto gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @NotNull 
  @Schema(name = "gender", example = "male", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("gender")
  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public PersonDto birthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  */
  @NotNull 
  @Schema(name = "birthDate", example = "05.03.1917", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("birthDate")
  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public PersonDto dearthDate(String dearthDate) {
    this.dearthDate = dearthDate;
    return this;
  }

  /**
   * Get dearthDate
   * @return dearthDate
  */
  @NotNull 
  @Schema(name = "dearthDate", example = "05.03.1917", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dearthDate")
  public String getDearthDate() {
    return dearthDate;
  }

  public void setDearthDate(String dearthDate) {
    this.dearthDate = dearthDate;
  }

  public PersonDto bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * Get bio
   * @return bio
  */
  @NotNull 
  @Schema(name = "bio", example = "Биография моего предка очень интересна", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public PersonDto avatar(String avatar) {
    this.avatar = avatar;
    return this;
  }

  /**
   * Get avatar
   * @return avatar
  */
  @NotNull 
  @Schema(name = "avatar", example = "https://sartur.sgu.ru/wp-content/uploads/2021/09/avatar1-1536x1536.png", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("avatar")
  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public PersonDto spouseId(UUID spouseId) {
    this.spouseId = spouseId;
    return this;
  }

  /**
   * Идентификатор супруга/супруги
   * @return spouseId
  */
  @NotNull @Valid 
  @Schema(name = "spouse_id", example = "42abcd2b-8b9c-4af9-88f7-0bc180cf74b8", description = "Идентификатор супруга/супруги", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("spouse_id")
  public UUID getSpouseId() {
    return spouseId;
  }

  public void setSpouseId(UUID spouseId) {
    this.spouseId = spouseId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonDto person = (PersonDto) o;
    return Objects.equals(this.firstName, person.firstName) &&
        Objects.equals(this.surname, person.surname) &&
        Objects.equals(this.maidenName, person.maidenName) &&
        Objects.equals(this.gender, person.gender) &&
        Objects.equals(this.birthDate, person.birthDate) &&
        Objects.equals(this.dearthDate, person.dearthDate) &&
        Objects.equals(this.bio, person.bio) &&
        Objects.equals(this.avatar, person.avatar) &&
        Objects.equals(this.spouseId, person.spouseId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, surname, maidenName, gender, birthDate, dearthDate, bio, avatar, spouseId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonDto {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    maidenName: ").append(toIndentedString(maidenName)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    dearthDate: ").append(toIndentedString(dearthDate)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    spouseId: ").append(toIndentedString(spouseId)).append("\n");
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

