package com.example.demo.demo.taskrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.demo.taskmodel.TaskModel;


@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long>{

}
