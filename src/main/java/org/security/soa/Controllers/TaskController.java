package org.security.soa.Controllers;

import jakarta.validation.Valid;
import org.security.soa.Models.Task;
import org.security.soa.Sevices.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Список всех задач
    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks";
    }

    // Форма для создания новой задачи
    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "tasks-form";
    }

    // Сохранение новой задачи
    @PostMapping("/save")
    public String saveTask(@Valid @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "tasks-form";
        }
        taskService.save(task);
        return "redirect:/task";
    }


    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.findById(id);
        if (task == null) {
            return "redirect:/task";
        }
        model.addAttribute("task", task); // ✅ заменил
        return "tasks-form";
    }

    // Удаление задачи
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return "redirect:/task";
    }
}
