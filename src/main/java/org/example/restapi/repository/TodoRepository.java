package org.example.restapi.repository;

import org.example.restapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    //save, findById ...
}