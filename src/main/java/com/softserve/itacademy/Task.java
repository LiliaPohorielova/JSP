package com.softserve.itacademy;

public class Task {

    private int id;
    private String name;
    private Priority priority;

    private static int counter = 1;

    public Task() {
        this.id = counter++;
    }

    public Task(String name, Priority priority) {
        this.id = counter++;
        this.name = name;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Task.counter = counter;
    }
}
