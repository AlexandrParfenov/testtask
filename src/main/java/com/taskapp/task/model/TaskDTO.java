package com.taskapp.task.model;

public class TaskDTO {

    private long id;
    private String name;
    private String cron_expression;
    private int priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCron_expression() {
        return cron_expression;
    }

    public void setCron_expression(String cron_expression) {
        this.cron_expression = cron_expression;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
