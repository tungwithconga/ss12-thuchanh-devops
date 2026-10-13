package com.example.taskflow.controller;
import com.example.taskflow.model.Task;
import com.example.taskflow.repository.TaskRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController @RequestMapping("/api/tasks") public class TaskController {
 private final TaskRepository repo;
 public TaskController(TaskRepository repo){this.repo=repo;}
 @GetMapping public List<Task> all(){return repo.findAll();}
 @GetMapping("/{id}") public Task one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Task add(@RequestBody Task input){validate(input); Task task=new Task(); task.setTitle(input.getTitle().trim()); task.setCompleted(input.isCompleted()); return repo.save(task);}
 @PutMapping("/{id}") public Task update(@PathVariable Long id,@RequestBody Task input){validate(input);Task task=one(id);task.setTitle(input.getTitle().trim());task.setCompleted(input.isCompleted());return repo.save(task);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND);repo.deleteById(id);}
 private void validate(Task task){if(task.getTitle()==null||task.getTitle().isBlank()||task.getTitle().length()>255)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Title must be 1-255 characters");}
}
