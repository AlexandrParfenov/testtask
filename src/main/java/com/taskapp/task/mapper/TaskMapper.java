package com.taskapp.task.mapper;

import com.taskapp.task.domain.Task;
import com.taskapp.task.model.TaskDTO;

public interface TaskMapper {

    Task taskDtoToTask(TaskDTO taskDTO);

    TaskDTO taskToTaskDto(Task task);

}
