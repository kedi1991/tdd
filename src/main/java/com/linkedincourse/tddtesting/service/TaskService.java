package com.linkedincourse.tddtesting.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.linkedincourse.tddtesting.Task;
import com.linkedincourse.tddtesting.TaskRepository;

@Service
public class TaskService {
	
	TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task updateTaskStatus(Long id, String status) {
		
		Optional<Task> tOptional = taskRepository.findById(id);
		
		if (tOptional.isPresent()) {
			Task t = tOptional.get();
			t.setStatus(status);
			return taskRepository.save(t);
		}
		
		return null;
	}
}
