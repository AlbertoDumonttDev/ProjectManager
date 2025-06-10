package com.albertodumonttdev.pmanager.domain.repository;

import com.albertodumonttdev.pmanager.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Project entities.
 * Extends JpaRepository to provide standard CRUD operations and query methods for the Project entity.
 *
 * This interface serves as the data access layer, allowing interaction with the database
 * without the need to implement boilerplate SQL or JDBC logic.
 *
 * The generic types <Project, String> indicate:
 * - Project: The entity type.
 * - String: The type of the entity's primary key (ID).
 */

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> { }
