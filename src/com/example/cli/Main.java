package com.example.cli;

import static java.lang.StringTemplate.STR;

import com.example.application.AppService;
import java.util.Scanner;
import java.util.UUID;

public class Main {

  private static final Scanner sc = new Scanner(System.in);

  private static final AppService app = new AppService();

  public static void main(String[] args) {
    while (true) {
      System.out.println("Waiting your action...");
      final var command = sc.next();
      switch (command) {
        case "list" -> list();
        case "create" -> create();
        case "start" -> start();
        case "close" -> close();
        case "complete" -> complete();
        case "exit" -> exit();
        default -> unknown();
      }
    }
  }

  private static void list() {
    var li = app.list();
    System.out.println(STR."There is \{li.size()} task(s).");
    li.forEach(System.out::println);
  }

  private static void create() {
    System.out.println("Input the task name.");
    sc.nextLine();
    final var name = sc.nextLine();
    app.create(name);
  }

  private static void start() {
    System.out.println("Input the task ID.");
    final var id = UUID.fromString(sc.next());
    app.start(id);
  }

  private static void close() {
    System.out.println("Input the task ID.");
    final var id = UUID.fromString(sc.next());
    app.close(id);
  }

  private static void complete() {
    System.out.println("Input the task ID.");
    final var id = UUID.fromString(sc.next());
    app.complete(id);
  }

  private static void exit() {
    System.exit(0);
  }

  private static void unknown() {
    System.out.println("Error: Unknown command.");
  }

}
