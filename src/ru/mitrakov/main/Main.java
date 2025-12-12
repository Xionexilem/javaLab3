package ru.mitrakov.main;

import ru.mitrakov.fraction.Fraction;
import ru.mitrakov.name.Name;
import ru.mitrakov.secret.Secret;
import ru.mitrakov.summator.SumNumbers;

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
            break;
          }
          case "2-2": {
            Secret currentSecret = null;
            boolean flag = true;
            while (flag) {
              System.out.println("\n--- Меню управления секретами ---");
              System.out.println("1. Создать первый секрет");
              System.out.println("2. Передать секрет");
              System.out.println("3. Показать информацию о текущем секрете");
              System.out.println("4. Получить владельца секрета по номеру");
              System.out.println("5. Вычислить разницу длин текста");
              System.out.println("0. Выйти из задания");
              System.out.print("Выберите действие: ");

              int choice = scanner.nextInt();
              scanner.nextLine();

              try {
                switch (choice) {
                  case 0:
                    flag = false;
                    break;

                  case 1:
                    System.out.print("Введите имя владельца секрета: ");
                    String owner = scanner.nextLine();
                    System.out.print("Введите текст секрета: ");
                    String text = scanner.nextLine();
                    currentSecret = new Secret(owner, text);
                    System.out.println("Секрет создан!");
                    break;

                  case 2:
                    if (currentSecret == null) {
                      System.out.println("Сначала создайте первый секрет!");
                      continue;
                    }
                    System.out.print("Введите имя нового владельца секрета: ");
                    String newOwner = scanner.nextLine();
                    currentSecret = new Secret(currentSecret, newOwner);
                    break;

                  case 3:
                    if (currentSecret == null) {
                      System.out.println("Секрет не создан!");
                      continue;
                    }
                    System.out.println("Текущий секрет: " + currentSecret);
                    System.out.println("Владелец: " + currentSecret.getOwner());
                    System.out.println("Номер в цепочке: " + currentSecret.numberQueue());
                    System.out.println("Передан дальше: " + currentSecret.foundOutAfter() + " раз");
                    break;

                  case 4:
                    if (currentSecret == null) {
                      System.out.println("Секрет не создан!");
                      continue;
                    }
                    System.out.print("Введите номер секрета (положительный или отрицательный): ");
                    int secretNum = scanner.nextInt();
                    System.out.println("Владелец секрета: " + currentSecret.getNamePersonN(secretNum));
                    break;

                  case 5:
                    if (currentSecret == null) {
                      System.out.println("Секрет не создан!");
                      continue;
                    }
                    System.out.print("Введите номер секрета для сравнения длины: ");
                    int diffNum = scanner.nextInt();
                    System.out.println("Разница в длине текста: " +
                        currentSecret.getDiff(diffNum) + " символов");
                    break;

                  default:
                    System.out.println("Неправильный выбор");
                }
              } catch (Exception e) {
                obj.invalidValue();
                scanner.next();
              }
            }
          }
          case "5-1": {
            System.out.println("Сложение.");

            SumNumbers summator = new SumNumbers();

            System.out.println("Пример 1: 2 + 3/5 + 2.3");
            Fraction fraction = new Fraction(3, 5);
            double result = summator.sum(2, fraction, 2.3);
            System.out.println("Результат: " + result);

            System.out.println("Пример 2: 3.6 + 49/12 + 3 + 3/2");
            fraction = new Fraction(49, 12);
            Fraction fraction2 = new Fraction(3, 2);
            result = summator.sum(3.6, fraction, 3, fraction2);
            System.out.println("Результат: " + result);

            System.out.println("Пример 3: 1/3 + 1");
            fraction = new Fraction(1, 3);
            result = summator.sum(fraction, 1);
            System.out.println("Результат: " + result);
            break;
          }
          case "6-1": {
            System.out.println("Сравнение дробей.");
            System.out.println("Первая дробь");
            obj.pleaseEnter("числитель");
            int num1 = scanner.nextInt();
            obj.pleaseEnter("знаменатель");
            int den1 = scanner.nextInt();
            Fraction fraction1 = new Fraction(num1, den1);
            
            System.out.println("Вторая дробь");
            obj.pleaseEnter("числитель");
            int num2 = scanner.nextInt();
            obj.pleaseEnter("знаменатель");
            int den2 = scanner.nextInt();
            Fraction fraction2 = new Fraction(num2, den2);

            boolean equals = fraction2.equals(fraction1);
            if (equals) {
              System.out.println("Дроби равны.");
            } else {
              System.out.println("Дроби не равны");
            }
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
