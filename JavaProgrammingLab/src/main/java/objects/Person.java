package objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    protected String name;
    protected String surname;
    protected LocalDate dob;

    Person() {
        this.name = "SampleName";
        this.surname = "SampleSurname";
    }

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    Person(String name, String surname, String dob) {
        this.name = name;
        this.surname = surname;

        String[] splitDob = dob.split("/");  //String split

        this.dob = LocalDate.of(Integer.parseInt(splitDob[0]), Integer.parseInt(splitDob[1]), Integer.parseInt(splitDob[2]));
    }

    public String getName() {
        return this.name;
    };

    public String getSurname() {
        return this.surname;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public String getDobString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return this.dob.format(formatter);
    }
}
