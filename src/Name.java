public final class Name {
  private final String name;
  private final String surname;
  private final String patronymic;

  public Name(String name) {
    this(name, null, null);
  }

  public Name(String name, String surname) {
    this(name, surname, null);
  }

  public Name(String name, String surname, String patronymic) {
    if (allIsNull(name, surname, patronymic)) {
      throw new IllegalArgumentException("All fields are empty");
    }
    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
  }

  private Boolean argIsNull(String arg) {
    return arg == null || arg.isEmpty();
  }
  
  private Boolean allIsNull(String name, String surname, String patronymic) {
    return argIsNull(name) && argIsNull(surname) && argIsNull(patronymic);
  }

  private String changeString(String string, Boolean space) {
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
