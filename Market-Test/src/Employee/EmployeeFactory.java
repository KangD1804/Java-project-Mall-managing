package Employee;

public class EmployeeFactory {
    public static Employee createEmployee(String type, String name, String department, int... args) {
        if (type.equalsIgnoreCase("fulltime")) {
            FullTimeEmployee employee = new FullTimeEmployee(name, department, args[0]);
            EmployeeDatabase.getInstance().addFullTimeEmployee(employee);
            return employee;
        } else if (type.equalsIgnoreCase("parttime")) {
            PartTimeEmployee employee = new PartTimeEmployee(name , department, args[0], args[1]);
            EmployeeDatabase.getInstance().addPartTimeEmployee(employee);
            return employee;
        } else {
            throw new IllegalArgumentException("Invalid employee type: " + type);
        }
    }
}