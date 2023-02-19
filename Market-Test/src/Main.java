import Parking.ParkingSlotFactory;
import Store.*;
import Employee.*;

public class Main {
    public static void main(String[] args) {
        Store Fahasa = new Store.StoreBuilder("FAHASA", "Nguyễn Văn Trỗi")
                .setFloor(1)
                .setCapacity(40)
                .setRent(1000)
                .build();

        Store FoodCourt = new Store.StoreBuilder("FoodStore", "Nam Kì Khởi Nghĩa")
                .setFloor(2)
                .setCapacity(40)
                .setRent(1000)
                .build();

        Store Electronics = new Store.StoreBuilder("Tiệm đồ điện", "Nam Kì Khởi Nghĩa")
                .setFloor(2)
                .setCapacity(40)
                .setRent(1000)
                .build();

        Store DMX = new Store.StoreBuilder("Điện Máy Xanh", "Nam Kì Khởi Nghĩa")
                .setFloor(2)
                .setCapacity(40)
                .setRent(1000)
                .build();

        Store TGDD = new Store.StoreBuilder("Thế Giới Di Động", "Nam Kì Khởi Nghĩa")
                .setFloor(2)
                .setCapacity(40)
                .setRent(1000)
                .build();

        Store PNC = new Store.StoreBuilder("Nhà Sách Phương Nam", "Nguyễn Văn Trỗi")
                .setFloor(1)
                .setCapacity(40)
                .setRent(1000)
                .build();

        StoreDatabase storeDatabase = StoreDatabase.getInstance();

/*        storeDatabase.exportStoreList("store_data.txt");
        storeDatabase.exportRentList("store_rent_data.txt");*/

        Employee ChinhPham = EmployeeFactory.createEmployee("fulltime", "Chinh Pham", "It", "motorbike",true,3000);
        Employee DuongPham = EmployeeFactory.createEmployee("fulltime", "Duong Pham", "CEO/COO??","car",true, 5000);
        Employee DaoNgyen = EmployeeFactory.createEmployee("fulltime", "Dao Nguyen", "It","motorbike",true,3000);
        Employee AnhNguyen = EmployeeFactory.createEmployee("fulltime", "Anh Nguyen", "CAA","car",false,3000);
        Employee HaHoang = EmployeeFactory.createEmployee("fulltime", "Ha Hoang", "Sales", "motorbike",false,3000);


        Employee KhangDoan = EmployeeFactory.createEmployee("parttime", "Khang Doan", "It","motorbike",true ,25,20);
        Employee ThaoLe = EmployeeFactory.createEmployee("parttime", "Thao Le", "IT","car",false, 25, 20);
        Employee PhuVo = EmployeeFactory.createEmployee("parttime", "Phu Vo", "IT","motorbike",false, 25, 20);
        Employee ThanhNguyen = EmployeeFactory.createEmployee("parttime", "Thanh Nguyen", "IT", "car",true,25, 20);

        EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();
/*        employeeDatabase.exportSalaryFullTime("fulltime_salary.txt");
        employeeDatabase.exportSalaryPartTime("parttime_salary.txt");*/
        System.out.println(ParkingSlotFactory.getEmployeeCount());

        employeeDatabase.exportParkingInfo("parking_info.txt");


    }
}
