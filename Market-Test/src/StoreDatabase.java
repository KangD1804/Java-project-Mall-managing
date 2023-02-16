import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class StoreDatabase {
    private static StoreDatabase instance = null;
    private Set<Store> storeList = new HashSet<>();
    private Set<String> storeExisted = new HashSet<>();
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
        if(storeList.size() > 0){
            for (int i =0; i < storeList.size(); i++) { //Concurent modification exception neu xai for each
//                String storeName = store.getName();
                if (!storeExisted.contains(store.getName())) {
                    storeList.add(store);
                    int floor = store.getFloor();
                    Set<Store> storesOnFloor = storesByFloor.getOrDefault(floor, new HashSet<>()); //loai kha nang bi null pointer exception neu tang do chua co trong map
                    storesOnFloor.add(store);
                    storesByFloor.put(floor, storesOnFloor);
                } else {
                    System.out.println("store name: " +store.getName() +" is added/existed");
                }
            }
        }else {
            storeList.add(store);
            storeExisted.add(store.getName());
            int floor = store.getFloor();
            Set<Store> storesOnFloor = storesByFloor.getOrDefault(floor, new HashSet<>());
            storesOnFloor.add(store);
            storesByFloor.put(floor, storesOnFloor);
        }
    }
    public void removeStore(Store store){ //try cactch hay if else
        if(storeList.contains(store)){
            storeList.remove(store);
        } else {
            System.out.println("Store not exist.");
        }
    }

    public Set<Store> getStoresOnFloor(int floor) {
        // Get the set of stores on the given floor
        return storesByFloor.getOrDefault(floor, new HashSet<>());
    }

    public void writeStoreListToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Store store : storeList) {
                writer.write(store.getName() + "," + store.getFloor() + "," + "\n");
            }
        } catch (IOException e) {
            System.out.println("Something wrong happened!");
        }
    }

    public void exportStoreList(String filename) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            for (Store store : storeList) {
                fileWriter.write(store.getName() + "," + store.getFloor() + "," +"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}