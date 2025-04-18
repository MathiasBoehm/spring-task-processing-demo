package de.struktuhr.demo.repo;

import de.struktuhr.demo.entity.Task;
import de.struktuhr.demo.entity.TaskStatus;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long>, CustomTaskRepo {


    List<Task> findByStatusAndOwner(TaskStatus status, String owner);

    List<Task> findByIdAndStatusAndOwner(Long id, TaskStatus status, String owner);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints(
            {@QueryHint(name = "jakarta.persistence.lock.timeout", value = "5000")}
    )
    Task getAndLockById(Long id);
}
