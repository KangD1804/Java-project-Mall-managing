package Employee;

public class FullTimeEmployee extends Employee {
    private int salary;
    private boolean isRegisteredParkingSlot;
    private String vehicle;
    public FullTimeEmployee(String name, String department,String vehicle, boolean isRegisteredParkingSlot, int salary) {
        super(name, department);
        this.salary = salary;
        this.vehicle = vehicle;
        this.isRegisteredParkingSlot = isRegisteredParkingSlot;
    }

    public String getVehicle() {
        return vehicle;
    }

    public boolean isRegisteredParkingSlot() {
        return isRegisteredParkingSlot;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int calculateSalary() {
        return salary;
    }
}