package com.example.reactivewebservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class Todo {

    private String[] tasks;

    public Todo() {
    }

    public Todo(String[] tasks) {
        this.tasks = tasks;
    }

    public String[] getTasks() {
        return this.tasks;
    }

    // Corrected the parameter name to match the field name
    public void setTasks(String[] tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "tasks=" + Arrays.toString(tasks) +
                '}';
    }
}