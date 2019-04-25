package com.taskapp.task.repositories;

import com.taskapp.task.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findByName(String name);

}