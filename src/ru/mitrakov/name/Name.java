package ru.mitrakov.name;

public class Name {
  protected String name;
  protected String surname;
  protected String patronymic;

  public Name(String name) {
    this(name, null, null);
  }

  public Name(String name, String surname) {
    this(name, surname, null);
  }

  public Name(String name, String surname, String patronymic) {
    if (fieldsAreEmpty(name, surname, patronymic)) {
      throw new IllegalArgumentException("All fields are empty!");
    }

    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
  }

  protected String changeString(String string, Boolean space) {
    StringBuilder result = new StringBuilder();
    if (string != null && !string.isEmpty()) {
      result.append(string);
      if (space) {result.append(" ");}
    }
    return result.toString();
  }

  private boolean fieldsAreEmpty(String name, String surname, String patronymic) {
    return (name == null || name.isEmpty())
            && (surname == null || surname.isEmpty())
            && (patronymic == null || patronymic.isEmpty());
  }

  @Override
  public String toString() {
    return changeString(name, true) +
           changeString(surname, true) +
           changeString(patronymic, false);
  }
}
