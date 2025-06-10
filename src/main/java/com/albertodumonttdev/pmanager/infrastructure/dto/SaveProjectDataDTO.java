package com.albertodumonttdev.pmanager.infrastructure.dto;

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
    private final String id;
    private final String name;
    private final String description;
    private final LocalDate initialDate;
    private final LocalDate finalDate;
    private final String status;
}
