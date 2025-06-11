package com.albertodumonttdev.pmanager.infrastructure.controller;

import com.albertodumonttdev.pmanager.domain.applicationService.ProjectService;
import com.albertodumonttdev.pmanager.domain.entity.Project;
import com.albertodumonttdev.pmanager.infrastructure.dto.ProjectDTO;
import com.albertodumonttdev.pmanager.infrastructure.dto.SaveProjectDataDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import static com.albertodumonttdev.pmanager.infrastructure.controller.RestConstants.PATH_PROJECTS;

/**
 * REST controller responsible for handling HTTP requests related to Project resources.
 * This class defines the endpoint(s) used to interact with the application, specifically for creating a new project.
 *
 * Responsibilities:
 * - Receives HTTP POST requests with project data in JSON format.
 * - Maps incoming data to a DTO (Data Transfer Object).
 * - Delegates the business logic to the ProjectService.
 * - Converts the result into a response-friendly DTO and returns an appropriate HTTP response.
 *
 * Notes:
 * - Follows the principle of separation of concerns: no business logic is handled here.
 * - Uses @RestController to expose RESTful endpoints.
 * - The @RequestMapping defines the base path for project-related operations.
 * - @RequiredArgsConstructor automatically injects the service dependency.
 */


@RestController
@RequestMapping(PATH_PROJECTS)
@RequiredArgsConstructor
public class ProjectRestResource {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody @Valid SaveProjectDataDTO saveProjectDataDTO) {
        Project project = projectService.createProject(saveProjectDataDTO);

        return ResponseEntity
                .created(URI.create(PATH_PROJECTS + project.getId()))
                .body(ProjectDTO.create(project));
    }
}
