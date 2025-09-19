package com.linkedincourse.tddtesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class TaskRepositoryTest {

	@Autowired
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
	
	@Test
	void testDeletedTask() {
		//init
		Task task = new Task();
		task.setTitle("Gilbert");
		task.setStatus("Employed");
		
		Task savedTask = taskRepository.save(task);
		
		//logic
		taskRepository.delete(task);
		
		Optional<Task> deletedTask = taskRepository.findById(savedTask.getId()); 
		assertFalse(deletedTask.isPresent());
	}
	@Test
	void testGetTask() {
		//init
		Task task = new Task();
		task.setTitle("Cooper");
		task.setStatus("Dealer");
		
		taskRepository.save(task);
		//logic
		
		Optional<Task> retrivedTask = taskRepository.findById(task.getId());
		//assert
		assertFalse(retrivedTask.isEmpty());
	}
	
	@Test
	void testUpdateTask() {
		//init
		Task task = new Task(null,"Cooper", "Unemployed");
		taskRepository.save(task);
		
		//logic
		task.setStatus("Dealer");
		taskRepository.save(task);
		//assert
		assertEquals("Dealer", taskRepository.findById(task.getId()).get().getStatus());
		
	}
	
	@Test
	void testFindAllTask() {
		//init
		Task task1 = new Task(null,"Cooper", "Unemployed");
		taskRepository.save(task1);
		
		Task task2 = new Task(null,"Gilbert", "Unemployed");
		taskRepository.save(task2);
		
		Task task3 = new Task(null,"Bob", "Unemployed");
		taskRepository.save(task3);
		
		//logic
		List<Task> allTasks = taskRepository.findAll();
		//assert
		assertEquals(3, allTasks.size());
		
	}
	
}
