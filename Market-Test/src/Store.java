public class Store {
    private Long storeId;
    private String storeName,owner;
    private int revenue;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public Store(Long storeId, String storeName, String owner, int revenue) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.owner = owner;
        this.revenue = revenue;
    }
}
