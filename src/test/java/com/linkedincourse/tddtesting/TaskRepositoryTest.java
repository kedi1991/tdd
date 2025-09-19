package com.linkedincourse.tddtesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import model.Task;
import repository.TaskRepository;

@DataJpaTest
public class TaskRepositoryTest {

	TaskRepository taskRepository;

	@Test
	void testSavedTask() {
		//init
		Task task = new Task();
		task.setTitle("Task 1");
		task.setStatus("Done");
		
		//task: save to the repository
		Task savedTask = taskRepository.save(task);
		
		//assert
		assertNotNull(savedTask);
		assertEquals("Task 1", savedTask.getTitle());
	}
	
}
