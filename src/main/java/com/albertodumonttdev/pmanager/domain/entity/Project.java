package com.albertodumonttdev.pmanager.domain.entity;

import com.albertodumonttdev.pmanager.domain.model.ProjectStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Table(name = "project")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id //jakarta.persistence
    @GeneratedValue(strategy = UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @Column(name = "initial_date", nullable = false)
    private LocalDate initialDate;

    @Column(name = "final_date", nullable = false)
    private LocalDate finalDate;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
}
