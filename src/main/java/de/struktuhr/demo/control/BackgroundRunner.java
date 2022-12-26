package de.struktuhr.demo.control;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BackgroundRunner {

    private final NewTasksProcessor newTasksProcessor;

    public BackgroundRunner(NewTasksProcessor newTasksProcessor) {
        this.newTasksProcessor = newTasksProcessor;
    }

    @Scheduled(fixedDelay = 500, initialDelay = 1000)
    void processNewTasks() {
        newTasksProcessor.processNewTasks();
    }
}
