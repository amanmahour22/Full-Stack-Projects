package com.todoproject.springboot.first.web.app.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	static {
		todos.add(new Todo(++todosCount, "In28Minutes", "Learn AWS", 
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "In28Minutes", "Learn Devops", 
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "In28Minutes", "Learn Full Stack Developement", 
				LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
	    Predicate<Todo> predicate = new Predicate<Todo>() {
	        @Override
	        public boolean test(Todo todo) {
	            return todo.getId() == id;
	        }
	    };
	    todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<Todo> predicate = new Predicate<Todo>() {
	        @Override
	        public boolean test(Todo todo) {
	            return todo.getId() == id;
	        }
	    };
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
