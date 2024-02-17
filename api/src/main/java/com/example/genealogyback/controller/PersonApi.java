/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.genealogyback.controller;

import com.example.genealogyback.dto.BasePersonDto;
import com.example.genealogyback.dto.ErrorDto;
import com.example.genealogyback.dto.PersonWithRelativesDto;
import com.example.genealogyback.dto.ResponsePersonDto;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-17T21:36:52.606360400+03:00[Europe/Moscow]")
@Validated
@Tag(name = "Person", description = "the Person API")
public interface PersonApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /person/{id}/ : Метод удаления карточки человека
     * Метод предназначен для удаления в БД данных по карточке человека.
     *
     * @param id Идентификатор карточки родственника (required)
     * @return Успешное удаление (status code 200)
     *         or Отсутсвует сущность с данным id (status code 404)
     *         or Любая неожиданная ошибка сервера (status code 5XX)
     */
    @Operation(
        operationId = "personIdDelete",
        summary = "Метод удаления карточки человека",
        description = "Метод предназначен для удаления в БД данных по карточке человека.",
        tags = { "Person" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление"),
            @ApiResponse(responseCode = "404", description = "Отсутсвует сущность с данным id", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class)))
            }),
            @ApiResponse(responseCode = "5XX", description = "Любая неожиданная ошибка сервера", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/person/{id}/",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Void> personIdDelete(
        @Parameter(name = "id", description = "Идентификатор карточки родственника", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /person/{id}/ : Метод получения карточки человека по идентификатору
     * Метод предназначен для получения из БД данных по одному человеку.
     *
     * @param id Идентификатор карточки с данными родственника (required)
     * @return Карточка человека (status code 200)
     *         or Отсутсвует сущность с данным id (status code 404)
     *         or Любая неожиданная ошибка сервера (status code 5XX)
     */
    @Operation(
        operationId = "personIdGet",
        summary = "Метод получения карточки человека по идентификатору",
        description = "Метод предназначен для получения из БД данных по одному человеку.",
        tags = { "Person" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Карточка человека", content = {
                @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = PersonWithRelativesDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = PersonWithRelativesDto.class))
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
        value = "/person/{id}/",
        produces = { "application/json;charset=UTF-8", "application/json" }
    )
    
    default ResponseEntity<PersonWithRelativesDto> personIdGet(
        @Parameter(name = "id", description = "Идентификатор карточки с данными родственника", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json;charset=UTF-8"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json;charset=UTF-8", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /person/{id}/ : Метод обновления данныхо человеке
     * Метод предназначен для обновления в БД данных по имеющейся карточке человека.
     *
     * @param id Идентификатор карточки с данными родственника (required)
     * @param basePersonDto  (required)
     * @return Подтверждение успешного обновления (status code 200)
     *         or Некорректные входные данные. Возвращает список атрибутов с ошибками (status code 400)
     *         or Отсутсвует сущность с данным id (status code 404)
     *         or Любая неожиданная ошибка сервера (status code 5XX)
     */
    @Operation(
        operationId = "personIdPut",
        summary = "Метод обновления данныхо человеке",
        description = "Метод предназначен для обновления в БД данных по имеющейся карточке человека.",
        tags = { "Person" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Подтверждение успешного обновления", content = {
                @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ResponsePersonDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResponsePersonDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Некорректные входные данные. Возвращает список атрибутов с ошибками", content = {
                @Content(mediaType = "application/json;charset=UTF-8", array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class))),
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class)))
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
        method = RequestMethod.PUT,
        value = "/person/{id}/",
        produces = { "application/json;charset=UTF-8", "application/json" },
        consumes = { "application/json;charset=UTF-8" }
    )
    
    default ResponseEntity<ResponsePersonDto> personIdPut(
        @Parameter(name = "id", description = "Идентификатор карточки с данными родственника", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id,
        @Parameter(name = "BasePersonDto", description = "", required = true) @Valid @RequestBody BasePersonDto basePersonDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json;charset=UTF-8"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json;charset=UTF-8", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /person/ : Метод добавления человека
     * Метод предназначен для сохранения в БД данных по новому человеку
     *
     * @param basePersonDto  (required)
     * @return Подтверждение успешного сохранения человека (status code 201)
     *         or Некорректные входные данные. Возвращает список атрибутов с ошибками (status code 400)
     *         or Любая неожиданная ошибка сервера (status code 5XX)
     */
    @Operation(
        operationId = "personPost",
        summary = "Метод добавления человека",
        description = "Метод предназначен для сохранения в БД данных по новому человеку",
        tags = { "Person" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Подтверждение успешного сохранения человека", content = {
                @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ResponsePersonDto.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResponsePersonDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Некорректные входные данные. Возвращает список атрибутов с ошибками", content = {
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
        method = RequestMethod.POST,
        value = "/person/",
        produces = { "application/json;charset=UTF-8", "application/json" },
        consumes = { "application/json;charset=UTF-8" }
    )
    
    default ResponseEntity<ResponsePersonDto> personPost(
        @Parameter(name = "BasePersonDto", description = "", required = true) @Valid @RequestBody BasePersonDto basePersonDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json;charset=UTF-8"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json;charset=UTF-8", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
