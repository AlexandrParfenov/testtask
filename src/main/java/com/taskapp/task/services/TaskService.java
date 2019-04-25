package com.taskapp.task.services;

import com.taskapp.task.model.TaskDTO;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO getTaskByName(String name);

}
