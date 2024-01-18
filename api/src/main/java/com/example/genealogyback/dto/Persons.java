package com.example.genealogyback.dto;

import java.net.URI;
import java.util.Objects;
import com.example.genealogyback.dto.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Persons
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-18T15:20:34.794267600+03:00[Europe/Moscow]")
public class Persons {

  private UUID personId;

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

  @Valid
  private List<@Valid Person> parents = new ArrayList<>();

  public Persons() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Persons(String firstName, String surname, String maidenName, GenderEnum gender, String birthDate, String dearthDate, String bio, String avatar, List<@Valid Person> parents) {
    this.firstName = firstName;
    this.surname = surname;
    this.maidenName = maidenName;
    this.gender = gender;
    this.birthDate = birthDate;
    this.dearthDate = dearthDate;
    this.bio = bio;
    this.avatar = avatar;
    this.parents = parents;
  }

  public Persons personId(UUID personId) {
    this.personId = personId;
    return this;
  }

  /**
   * Идентификатор карточки родственника
   * @return personId
  */
  @Valid 
  @Schema(name = "person_id", example = "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4", description = "Идентификатор карточки родственника", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("person_id")
  public UUID getPersonId() {
    return personId;
  }

  public void setPersonId(UUID personId) {
    this.personId = personId;
  }

  public Persons firstName(String firstName) {
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

  public Persons surname(String surname) {
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

  public Persons maidenName(String maidenName) {
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

  public Persons gender(GenderEnum gender) {
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

  public Persons birthDate(String birthDate) {
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

  public Persons dearthDate(String dearthDate) {
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

  public Persons bio(String bio) {
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

  public Persons avatar(String avatar) {
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

  public Persons spouseId(UUID spouseId) {
    this.spouseId = spouseId;
    return this;
  }

  /**
   * Идентификатор супруга/супруги
   * @return spouseId
  */
  @Valid 
  @Schema(name = "spouse_id", example = "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4", description = "Идентификатор супруга/супруги", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("spouse_id")
  public UUID getSpouseId() {
    return spouseId;
  }

  public void setSpouseId(UUID spouseId) {
    this.spouseId = spouseId;
  }

  public Persons parents(List<@Valid Person> parents) {
    this.parents = parents;
    return this;
  }

  public Persons addParentsItem(Person parentsItem) {
    if (this.parents == null) {
      this.parents = new ArrayList<>();
    }
    this.parents.add(parentsItem);
    return this;
  }

  /**
   * Get parents
   * @return parents
  */
  @NotNull @Valid 
  @Schema(name = "parents", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parents")
  public List<@Valid Person> getParents() {
    return parents;
  }

  public void setParents(List<@Valid Person> parents) {
    this.parents = parents;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Persons persons = (Persons) o;
    return Objects.equals(this.personId, persons.personId) &&
        Objects.equals(this.firstName, persons.firstName) &&
        Objects.equals(this.surname, persons.surname) &&
        Objects.equals(this.maidenName, persons.maidenName) &&
        Objects.equals(this.gender, persons.gender) &&
        Objects.equals(this.birthDate, persons.birthDate) &&
        Objects.equals(this.dearthDate, persons.dearthDate) &&
        Objects.equals(this.bio, persons.bio) &&
        Objects.equals(this.avatar, persons.avatar) &&
        Objects.equals(this.spouseId, persons.spouseId) &&
        Objects.equals(this.parents, persons.parents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personId, firstName, surname, maidenName, gender, birthDate, dearthDate, bio, avatar, spouseId, parents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Persons {\n");
    sb.append("    personId: ").append(toIndentedString(personId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    maidenName: ").append(toIndentedString(maidenName)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    dearthDate: ").append(toIndentedString(dearthDate)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    spouseId: ").append(toIndentedString(spouseId)).append("\n");
    sb.append("    parents: ").append(toIndentedString(parents)).append("\n");
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

