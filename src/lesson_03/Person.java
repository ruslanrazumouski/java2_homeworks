package lesson_03;

public class Person {
    private String fio;

    Person(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                '}';
    }
}
