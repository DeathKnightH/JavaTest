package cn.dk.basic.objecttest;

public class Manager extends Employee {
    static{ System.out.println("Loading Manager Class");}
    private double bonus;

    public Manager(String name, String workID,double salary, int year, int month, int day){
        super(name, workID, salary, year, month, day);
        this.bonus = 0;
        System.out.println("construct of Manager Instance");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        double base = super.getSalary();
        return bonus + base;
    }

    @Override
    public String toString() {
        return super.toString() +
                "bonus=" + bonus +
                '}';
    }
}
