package com.taskapp.task.domain;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private String cron_expression;

    public String getCron_expression() {
        return cron_expression;
    }

    public void setCron_expression(String cron_expression) {
        this.cron_expression = cron_expression;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

}
