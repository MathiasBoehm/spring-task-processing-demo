package de.struktuhr.demo.control;

import de.struktuhr.demo.dto.TaskDto;
import de.struktuhr.demo.entity.Task;
import de.struktuhr.demo.entity.TaskStatus;
import de.struktuhr.demo.repo.TaskRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Transactional
    public TaskDto createTask(TaskDto dto) {
        final Task task = new Task();
        task.setName(dto.name);
        task.setCreated(new Date());
        task.setStatus(TaskStatus.NEW);
        final Task savedTask = taskRepo.save(task);
        return convert(savedTask);
    }

    @Transactional(readOnly = true)
    public List<TaskDto> findAll() {
        return taskRepo.findAll().stream().map(this::convert).toList();
    }


    @Transactional(readOnly = true)
    public List<TaskDto> findNewTasks(int maxNewTasks) {
        return taskRepo.findNewTasksLimited(TaskStatus.NEW, maxNewTasks).stream().map(this::convert).toList();
    }

    @Transactional(readOnly = true)
    public List<TaskDto> findClaimedTasks(String owner) {
        return taskRepo.findByStatusAndOwner(TaskStatus.CLAIMED, owner).stream().map(this::convert).toList();
    }


    @Transactional
    public TaskDto claim(Long id, String owner) {
        TaskDto claimedTaskDto = null;
        final List<Task> claimableTasks = taskRepo.findByIdAndStatusAndOwner(id, TaskStatus.NEW, null);
        if (claimableTasks.size() == 1) {
            final Task task = claimableTasks.get(0);
            task.setClaimed(new Date());
            task.setStatus(TaskStatus.CLAIMED);
            task.setOwner(owner);
            final Task claimedTask = taskRepo.save(task);
            claimedTaskDto = convert(claimedTask);
        }
        return claimedTaskDto;
    }

    @Transactional
    public TaskDto finish(Long id) {
        final Task task = taskRepo.getReferenceById(id);
        task.setFinished(new Date());
        task.setStatus(TaskStatus.FINISHED);

        final Task claimedTask = taskRepo.save(task);
        return convert(claimedTask);
    }

    private TaskDto convert(Task t) {
        final TaskDto dto = new TaskDto();

        dto.id = t.getId();
        dto.name = t.getName();
        dto.owner = t.getOwner();
        dto.version = t.getVersion();
        dto.status = t.getStatus().name();
        dto.created = t.getCreated();
        dto.claimed = t.getClaimed();
        dto.finished = t.getFinished();

        return dto;
    }

}
