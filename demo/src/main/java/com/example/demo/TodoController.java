package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private static List<Todo> todos ;

    public TodoController(){
        todos = new ArrayList<>();
        todos.add(new Todo(1,1,"Todo1",false));
        todos.add(new Todo(2,2,"Todo2",true));
    }
    

    
}
