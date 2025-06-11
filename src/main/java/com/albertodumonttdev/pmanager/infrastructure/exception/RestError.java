package com.albertodumonttdev.pmanager.infrastructure.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Data structure representing the standardized format for error responses returned by the API.
 *
 * This class is used to encapsulate detailed information about errors that occur during request
 * processing, allowing clients to understand what went wrong and potentially take corrective action.
 *
 * Fields:
 * - {@code errorCode}: A custom code identifying the specific error type.
 * - {@code errorMensagem}: A descriptive message explaining the error.
 * - {@code status}: The HTTP status code associated with the error.
 * - {@code path}: The URI path of the request that caused the error.
 *
 * This model is typically returned by the {@link AppExceptionHandler} when handling exceptions.
 */

@Data
@Builder
public class RestError {
    private final String errorCode;
    private final String errorMensagem;
    private  final List<String> details;
    private final int status;
    private final String path;
}
