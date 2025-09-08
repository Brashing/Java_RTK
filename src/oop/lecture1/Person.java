package oop.lecture1;


public class Person {
    protected String fio;
    protected String address;

    public Person(String fio, String address) {
        this.address = address;
        this.fio = fio;
    }

    protected void sleep() {
        System.out.println("I am sleeping");
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}