package org.security.soa.Sevices;



import org.security.soa.Models.Task;

import org.security.soa.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Получить все задачи
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // Найти задачу по ID
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Сохранить или обновить задачу
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    // Удалить задачу
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}

