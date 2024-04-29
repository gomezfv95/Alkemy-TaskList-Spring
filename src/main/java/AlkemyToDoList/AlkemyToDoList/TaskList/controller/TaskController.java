package AlkemyToDoList.AlkemyToDoList.TaskList.controller;

import AlkemyToDoList.AlkemyToDoList.TaskList.model.Task;
import AlkemyToDoList.AlkemyToDoList.TaskList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //-- Get All Tasks
    @GetMapping()
    public List<Task> getTasks() {
        return taskService.getTaskList();
    }


    //-- Get task  by ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskListById(id);
    }

    //-- Create Task
    @PostMapping("/createTask")
    public List<Task> addTask(@RequestBody Task task) {
        return  taskService.addTask(task);
    }


    //-- Update  task  by ID
    @PutMapping("/update/{id}")
    public List<Task> updateTaskStatus(@PathVariable int id, @RequestBody String updatedTaskStatus){
        return taskService.updateTaskStatus(id,updatedTaskStatus);
    }

    //-- Delete task  by ID
    @DeleteMapping("/delete/{id}")
    public void deleteTaskdeleteTaskById(@PathVariable int id) {
        taskService.deleteTaskById(id);
    }

    // Delete all tasks
    @DeleteMapping("/deletAll")
    public void deleteAllTasks() {
        taskService.deleteAllTasks();
    }

}
