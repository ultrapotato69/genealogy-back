package com.example.genealogyback.dto;

import java.net.URI;
import java.util.Objects;
import com.example.genealogyback.dto.GenderDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * PersonWithAncestorsDto
 */

@JsonTypeName("PersonWithAncestors")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-22T22:46:03.398754600+03:00[Europe/Moscow]")
public class PersonWithAncestorsDto {

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

  private UUID id;

  private Boolean treeOwner;

  @Valid
  private List<@Valid PersonWithAncestorsDto> parents = new ArrayList<>();

  public PersonWithAncestorsDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PersonWithAncestorsDto(String firstName, GenderDto gender, Boolean treeOwner, List<@Valid PersonWithAncestorsDto> parents) {
    this.firstName = firstName;
    this.gender = gender;
    this.treeOwner = treeOwner;
    this.parents = parents;
  }

  public PersonWithAncestorsDto firstName(String firstName) {
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

  public PersonWithAncestorsDto surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  */
  
  @Schema(name = "surname", example = "Петрова", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public PersonWithAncestorsDto gender(GenderDto gender) {
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

  public PersonWithAncestorsDto spouseId(UUID spouseId) {
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

  public PersonWithAncestorsDto maidenName(String maidenName) {
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

  public PersonWithAncestorsDto birthDate(LocalDate birthDate) {
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

  public PersonWithAncestorsDto deathDate(LocalDate deathDate) {
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

  public PersonWithAncestorsDto bio(String bio) {
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

  public PersonWithAncestorsDto avatar(String avatar) {
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

  public PersonWithAncestorsDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор карточки родственника
   * @return id
  */
  @Valid 
  @Schema(name = "id", example = "42abcd2b-8b9c-4af9-88f7-0bc180cf74b4", description = "Идентификатор карточки родственника", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public PersonWithAncestorsDto treeOwner(Boolean treeOwner) {
    this.treeOwner = treeOwner;
    return this;
  }

  /**
   * Get treeOwner
   * @return treeOwner
  */
  @NotNull 
  @Schema(name = "treeOwner", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("treeOwner")
  public Boolean getTreeOwner() {
    return treeOwner;
  }

  public void setTreeOwner(Boolean treeOwner) {
    this.treeOwner = treeOwner;
  }

  public PersonWithAncestorsDto parents(List<@Valid PersonWithAncestorsDto> parents) {
    this.parents = parents;
    return this;
  }

  public PersonWithAncestorsDto addParentsItem(PersonWithAncestorsDto parentsItem) {
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
  public List<@Valid PersonWithAncestorsDto> getParents() {
    return parents;
  }

  public void setParents(List<@Valid PersonWithAncestorsDto> parents) {
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
    PersonWithAncestorsDto personWithAncestors = (PersonWithAncestorsDto) o;
    return Objects.equals(this.firstName, personWithAncestors.firstName) &&
        Objects.equals(this.surname, personWithAncestors.surname) &&
        Objects.equals(this.gender, personWithAncestors.gender) &&
        Objects.equals(this.spouseId, personWithAncestors.spouseId) &&
        Objects.equals(this.maidenName, personWithAncestors.maidenName) &&
        Objects.equals(this.birthDate, personWithAncestors.birthDate) &&
        Objects.equals(this.deathDate, personWithAncestors.deathDate) &&
        Objects.equals(this.bio, personWithAncestors.bio) &&
        Objects.equals(this.avatar, personWithAncestors.avatar) &&
        Objects.equals(this.id, personWithAncestors.id) &&
        Objects.equals(this.treeOwner, personWithAncestors.treeOwner) &&
        Objects.equals(this.parents, personWithAncestors.parents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, surname, gender, spouseId, maidenName, birthDate, deathDate, bio, avatar, id, treeOwner, parents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonWithAncestorsDto {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    spouseId: ").append(toIndentedString(spouseId)).append("\n");
    sb.append("    maidenName: ").append(toIndentedString(maidenName)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    deathDate: ").append(toIndentedString(deathDate)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    treeOwner: ").append(toIndentedString(treeOwner)).append("\n");
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

