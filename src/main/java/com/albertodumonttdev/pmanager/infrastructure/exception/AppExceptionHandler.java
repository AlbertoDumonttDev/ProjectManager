package com.albertodumonttdev.pmanager.infrastructure.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Global exception handler for the application.
 * This class centralizes the handling of exceptions thrown during the processing of HTTP requests,
 * providing a consistent error response structure for clients.
 *
 * It extends {@link ResponseEntityExceptionHandler} to leverage Spring's default exception handling behavior
 * and overrides or complements it with custom logic for specific exception types.
 *
 * Main responsibilities of this class:
 * - Handle custom application exceptions such as {@link RequestException}.
 * - Handle generic exceptions not explicitly mapped.
 * - Return a structured {@link RestError} response including HTTP status, error code, message, and request path.
 * - Improve debuggability and maintain a clean controller layer by separating exception logic.
 *
 * Exceptions handled:
 * - {@code RequestException}: returns a 400 Bad Request with detailed error information.
 * - {@code Exception}: returns a 500 Internal Server Error for unexpected exceptions.
 */

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> handleException(
            Exception ex,
            String errorCode,
            String message,
            List<String> details,
            HttpStatus status,
            WebRequest request
    ) {

        ServletWebRequest servletWebRequest = (ServletWebRequest) request;

        return handleExceptionInternal(
                ex,
                RestError
                        .builder()
                        .errorCode(errorCode)
                        .errorMensagem(message)
                        .details(details)
                        .status(status.value())
                        .path(servletWebRequest.getRequest().getRequestURI())
                        .build(),
                new HttpHeaders(),
                status,
                request
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        List<String> details = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .filter(Objects::nonNull)
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        return handleException(ex, "ValidationError", null, details, BAD_REQUEST, request);

    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<Object> handleRequestException(RequestException ex, WebRequest request) {

        return handleException(ex, ex.getErrorCode(), ex.getMessage(), null, BAD_REQUEST, request);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGenenericException(Exception ex, WebRequest request) {

        return handleException(ex, null, ex.getMessage(), null, INTERNAL_SERVER_ERROR, request);
    }

}
