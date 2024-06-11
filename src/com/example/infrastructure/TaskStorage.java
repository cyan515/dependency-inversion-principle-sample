package com.example.infrastructure;

import com.example.domain.entity.Task;
import com.example.domain.repository.ITaskRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskStorage implements ITaskRepository {

  private final Map<UUID, Task> store = new HashMap<>();

  @Override
  public void create(final Task task) {
    if(store.containsKey(task.id())) throw new IllegalStateException("Key is duplicated");
    store.put(task.id(),task);
  }

  @Override
  public Task readOne(final UUID id) {
    return store.get(id);
  }

  @Override
  public List<Task> readAll() {
    return store.values().stream().toList();
  }

  @Override
  public void update(final UUID id, final Task task) {
    store.put(id, task);
  }

}
