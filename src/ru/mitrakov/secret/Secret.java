package ru.mitrakov.secret;

import java.util.Random;

public class Secret {
  private final String text;
  private final String owner;
  private Secret prev;
  private Secret next;

  public Secret(String owner, String text) {
    this.text = text;
    this.owner = owner;
    this.prev = null;
    System.out.println("Секрет: " + text);
  }

  public Secret(Secret secret, String owner) {
    if (secret.next != null) {
      throw new IllegalArgumentException("The secret had already been told");
    }
    this(owner, litterSecret(secret.getText()));
    this.prev = secret;
    this.prev.next = this;
    System.out.println(secret.getOwner() + " сказал, что " + secret.getText());
  }

  private static String litterSecret(String text) {
    Random random = new Random();

    int N = Math.max(1, (int) (text.length() * 0.1));
    int X = random.nextInt(N) + 1;
    StringBuilder result = new StringBuilder(text);
    for (int i = 0; i < X; i++) {
      char symbol = generatePrintableChar(random);
      int position = random.nextInt(result.length() + 1);
      result.insert(position, symbol);
    }
    return result.toString();
  }

  private static char generatePrintableChar(Random random) {
    // Диапазоны печатных символов:
    // Латинские буквы, кирилица, цифры, базовая пунктуация
    String printableChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮйцукенгшщзхъфывапролджэячсмитьбю0123456789!@#$%^&*()_+-=[]{}|;:,.<>?";
    return printableChars.charAt(random.nextInt(printableChars.length()));
}

  private String getText() {
    return this.text;
  }

  public String getOwner() {
    return this.owner;
  }

  public int numberQueue() {
    int count = 1;
    Secret queue = this;
    while (queue.prev != null) {
      count++;
      queue = queue.prev;
    }
    return count;
  }

  public int foundOutAfter() {
    int count = 0;
    Secret queue = this;
    while (queue.next != null) {
      count++;
      queue = queue.next;
    }
    return count;
  }

  private Secret getSecretN (int N) {
    Secret secret = this;
    if (-numberQueue() <= N && N < 0) {
      N = Math.abs(N);
      for (int i = 0; i < N; i++) {
        secret = secret.prev;
      }
      return secret;
    } else if (0 <= N && N <= foundOutAfter()) {
      for (int i = 0; i < N; i++) {
        secret = secret.next;
      }
      return secret;
    }
    throw new ArrayIndexOutOfBoundsException("There is no keeper of the secret number " + N);
  }

  public String getNamePersonN(int N) {
    Secret secret = getSecretN(N);
    return secret.getOwner();
  }

  public int getDiff(int N) {
    Secret secret = getSecretN(N);
    return Math.abs(secret.text.length() - this.text.length());
  }

  @Override
  public String toString() {
    return this.owner + ": это секрет!";
  }
}
