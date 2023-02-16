import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a new store database
        StoreDatabase storeDatabase = StoreDatabase.getInstance();

        // Add some stores to the database
        storeDatabase.addStore(new Store("Clothing Store", 1, "Apparel"));
        storeDatabase.addStore(new Store("Bookstore", 2, "Books"));
        storeDatabase.addStore(new Store("Electronics", 3, "Electronics"));
        storeDatabase.addStore(new Store("Electronics", 3, "Electronics"));
        // Write the store list to a file
        storeDatabase.exportStoreList("store_data.txt");
    }
}
