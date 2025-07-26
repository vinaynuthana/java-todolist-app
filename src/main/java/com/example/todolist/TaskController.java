package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // Handles requests to the main page ("/")
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskRepository.findAll()); // Get all tasks
        model.addAttribute("newTask", new Task()); // Prepare an object for the form
        return "index"; // Tells Spring to render the index.html file
    }

    // Handles the form submission to add a new task
    @PostMapping("/add")
    public String addTask(Task newTask) {
        taskRepository.save(newTask); // Save the new task to the database
        return "redirect:/"; // Redirect back to the main page
    }

    // Handles deleting a task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }

    // Handles marking a task as complete
    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable("id") Long id) {
        Task task = taskRepository.findById(id).get();
        task.setCompleted(true);
        taskRepository.save(task);
        return "redirect:/";
    }
}