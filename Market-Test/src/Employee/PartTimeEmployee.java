package Employee;

public class PartTimeEmployee extends Employee {
    private int hourlyRate;
    private int shift;

    public PartTimeEmployee(String name, String department, int hourlyRate, int shift) {
        super(name, department);
        this.hourlyRate = hourlyRate;
        this.shift = shift;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public int getShift() {
        return shift;
    }

    @Override
    public int calculateSalary() {
        return hourlyRate * 4 * shift;
    }
}
