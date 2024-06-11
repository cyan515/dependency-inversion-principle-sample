package com.example.application;

import com.example.domain.valueobject.Status;
import com.example.domain.entity.Task;
import com.example.infrastructure.TodoRepository;
import java.util.List;
import java.util.UUID;

public class AppService {

  private final TodoRepository repo = new TodoRepository();

  public List<Task> list() {
    return repo.readAll();
  }

  public void create(final String name) {
    final var task = new Task(UUID.randomUUID(), name, Status.TODO);
    repo.create(task);
  }

  public void start(final UUID id) {
    final var task = repo.readOne(id);
    final var newTask = task.start();
    repo.update(id, newTask);
  }

  public void close(final UUID id) {
    final var task = repo.readOne(id);
    final var newTask = task.close();
    repo.update(id, newTask);
  }

  public void complete(final UUID id) {
    final var task = repo.readOne(id);
    final var newTask = task.complete();
    repo.update(id, newTask);
  }

}
