package de.struktuhr.demo.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TaskWorker {

    private final static Logger logger = LoggerFactory.getLogger(TaskWorker.class);

    private final TaskService taskService;

    private final Random random;

    public TaskWorker(TaskService taskService) {
        this.taskService = taskService;
        this.random = new Random();
    }


    @Async
    public void doWorkAsync(Long id) {
        sleep();
        try {
            taskService.finish(id);
            logger.info("{} finished", id);
        }
        catch(Exception e) {
            logger.warn("{} cannot be finished. {}", id, e.getMessage());
        }

    }

    private void sleep() {
        try {
            int seconds = random.nextInt(5);
            Thread.sleep(seconds * 1000);
        }
        catch(InterruptedException e) {
            logger.warn("Interrupted ", e.getMessage());
        }
    }
}
