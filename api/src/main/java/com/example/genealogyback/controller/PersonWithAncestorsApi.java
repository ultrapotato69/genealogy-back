/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.genealogyback.controller;

import com.example.genealogyback.dto.ErrorDto;
import com.example.genealogyback.dto.PersonWithAncestorsDto;
import java.util.UUID;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-27T15:23:13.003773200+03:00[Europe/Moscow]")
@Validated
@Tag(name = "PersonWithAncestors", description = "the PersonWithAncestors API")
public interface PersonWithAncestorsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /person/{id}/ancestors/ : Метод получения всего генеалогического древа
     * Метод предназначен для получения из БД полного древа со всеми предками
     *
     * @param id Идентификатор карточки с данными родственника (required)
     * @return Всё дерево предков (status code 200)
     *         or Отсутсвует сущность с данным id (status code 404)
     *         or Любая неожиданная ошибка сервера (status code 5XX)
     */
    @Operation(
        operationId = "personIdAncestorsGet",
        summary = "Метод получения всего генеалогического древа",
        description = "Метод предназначен для получения из БД полного древа со всеми предками",
        tags = { "PersonWithAncestors" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Всё дерево предков", content = {
                @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PersonWithAncestorsDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = PersonWithAncestorsDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Отсутсвует сущность с данным id", content = {
                @Content(mediaType = "application/json;charset=UTF-8", array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class))),
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class)))
            }),
            @ApiResponse(responseCode = "5XX", description = "Любая неожиданная ошибка сервера", content = {
                @Content(mediaType = "application/json;charset=UTF-8", array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class))),
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/person/{id}/ancestors/",
        produces = { "application/json;charset=UTF-8", "application/json" }
    )
    
    default ResponseEntity<PersonWithAncestorsDto> personIdAncestorsGet(
        @Parameter(name = "id", description = "Идентификатор карточки с данными родственника", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"firstName\" : \"Елена\", \"surname\" : \"Петрова\", \"gender\" : \"male\", \"spouseId\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"maidenName\" : \"Смирнова\", \"birthDate\" : \"2024-01-23\", \"deathDate\" : \"2024-01-23\", \"bio\" : \"Биография моего предка очень интересна\", \"avatar\" : \"https://sartur.sgu.ru/wp-content/uploads/2021/09/avatar1-1536x1536.png\", \"treeOwner\" : true, \"parents\" : [ { \"id\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"firstName\" : \"Елена\", \"surname\" : \"Петрова\", \"gender\" : \"female\", \"spouseId\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"maidenName\" : \"Смирнова\", \"birthDate\" : \"2024-01-23\", \"deathDate\" : \"2024-01-23\", \"bio\" : \"Биография моего предка очень интересна\", \"avatar\" : \"https://sartur.sgu.ru/wp-content/uploads/2021/09/avatar1-1536x1536.png\", \"treeOwner\" : false, \"parents\" : [ ] }, { \"id\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b5\", \"firstName\" : \"Иван\", \"surname\" : \"Петров\", \"gender\" : \"male\", \"spouseId\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"maidenName\" : \"Смирнова\", \"birthDate\" : \"2024-01-23\", \"deathDate\" : \"2024-01-23\", \"bio\" : \"Биография моего предка очень интересна\", \"avatar\" : \"https://sartur.sgu.ru/wp-content/uploads/2021/09/avatar1-1536x1537.png\", \"treeOwner\" : false, \"parents\" : [ ] } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json;charset=UTF-8"))) {
                    String exampleString = "{ \"id\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"firstName\" : \"Елена\", \"surname\" : \"Петрова\", \"gender\" : \"male\", \"spouseId\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"maidenName\" : \"Смирнова\", \"birthDate\" : \"2024-01-23\", \"deathDate\" : \"2024-01-23\", \"bio\" : \"Биография моего предка очень интересна\", \"avatar\" : \"https://sartur.sgu.ru/wp-content/uploads/2021/09/avatar1-1536x1536.png\", \"treeOwner\" : true, \"parents\" : [ { \"id\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"firstName\" : \"Елена\", \"surname\" : \"Петрова\", \"gender\" : \"female\", \"spouseId\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"maidenName\" : \"Смирнова\", \"birthDate\" : \"2024-01-23\", \"deathDate\" : \"2024-01-23\", \"bio\" : \"Биография моего предка очень интересна\", \"avatar\" : \"https://sartur.sgu.ru/wp-content/uploads/2021/09/avatar1-1536x1536.png\", \"treeOwner\" : false, \"parents\" : [ ] }, { \"id\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b5\", \"firstName\" : \"Иван\", \"surname\" : \"Петров\", \"gender\" : \"male\", \"spouseId\" : \"42abcd2b-8b9c-4af9-88f7-0bc180cf74b4\", \"maidenName\" : \"Смирнова\", \"birthDate\" : \"2024-01-23\", \"deathDate\" : \"2024-01-23\", \"bio\" : \"Биография моего предка очень интересна\", \"avatar\" : \"https://sartur.sgu.ru/wp-content/uploads/2021/09/avatar1-1536x1537.png\", \"treeOwner\" : false, \"parents\" : [ ] } ] }";
                    ApiUtil.setExampleResponse(request, "application/json;charset=UTF-8", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
