package com.danielbravoac.schoolservice.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GenericResponse<T>(
        Info info,
        T data
) {
    public GenericResponse(Info info) {
        this(info, null);
    }
}
