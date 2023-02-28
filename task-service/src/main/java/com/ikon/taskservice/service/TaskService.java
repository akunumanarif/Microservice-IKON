package com.ikon.taskservice.service;

import com.ikon.taskservice.dto.ProjectDTO;
import com.ikon.taskservice.dto.ResponseTemplate;
import com.ikon.taskservice.dto.TaskDTO;
import com.ikon.taskservice.exception.ResourceNotFoundException;
import com.ikon.taskservice.model.Task;
import com.ikon.taskservice.repository.TaskRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    private final RestTemplate restTemplate;



    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public ResponseTemplate getTaskWithProject(Long taskId) {
        log.info("Class : PersonService, Method : getPersonWithDepartment...");
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Task task = taskRepository.findByTaskId(taskId);

        ProjectDTO projectDTO =
                restTemplate.getForObject("http://localhost:8082/api/v1/projects/" + task.getProjectId(),
                        ProjectDTO.class);
        responseTemplate.setTask(task);
        responseTemplate.setProjectDTO(projectDTO);

        return responseTemplate;
    }
}

