package ru.mitrakov.main;

import ru.mitrakov.fraction.Fraction;

import java.util.Scanner;

public class Main {
  // Для визулаьной части начала задания
  private void visualTopTab (int exercise, int task) {
    String visual = " ========== ";
    System.out.println(visual + "Задание №" + exercise + "  Задача №" + task + visual);
  }

  // Для визуальной части конца задания
  private void visualBottomTab () {
    String visual = " ================== ";
    System.out.println(visual + "Конец" + visual);
  }

  // Сообщение о неизвестной задаче
  private void unknownTask (int exercise) {
    System.out.println("Неизвестная задача в задании №" + exercise);
  }

  // Сообщение о неверном значении
  private void invalidValue () {
    System.out.println("Введено неверное значение, попробуйте ещё раз.");
  }

  // Просьба ввода
  private void pleaseEnter (String text) {
    System.out.print("Введите " + text + ": ");
  }

  public static void main(String[] args) {
    Main obj = new Main();
    Scanner scanner = new Scanner(System.in);
    boolean isWork = true;

    while (isWork) {
      try {
        obj.pleaseEnter("номер задания (-1 - выход)");
        int numberExercise = scanner.nextInt();

        if (numberExercise == -1) {isWork = false; break;}

        obj.pleaseEnter("номер задачи");
        int numberTask = scanner.nextInt();

        obj.visualTopTab(numberExercise, numberTask);

        switch (numberExercise + "-" + numberTask) {
          case "1-4": {
            System.out.println("Дроби.");
            obj.pleaseEnter("числитель");
            int numerator = scanner.nextInt();
            obj.pleaseEnter("знаменатель");
            int denominator = scanner.nextInt();
            Fraction f = new Fraction(numerator, denominator);
            System.out.println("Результат: " + f);
            break;
          }
          default: {
            System.out.println("Неизвестное задание");
            obj.visualBottomTab();
            continue;
          }
        }

        obj.visualBottomTab();
      } catch (Exception e) {
        obj.invalidValue();
        scanner.next();
      }
    }

    scanner.close();
    System.out.println("Программа успешно завершила работу.");
  }
}
