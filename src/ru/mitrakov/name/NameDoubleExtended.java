package ru.mitrakov.name;

public class NameDoubleExtended extends NameExtended {

    public NameDoubleExtended(String name) {
        this(name, null, null);
    }

    public NameDoubleExtended(String name, String surname) {
        this(name, surname, null);
    }

    public NameDoubleExtended(String name, String surname, String patronymic) {
        super(name, surname, patronymic);
        if (fieldsAreEmpty(name, surname, patronymic)) {
            throw new IllegalArgumentException("All fields are empty!");
        }
    }

    private boolean fieldsAreEmpty(String name, String surname, String patronymic) {
        return (name == null || name.isEmpty())
                && (surname == null || surname.isEmpty())
                && (patronymic == null || patronymic.isEmpty());
    }
}
