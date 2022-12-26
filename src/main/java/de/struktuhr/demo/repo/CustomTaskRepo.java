package de.struktuhr.demo.repo;

import de.struktuhr.demo.entity.Task;
import de.struktuhr.demo.entity.TaskStatus;

import java.util.List;

public interface CustomTaskRepo {

    List<Task> findNewTasksLimited(TaskStatus status, int limit);
}
