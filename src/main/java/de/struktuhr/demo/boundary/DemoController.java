package de.struktuhr.demo.boundary;

import de.struktuhr.demo.control.TaskService;
import de.struktuhr.demo.dto.NewTaskDto;
import de.struktuhr.demo.dto.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class DemoController {

    private final TaskService taskService;

    public DemoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public TaskDto create(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @PostMapping("/new-tasks")
    public void createNewTasks(@RequestBody NewTaskDto newTaskDto) {
        final String nameTemplate = newTaskDto.nameTemplate != null ? newTaskDto.nameTemplate : "Demo";
        for(int i = 0; i < newTaskDto.count; i++) {
            taskService.createTask(TaskDto.forName(nameTemplate + " " + i + " " + LocalDateTime.now()));
        }
    }
}
