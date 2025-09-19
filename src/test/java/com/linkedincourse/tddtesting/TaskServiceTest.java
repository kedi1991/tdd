package com.linkedincourse.tddtesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import com.linkedincourse.tddtesting.service.TaskService;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
	
	@Mock
	private TaskRepository taskRepository;
	
	@InjectMocks
	private TaskService taskService;

	@Test
	void testUpdateTaskStatus() {
		//init
		Task task = new Task(1L, "Henry", "Developer");
		
		when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
		when(taskRepository.save(any(Task.class))).thenReturn(task);
		
		//logic
		Task updatedTask = taskService.updateTaskStatus(1L, "In progress");
		//assert
		assertNotNull(updatedTask);
		assertEquals("In progress", updatedTask.getStatus());
		
		verify(taskRepository, times(1)).findById(1L);
		verify(taskRepository, timeout(1)).save(task);
	}
}
