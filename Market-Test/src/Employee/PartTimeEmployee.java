package Employee;

public class PartTimeEmployee extends Employee {
    private int hourlyRate;
    private int hoursWorked;
    private int shift;

    public PartTimeEmployee(String name, String department, int hourlyRate, int hoursWorked) {
        super(name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public int calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
