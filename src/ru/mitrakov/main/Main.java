package ru.mitrakov.main;

import ru.mitrakov.fraction.Fraction;
import ru.mitrakov.name.Name;
import ru.mitrakov.secret.Secret;

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
          case "1-7": {
            System.out.println("Непустые имена.");
            obj.pleaseEnter("имя");
            String name = scanner.next();
            obj.pleaseEnter("фамилию");
            String surname = scanner.next();
            obj.pleaseEnter("отчество");
            String patronymic = scanner.next();
            Name person = new Name(name, surname, patronymic);
            System.out.println("Результат: " + person);
          }
          case "2-2": {
            System.out.println("Секреты");
            Secret secret = new Secret("Иван", "Мой дом на 10 улице");
            Secret secret1 = new Secret(secret, "Даша");
            Secret secret2 = new Secret(secret1, "Максим");
            Secret secret3 = new Secret(secret2, "Алексей");
            System.out.println(secret2.getOwner());
            System.out.println(secret2.getText());
            System.out.println(secret2.foundOutAfter());
            System.out.println(secret2.numberQueue());
            System.out.println(secret2.getNamePersonN(1));
            System.out.println(secret2.getDiff(1));
          }
          default: {
            System.out.println("Неизвестное задание");
            obj.visualBottomTab();
            continue;
          }
        }

        obj.visualBottomTab();
      } catch (Exception e) {
        System.out.println(e);
        obj.invalidValue();
        scanner.next();
      }
    }

    scanner.close();
    System.out.println("Программа успешно завершила работу.");
  }
}
