package com.taskapp.task.mapper;

import com.taskapp.task.domain.Task;
import com.taskapp.task.model.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {


    @Override
    public Task taskDtoToTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setPriority(taskDTO.getPriority());
        return task;
    }

    @Override
    public TaskDTO taskToTaskDto(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setCron_expression(task.getCron_expression());
        taskDTO.setPriority(task.getPriority());
        return taskDTO;
    }

}
