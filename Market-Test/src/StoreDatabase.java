import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class StoreDatabase {
    private static StoreDatabase instance = null;
    private Set<Store> storeList;
    private Map<Integer, Set<Store>> storesByFloor;

    private StoreDatabase() {
        // Initialize the map of stores by floor
        storesByFloor = new HashMap<>();
    }

    public static StoreDatabase getInstance() {
        if (instance == null) {
            instance = new StoreDatabase();
        }
        return instance;
    }

    public void addStore(Store store) {
        // Get the floor number of the store
        for (Store storeExisted : storeList) {
            if (!store.getName().equalsIgnoreCase(storeExisted.getName())) {
                storeList.add(store);
                int floor = store.getFloor();

                // Add the store to the set of stores on the floor
                Set<Store> storesOnFloor = storesByFloor.getOrDefault(floor, new HashSet<>());
                storesOnFloor.add(store);

                // Update the map of stores by floor
                storesByFloor.put(floor, storesOnFloor);
            } else {
                throw new IllegalArgumentException("Shop existed");
            }
        }

    }

    public Set<Store> getStoresOnFloor(int floor) {
        // Get the set of stores on the given floor
        return storesByFloor.getOrDefault(floor, new HashSet<>());
    }

    public void writeStoreListToFile(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Store store : storeList) {
                writer.write(store.getName() + "," + store.getFloor() + "," + store.getCategory() + "\n");
            }
        }
    }
}