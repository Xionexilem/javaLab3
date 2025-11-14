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

    int N = (int) (text.length() * 0.1);
    int X = random.nextInt(N);
    StringBuilder result = new StringBuilder(text);
    for (int i = 0; i < X; i++) {
      char symbol = (char) random.nextInt(65535);
      int position = random.nextInt(result.length());
      result.insert(position, symbol);
    }
    return result.toString();
  }

  public String getText() {
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
    if ((numberQueue() - 1) <= N && N <= foundOutAfter()) {
      Secret secret = this;
      for (int i = 0; i < N; i++) {
        secret = secret.prev;
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
