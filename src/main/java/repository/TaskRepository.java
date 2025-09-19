package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Id;
import model.Task;

public interface TaskRepository extends JpaRepository<Long, Id>{

}
