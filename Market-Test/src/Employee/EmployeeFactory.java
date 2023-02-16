package Employee;

public class EmployeeFactory {
    public static Employee createEmployee(String type, String name, String department, int... args) {
        if (type.equalsIgnoreCase("fulltime")) {
            return new FullTimeEmployee(name, department, args[0]);
        } else if (type.equalsIgnoreCase("parttime")) {
            return new PartTimeEmployee(name, department, args[0], args[1]);
        } else {
            throw new IllegalArgumentException("Invalid employee type: " + type);
        }
    }
}