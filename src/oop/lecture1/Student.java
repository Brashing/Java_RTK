package oop.lecture1;


public class Student extends Person {
    private final School school;
    public Student(String fio, String address, School school) {
        super(fio, address); // вызов родительского конструктора
        this.school = school;
    }

    @Override
    protected void sleep() {
        super.sleep();
        System.out.println("Student is sleeping");
    }

    public void study() {
        System.out.println("I am studying");
    }

    @Override
    public String toString() {
        return "Student{" +
                "school=" + school +
                ", fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}