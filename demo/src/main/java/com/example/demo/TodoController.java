package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private static List<Todo> todolist ;

    public TodoController(){
        todolist = new ArrayList<>();
        todolist.add(new Todo(1,1,"Todo1",false));
        todolist.add(new Todo(2,2,"Todo2",true));
    }


      @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todolist;
    }
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo newTodo){
          todolist.add(newTodo);
          return newTodo;
    }


    
}
