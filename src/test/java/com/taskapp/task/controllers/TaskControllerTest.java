package com.taskapp.task.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskapp.task.model.TaskDTO;
import com.taskapp.task.services.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TaskControllerTest {

    @Mock
    private TaskService taskService;

    private MockMvc mockMvc;

    private TaskDTO taskDTO1;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        TaskController taskController = new TaskController(taskService);
        mockMvc = MockMvcBuilders.standaloneSetup(taskController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
        taskDTO1 = new TaskDTO();
        taskDTO1.setName("task1");
    }


    @Test
    public void createTaskTest() throws Exception {
        given(taskService.createTask(taskDTO1)).willReturn(taskDTO1);

        mockMvc.perform(post(TaskController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(taskDTO1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getTaskByNameTest() throws Exception {
        given(taskService.getTaskByName("task1")).willReturn(taskDTO1);

        mockMvc.perform(get(TaskController.BASE_URL)
                .param("name", "task1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}