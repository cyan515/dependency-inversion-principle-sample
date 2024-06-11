package com.example.domain.entity;

import com.example.domain.valueobject.Status;
import java.util.UUID;

public record Task(UUID id, String name, Status status) {

  public Task start() {
    return new Task(this.id, this.name, Status.IN_PROGRESS);
  }

  public Task close() {
    return new Task(this.id, this.name, Status.CLOSED);
  }

  public Task complete() {
    return new Task(this.id, this.name, Status.COMPLETED);
  }

}
