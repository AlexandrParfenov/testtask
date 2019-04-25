package com.taskapp.task.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:app.properties")
public class Config {

    private final Environment env;

    @Autowired
    public Config(Environment env) {
        this.env = env;
    }

    public String getPeriod() {
        return env.getProperty("period");
    }


}
