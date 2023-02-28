package com.ikon.taskservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectDTO<T> {
    private Long id;
    private String name;
    private String description;
    //private Long teamId;
//    private List<TaskDTO> tasks;


}
