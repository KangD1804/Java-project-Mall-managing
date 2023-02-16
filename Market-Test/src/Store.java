public class Store {
    private String name, location;
    private int floor;
    private int capacity;

    private Store(StoreBuilder builder) {
        this.name = builder.name;
        this.location = builder.location;
        this.floor = builder.floor;
        this.capacity = builder.capacity;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getFloor() {
        return floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public static class StoreBuilder {
        private String name;
        private String location;
        private int floor;
        private int capacity;

        public StoreBuilder(String name, String location) {
            this.name = name;
            this.location = location;
        }

        public StoreBuilder setFloor(int floor) {
            this.floor = floor;
            return this;
        }

        public StoreBuilder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Store build() {
            return new Store(this);
        }
    }
}

