package com.ikon.taskservice.dto;

import com.ikon.taskservice.dto.ProjectDTO;
import com.ikon.taskservice.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private Task Task;
    private ProjectDTO projectDTO;
}