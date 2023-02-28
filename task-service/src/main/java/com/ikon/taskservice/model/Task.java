package com.ikon.taskservice.model;

import com.ikon.projectservice.model.Project;
import com.ikon.taskservice.util.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private LocalDate dueDate;

    private Long projectId;

//    @Column(columnDefinition = "TODO")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Project project;

}
