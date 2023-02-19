package Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDatabase {
    private static EmployeeDatabase instance = null;
    private List<PartTimeEmployee> partTimeEmployeeList;
    private List<FullTimeEmployee> fullTimeEmployeeList;

    private EmployeeDatabase(){
        fullTimeEmployeeList = new ArrayList<>();
        partTimeEmployeeList = new LinkedList<>();
    }

    public static EmployeeDatabase getInstance(){
        if (instance == null) {
            instance = new EmployeeDatabase();
        }
        return instance;
    }

    public void addPartTimeEmployee(PartTimeEmployee employee){
        partTimeEmployeeList.add(employee);
    }

    public void addFullTimeEmployee(FullTimeEmployee employee){
        fullTimeEmployeeList.add(employee);
    }

    public void removeEmployee(Employee employee){
        if(employee instanceof FullTimeEmployee){
            fullTimeEmployeeList.remove(employee);
        } else partTimeEmployeeList.remove(employee);
    }

    public int calculateTotalSalary(){
        int totalSalary = 0;
        for(Employee employee : partTimeEmployeeList){
            totalSalary += employee.calculateSalary();
        }
        for (Employee employee : fullTimeEmployeeList){
            totalSalary+= employee.calculateSalary();
        }
        return totalSalary;
    }

    public double calculateCarPark(){
        double carFee = 0;
        for (FullTimeEmployee employee : fullTimeEmployeeList){
            if(employee.isRegisteredParkingSlot() && employee.getVehicle().equalsIgnoreCase("Car")){
                carFee += 30;
            }
        }
        return carFee;
    }
    public double calculateBikePark(){
        double bikeFee = 0;
        for (FullTimeEmployee employee : fullTimeEmployeeList){
            if(employee.isRegisteredParkingSlot() && employee.getVehicle().equalsIgnoreCase("motorbike")){
                bikeFee += 10;
            }
        }
        return bikeFee;
    }

    public void exportSalaryPartTime(String filename) {
        FileWriter fileWriter = null;
        try {
            double total = 0;
            fileWriter = new FileWriter(filename);
            for (Employee employee : partTimeEmployeeList ) {
                total += employee.calculateSalary();
                fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " : " + employee.calculateSalary()+"\n");
            }
            fileWriter.write("Total full time salaries: " +total);

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void exportSalaryFullTime(String filename) {
        FileWriter fileWriter = null;
        try {
            double total = 0;
            fileWriter = new FileWriter(filename);
            for (Employee employee : fullTimeEmployeeList ) {
                total += employee.calculateSalary();
                fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " : " + employee.calculateSalary()+"\n");
            }
            fileWriter.write("Total full time salaries: " +total);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void exportParkingInfo(String filename){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            for (FullTimeEmployee employee : fullTimeEmployeeList ) {
                if(employee.isRegisteredParkingSlot() && employee.getVehicle().equalsIgnoreCase("motorbike")) {
                    fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " drive " + employee.getVehicle() + " pay " + "10$ for parking." + "\n");
                } else if(employee.isRegisteredParkingSlot() && employee.getVehicle().equalsIgnoreCase("car")){
                    fileWriter.write(employee.getName() + " working at " + employee.getDepartment() + " drive " + employee.getVehicle() + " pay " + "30& for parking." + "\n");
                }
            }
            fileWriter.write("Total motorbike parking slots revenue from employee: " +this.calculateBikePark() +"\n");
            fileWriter.write("Total car parking slots revenue from employee: " +this.calculateCarPark());

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }

    }

}
