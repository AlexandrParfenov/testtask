package com.taskapp.task.controllers;

import com.taskapp.task.model.TaskDTO;
import com.taskapp.task.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TaskController.BASE_URL)
public class TaskController {

    public static final String BASE_URL = "/task";
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO getTaskByName(@RequestParam("name") String name) {
        return taskService.getTaskByName(name);
    }

}
