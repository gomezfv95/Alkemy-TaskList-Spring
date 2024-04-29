package AlkemyToDoList.AlkemyToDoList.TaskList.services;

import AlkemyToDoList.AlkemyToDoList.TaskList.model.Task;

import java.util.List;

public interface  TaskInterface {

    // -- Leer Todas las tareas
    List<Task> getTaskList();

    // -- Leer una tarea especifica
        Task getTaskListById(int id);

   // -- Crear Tarea nueva
    List<Task> addTask(Task task);


    // Actualizo el estado de una tarea
    List<Task> updateTaskStatus(int id, String status);

    // Eliminar una tarea
        List<Task> deleteAllTasks();
        List<Task> deleteTaskById(int id);

}
