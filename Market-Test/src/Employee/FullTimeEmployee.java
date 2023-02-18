package Employee;

public class FullTimeEmployee extends Employee {
    private int salary;
    private int restDay;
    public FullTimeEmployee(String name, String department, int salary) {
        super(name, department);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int calculateSalary() {
        return salary;
    }
}