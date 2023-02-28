package com.ikon.projectservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;


//    @ManyToOne
//    @JoinColumn(name = "team_id")
//    private Team team;
//
//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
//    private List<Task> tasks;

    // constructors, getters and setters
}
