package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todolist ;

    public TodoController(){
        todolist = new ArrayList<>();
        todolist.add(new Todo(1,1,"Todo1",false));
        todolist.add(new Todo(2,2,"Todo2",true));
    }


    //   @GetMapping("/todos")
      @GetMapping("/")
    public ResponseEntity<List<Todo>> getTodos(){
        // return ResponseEntity.ok(todolist);
        return ResponseEntity.status(HttpStatus.OK).body(todolist);
    }
    // @PostMapping("/todos")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
          todolist.add(newTodo);
        //   return newTodo;
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
       
    }
    @GetMapping("/{todoId}")
    // @GetMapping("/todos/{todoId}")
    // public ResponseEntity<Todo> getTodoById(@PathVariable long todoId){
     public ResponseEntity<?> getTodoById(@PathVariable long todoId){
        for(Todo todo:todolist){
            if(todo.getId()==todoId){
              return ResponseEntity.ok(todo);

            }
        }
        // return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found");
    }


     
}
