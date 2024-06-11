package com.example.application;

import com.example.domain.repository.ITaskRepository;
import com.example.domain.valueobject.Status;
import com.example.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public class AppService {

  private final ITaskRepository taskRepository;

  public AppService(final ITaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> list() {
    return taskRepository.readAll();
  }

  public void create(final String name) {
    final var task = new Task(UUID.randomUUID(), name, Status.TODO);
    taskRepository.create(task);
  }

  public void start(final UUID id) {
    final var task = taskRepository.readOne(id);
    final var newTask = task.start();
    taskRepository.update(id, newTask);
  }

  public void close(final UUID id) {
    final var task = taskRepository.readOne(id);
    final var newTask = task.close();
    taskRepository.update(id, newTask);
  }

  public void complete(final UUID id) {
    final var task = taskRepository.readOne(id);
    final var newTask = task.complete();
    taskRepository.update(id, newTask);
  }

}
