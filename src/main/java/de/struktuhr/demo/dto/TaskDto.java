package de.struktuhr.demo.dto;

import java.util.Date;

public class TaskDto {

    public Long id;

    public Integer version;

    public String name;

    public String owner;

    public String status;

    public Date created;

    public Date claimed;

    public Date finished;

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", status='" + status + '\'' +
                ", created=" + created +
                ", claimed=" + claimed +
                ", finished=" + finished +
                '}';
    }

    public static TaskDto forName(String name) {
        TaskDto taskDto = new TaskDto();
        taskDto.name = name;
        return taskDto;
    }
}
