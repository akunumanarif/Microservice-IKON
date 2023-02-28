package com.ikon.taskservice.controller;


import com.ikon.taskservice.dto.ResponseDTO;

import com.ikon.taskservice.dto.ResponseTemplate;
import com.ikon.taskservice.dto.TaskDTO;
import com.ikon.taskservice.model.Task;
import com.ikon.taskservice.service.TaskService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
@Data
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    @Autowired
    private final TaskService taskService;


    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }



    @PostMapping
    public Task createTask(@RequestBody Task task) {
        log.info("Class : TaskController, Method : savePerson...");
        return taskService.createTask(task);
    }

    @GetMapping("/{taskId}")
    public ResponseTemplate getTaskWithProject(@PathVariable("taskId") Long taskId) {
        return taskService.getTaskWithProject(taskId);
    }
//    @PostMapping
//    public ResponseEntity<ResponseDTO<TaskDTO>> createProject(@RequestBody TaskDTO task, Errors errors) {
//        ResponseDTO<TaskDTO> response = new ResponseDTO<>();
//        if(errors.hasErrors()) {
//            response.setMessage("Gagal menambahkan Project");
//            response.setHttpStatus(HttpStatus.BAD_REQUEST);
//            response.setData(null);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//        }
//        response.setHttpStatus(HttpStatus.OK);
//        response.setMessage("Task berhasil ditambahkan");
//        log.info("Masuk sini");
//        response.setData(taskService.createTask(task));
//        log.info("Sampe sini kah?");
//
//        return ResponseEntity.ok().body(response);
//
//
//    }
}