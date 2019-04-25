package com.taskapp.task.services;

import com.taskapp.task.config.Config;
import com.taskapp.task.domain.Task;
import com.taskapp.task.mapper.TaskMapper;
import com.taskapp.task.model.TaskDTO;
import com.taskapp.task.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;
    private Config config;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, Config config) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.config = config;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.taskDtoToTask(taskDTO);
        task.setCron_expression(generateCronExpression());
        taskRepository.save(task);
        return taskDTO;
    }

    private String generateCronExpression() {
        LocalDateTime time = LocalDateTime.now();
        time = time.plusHours(Long.parseLong(config.getPeriod()));
        return time.getSecond() + " " + time.getMinute() + " " + time.getHour()
                + " " + time.getDayOfMonth() + " " + time.getMonth().getValue() + " "
                + time.getDayOfWeek().name().substring(0,3)
                + " " + time.getYear();
    }

    @Override
    public TaskDTO getTaskByName(String name) {
        return taskMapper.taskToTaskDto(taskRepository.findByName(name));
    }
}
