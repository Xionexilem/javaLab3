package ru.mitrakov.name;

public class Name {
  protected String name;
  protected String surname;
  protected String patronymic;

  public Name(String surname, String name, String patronymic) {
    this.surname = surname;
    this.name = name;
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

  @Override
  public String toString() {
      return changeString(surname, true) +
              changeString(name, true) +
              changeString(patronymic, false);
  }
}
