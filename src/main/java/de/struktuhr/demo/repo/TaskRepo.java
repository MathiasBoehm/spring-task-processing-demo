package de.struktuhr.demo.repo;

import de.struktuhr.demo.entity.Task;
import de.struktuhr.demo.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long>, CustomTaskRepo {


    List<Task> findByStatusAndOwner(TaskStatus status, String owner);

    List<Task> findByIdAndStatusAndOwner(Long id, TaskStatus status, String owner);
}
