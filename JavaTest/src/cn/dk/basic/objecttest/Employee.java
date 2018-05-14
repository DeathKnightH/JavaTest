package cn.dk.basic.objecttest;

import java.util.Objects;

public class Employee {

    private String name;

    private String workId;

    public Employee(String name){
        this.name = name;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
