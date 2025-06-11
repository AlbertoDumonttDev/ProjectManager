package com.albertodumonttdev.pmanager.infrastructure.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) used to receive or send data related to project creation or update.
 * This class is typically used in the communication between client and server (e.g., via HTTP requests),
 * separating external data representation from the internal domain model (e.g., the Project entity).
 *
 * Fields:
 * - id: Identifier of the project (can be null for new projects).
 * - name: Name of the project.
 * - description: Brief description of the project.
 * - initialDate: Starting date of the project.
 * - finalDate: Expected end date of the project.
 * - status: Current status of the project (e.g., "IN_PROGRESS", "COMPLETED").
 */

@Data
public class SaveProjectDataDTO {

    @NotNull(message = "Name cannot be empty")
    @Size(min = 1, max = 80, message = "Invalid Name")
    private final String name;

    @NotNull(message = "Description cannot be empty")
    @Size(min = 1, max = 150, message = "Invalid Name")
    private final String description;

    @NotNull(message = "Initial date cannot be empty")
    private final LocalDate initialDate;

    @NotNull(message = "Final date cannot be empty")
    private final LocalDate finalDate;

    private final String status;

    @AssertTrue(message = "Dates are not consistent")
    @SuppressWarnings("unused")
    private boolean isInitialDateBeforeFinalDate() {
        return initialDate.isBefore(finalDate);
    }
}
