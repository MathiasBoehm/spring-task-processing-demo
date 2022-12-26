package de.struktuhr.demo.control;

import de.struktuhr.demo.TestHelper;
import de.struktuhr.demo.dto.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("dev")
public class TaskServiceTest {

    @Autowired
    TaskService taskService;

    @Test
    public void checkSimple() {
        taskService.createTask(TaskDto.forName("Do this"));
        taskService.createTask(TaskDto.forName("Do that"));
        final List<TaskDto> allTasks = taskService.findAll();
        TestHelper.printJson(allTasks);
    }


}
