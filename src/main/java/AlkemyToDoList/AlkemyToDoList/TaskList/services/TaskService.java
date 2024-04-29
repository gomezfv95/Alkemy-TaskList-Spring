package AlkemyToDoList.AlkemyToDoList.TaskList.services;

import AlkemyToDoList.AlkemyToDoList.TaskList.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService implements TaskInterface {
    private List<Task> tasks = new ArrayList<>();

    public void loadTasks() {
        Task t1 = new Task(1,"Primera Task","Prueba primera task", "Pendiente");
        Task t2 = new Task(2,"Segunda Task","Prueba Segunda task", "En Progreso");
        Task t3 = new Task(3,"Tercera Task","Prueba Tercera task", "Completada");
        Task t4 = new Task(4,"Cuarta Task","Prueba Cuarta task", "Pendiente");
        Task t5 = new Task(5,"Quinta Task","Prueba Quinta task", "Completada");
        Task t6 = new Task(6,"Sexta Task","Prueba Sexta task", "En Progreso");
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        tasks.add(t4);
        tasks.add(t5);
        tasks.add(t6);
    }

    public TaskService(){
        loadTasks();
    }


    // Muestra todas las tareas del array
    @Override
    public List<Task> getTaskList() {
        return tasks;
    }
    // Muestra una tarea especifica buscada por id
    @Override
    public Task getTaskListById(int id) {
        if (id >= 0 && id < tasks.size()) {
            return tasks.get(id);
        } else {
            throw new NoSuchElementException("El id no existe");
        }
    }

    // Agrego una nueta Tarea
    @Override
    public List<Task> addTask(Task task) {
        tasks.add(task);
        return tasks;
    }

    // Actualizo el estado de una tarea
    @Override
    public List<Task> updateTaskStatus(int id, String status) {
        if (id >= 0 && id < tasks.size()) {
            Task taskToUpdate;
            try {
                taskToUpdate = tasks.stream().filter(task -> task.getId() == id).findFirst().get();
            } catch (NoSuchElementException e) {
                // Si no se encuentra la tarea con el ID proporcionado, lanzar una excepción o manejar el caso según sea necesario
                throw new IllegalArgumentException("No se encontró una tarea con el ID proporcionado.");
            }

            // Validar si el estado proporcionado es válido
            if (status.equals("En Progreso") || status.equals("Completada") || status.equals("Pendiente")) {
                taskToUpdate.setStatus(status);
            } else {
                // Si el estado proporcionado no es válido, lanzar una excepción
                throw new IllegalArgumentException("El estado proporcionado no es válido.");
            }

            return tasks;
        } else {
            // Si el ID proporcionado no es válido, devolver null o manejar el caso según sea necesario
            throw new IllegalArgumentException("El ID proporcionado no es válido.");
        }
    }

    // -- Elimino todas las tareas
    @Override
    public List<Task> deleteAllTasks() {
        tasks.clear();
        return tasks;
    }

    // -- Elimino una tarea especifica
    @Override
    public List<Task> deleteTaskById(int id) {
        tasks.removeIf(task -> task.getId() == id);
        return tasks;
    }
}
