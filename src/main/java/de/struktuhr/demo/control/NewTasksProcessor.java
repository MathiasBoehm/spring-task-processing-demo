package de.struktuhr.demo.control;

import de.struktuhr.demo.EnvironmentInfo;
import de.struktuhr.demo.dto.TaskDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewTasksProcessor {
    private final static Logger logger = LoggerFactory.getLogger(NewTasksProcessor.class);

    private final EnvironmentInfo environmentInfo;

    private final TaskService taskService;
    private final TaskWorker taskWorker;

    private final int maxNewTasks;

    public NewTasksProcessor(EnvironmentInfo environmentInfo,
                             TaskService taskService,
                             TaskWorker taskWorker,
                             @Value("${app.max-new-tasks}") int maxNewTasks) {
        this.environmentInfo = environmentInfo;
        this.taskService = taskService;
        this.taskWorker = taskWorker;
        this.maxNewTasks = maxNewTasks;
    }

    public void processNewTasks() {
        List<TaskDto> newTasks = taskService.findNewTasks(maxNewTasks);
        newTasks.stream().forEach(t -> claimAndStartWork(t.id));
    }

    private void claimAndStartWork(Long id) {
        try {
            TaskDto claimedTask = taskService.claim(id, environmentInfo.getWorkerName());
            if (claimedTask != null) {
                logger.info("{} claimed", id);
                taskWorker.doWorkAsync(id);
            }
        }
        catch(Exception e) {
            logger.debug("Cannot claim task {}. Error is {}", id, e.getMessage());
        }
    }
}
