package com.example.application;

import com.example.domain.valueobject.Status;
import com.example.domain.entity.Task;
import com.example.infrastructure.TaskStorage;
import java.util.List;
import java.util.UUID;

public class AppService {

  private final TaskStorage taskStorage;

  public AppService(final TaskStorage taskStorage) {
    this.taskStorage = taskStorage;
  }

  public List<Task> list() {
    return taskStorage.readAll();
  }

  public void create(final String name) {
    final var task = new Task(UUID.randomUUID(), name, Status.TODO);
    taskStorage.create(task);
  }

  public void start(final UUID id) {
    final var task = taskStorage.readOne(id);
    final var newTask = task.start();
    taskStorage.update(id, newTask);
  }

  public void close(final UUID id) {
    final var task = taskStorage.readOne(id);
    final var newTask = task.close();
    taskStorage.update(id, newTask);
  }

  public void complete(final UUID id) {
    final var task = taskStorage.readOne(id);
    final var newTask = task.complete();
    taskStorage.update(id, newTask);
  }

}
