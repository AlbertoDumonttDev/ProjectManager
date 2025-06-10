package com.albertodumonttdev.pmanager.domain.applicationService;

import com.albertodumonttdev.pmanager.domain.entity.Project;
import com.albertodumonttdev.pmanager.domain.model.ProjectStatus;
import com.albertodumonttdev.pmanager.domain.repository.ProjectRepository;
import com.albertodumonttdev.pmanager.infrastructure.dto.SaveProjectDataDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for handling business logic related to projects.
 * This layer acts as an intermediary between the controller and the data access layer (repository),
 * ensuring that all business rules are enforced and that the data is properly processed before persistence or response.
 *
 * Typical responsibilities of this service:
 * - Validating project data.
 * - Creating and updating projects.
 * - Interacting with the repository to persist project entities.
 * - Transforming data between entities and DTOs when necessary.
 */

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject(SaveProjectDataDTO saveProjectDataDTO) {

        Project project = Project.builder()
                .name(saveProjectDataDTO.getName())
                .description(saveProjectDataDTO.getDescription())
                .initialDate(saveProjectDataDTO.getInitialDate())
                .finalDate(saveProjectDataDTO.getFinalDate())
                .status(ProjectStatus.PENDING)
                .build();

        projectRepository.save(project);

        return project;
    }
}
