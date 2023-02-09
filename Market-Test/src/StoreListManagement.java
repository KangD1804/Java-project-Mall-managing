import java.util.HashSet;
import java.util.Set;

public class StoreListManagement {
    private static Set<Store> stores = new HashSet<>();
    private static Set<Product> products = new HashSet<>();
    private static Set<Customer> customers = new HashSet<>();


    public static Set<Store> getStores() {
        return stores;
    }

    public static Set<Product> getProducts() {
        return products;
    }

    public static Set<Customer> getCustomers() {
        return customers;
    }

    public static Set<Product> addProduct(Product product){
        products.add(product);
        return products;
    }

    public static Set<Customer> addCustomer(Customer customer){
        customers.add(customer);
        return customers;
    }

    public static Set<Store> addStore(Store store){
        stores.add(store);
        return stores;
    }

    public static Product getProductById(int productId, Long storeId){
        for(Store store : stores){
             if(storeId == store.getStoreId()){
                for(Product product : products){
                    if(productId == product.getProductId()){
                        return product;
                    }else throw new IllegalArgumentException("Sản phẩm không tồn tại");
                }
            }
        } throw new IllegalArgumentException("Cửa hàng không tồn tại");
    }

}
