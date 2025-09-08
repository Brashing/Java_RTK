package oop.lecture1;

public class Main {
    public static void main(String[] args) {
        School school = new School("Школа 556", "Санкт-Петербург");
        School school1 = new School("Школа 556");
        Person myPerson = new Student("Гаврилов Андрей", "Бишкек", school);
        System.out.println(myPerson);
        myPerson.sleep();
        ((Student) myPerson).study();
    }
}