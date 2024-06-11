package com.example.domain.repository;

import com.example.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface ITaskRepository {

    void create(final Task task);

    Task readOne(final UUID id);

    List<Task> readAll();

    void update(final UUID id, final Task task);
}
