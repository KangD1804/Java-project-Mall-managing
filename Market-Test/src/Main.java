import Store.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store.StoreBuilder("My Store.Store", "Main Street")
                .setFloor(1)
                .setCapacity(40)
                .setRent(1000)
                .build();
        // Create a new store database
        StoreDatabase storeDatabase = StoreDatabase.getInstance();
        // Write the store list to a file
        storeDatabase.exportStoreList("store_data.txt");
/*        Employee fullTimeEmployee = EmployeeFactory.createEmployee("fulltime", "Chinh Pham", "It", 50000);
        Employee partTimeEmployee = EmployeeFactory.createEmployee("parttime", "Khang Doan", "IT", 25, 20);*/

    }
}
