import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Store> storeList = new HashSet<>();
        storeList.add(new Store(1L,"Cửa hàng 1","Chủ 1", 50));
        storeList.add(new Store(1L,"Cửa hàng 1","Chủ 1", 50));
        storeList.add(new Store(1L,"Cửa hàng 1","Chủ 1", 50));
        storeList.add(new Store(1L,"Cửa hàng 1","Chủ 1", 50));
        for(Store store : storeList){
            System.out.println(store.toString());
        }
    }
}
