package com.example.infrastructure;

import com.example.domain.entity.Task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TodoRepository {

  private final Map<UUID, Task> store = new HashMap<>();

  public void create(final Task task) {
    if(store.containsKey(task.id())) throw new IllegalStateException("Key is duplicated");
    store.put(task.id(),task);
  }

  public Task readOne(final UUID id) {
    return store.get(id);
  }

  public List<Task> readAll() {
    return store.values().stream().toList();
  }

  public void update(final UUID id, final Task task) {
    store.put(id, task);
  }

}
