package de.struktuhr.demo.repo;

import de.struktuhr.demo.entity.Task;
import de.struktuhr.demo.entity.TaskStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomTaskRepoImpl implements CustomTaskRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> findNewTasksLimited(TaskStatus status, int limit) {
        return entityManager
                .createQuery("SELECT t FROM Task t WHERE status = :status ORDER BY t.created", Task.class)
                .setParameter("status", status)
                .setMaxResults(limit)
                .getResultList();
    }
}
