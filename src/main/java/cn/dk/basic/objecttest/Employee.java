package cn.dk.basic.objecttest;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    static{ System.out.println("Loading Employee Class");}
    private String name;

    private String workId;

    private double salary;

    private LocalDate hireDay;

    public Employee(String name, String workId, double salary){
        this(name, workId, salary, LocalDate.now());
        System.out.println("call the public constructor of Employee Instance");
    }
    public Employee(String name, String workId, double salary, int year, int month, int day){
        this(name, workId, salary, LocalDate.of(year, month, day));
        System.out.println("call the public constructor of Employee Instance");
    }

    private Employee(String name, String workId, double salary, LocalDate hireDay){
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
        System.out.println("call the private constructor of Employee Instance");
    }

    public String getWorkId() {
        return workId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                "{name='" + name + '\'' +
                ", workId='" + workId + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(workId, employee.workId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, workId);
    }
}
