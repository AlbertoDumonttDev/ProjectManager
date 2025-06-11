package com.albertodumonttdev.pmanager.infrastructure.exception;

import lombok.Getter;

/**
 * Custom exception class used to represent application-specific request errors.
 *
 * This exception is typically thrown when the client sends a request that fails validation
 * or violates business rules. It includes a custom error code in addition to the standard
 * exception message, allowing for more granular error handling and clearer communication
 * of issues to the client.
 *
 * Typical use cases:
 * - Invalid input data received in a request.
 * - Business rule violations during request processing.
 * - Providing a specific error code to be returned in the API response.
 */

@Getter
public class RequestException extends RuntimeException {

    private final String errorCode;

    public RequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
