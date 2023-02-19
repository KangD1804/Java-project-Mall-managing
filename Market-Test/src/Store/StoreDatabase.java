package Store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class StoreDatabase {
    private static StoreDatabase instance = null;
    private Set<Store> storeList;
    private Set<String> storeExisted;
    private Map<Integer, Set<Store>> storesByFloor;

    private StoreDatabase() {
        storesByFloor = new HashMap<>();
        storeList = new HashSet<>();
        storeExisted = new HashSet<>();
    }

    public static StoreDatabase getInstance() {
        if (instance == null) {
            instance = new StoreDatabase();
        }
        return instance;
    }

    public void addNewStore(Store store) {
        if(storeList.size() > 0){
            for (int i =0; i < storeList.size(); i++) { //Concurent modification exception neu xai for each
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

    public Store addStore(Store store) {
        storeList.add(store);
        storeExisted.add(store.getName());
        int floor = store.getFloor();
        Set<Store> storesOnFloor = storesByFloor.getOrDefault(floor, new HashSet<>());
        storesOnFloor.add(store);
        storesByFloor.put(floor, storesOnFloor);
        return store;
    }

    public void removeStore(Store store){
        if(storeList.contains(store)){
            storeList.remove(store);
        } else {
            System.out.println("Store.Store not exist.");
        }
    }

    public Set<Store> getStoresOnFloor(int floor) {
        return storesByFloor.getOrDefault(floor, new HashSet<>());
    }

    public int getTotalArea() {
    int totalArea = 0;
    for (Store store : storeList) {
        totalArea += store.getArea();
    }
    return totalArea;
    }

    public double calculateTotalRent(double ratePerUnitArea) {
        double totalRent = getTotalArea() * ratePerUnitArea;
        return totalRent;
    }

    public void exportStoreList(String filename) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            for (Store store : storeList) {
                fileWriter.write(store.getName() + " at floor " + store.getFloor() + " at " + store.getLocation() +"\n");
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

    public void exportRentList(String filename) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            for (Store store : storeList) {
                fileWriter.write(store.getName() + "at floor " + store.getFloor() + " is paying " + store.calculateRent(150.0) +"\n");
            }
            fileWriter.write("Total income from store: " +this.calculateTotalRent(150.0));
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