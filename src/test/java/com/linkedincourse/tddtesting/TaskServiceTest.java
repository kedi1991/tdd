package com.linkedincourse.tddtesting;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.linkedincourse.tddtesting.service.TaskService;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
	
	@Mock
	TaskRepository taskRepository;
	
	@InjectMocks
	TaskService taskService;
	
}
