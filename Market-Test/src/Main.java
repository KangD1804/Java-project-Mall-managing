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


        // Create a new store database
        StoreDatabase storeDatabase = StoreDatabase.getInstance();

        // Write the store list to a file
        storeDatabase.exportStoreList("store_data.txt");
        storeDatabase.exportRentList("store_rent_data.txt");
        System.out.println(storeDatabase.getStoresOnFloor(1).toString());
      Employee fullTimeEmployee = EmployeeFactory.createEmployee("fulltime", "Chinh Pham", "It", 50000);
        Employee partTimeEmployee = EmployeeFactory.createEmployee("parttime", "Khang Doan", "IT", 25, 20);

    }
}
