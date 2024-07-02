package lab3;

public class Warehouse {
    private static int totalItems;

    public synchronized static int getTotalItems() {
        return totalItems;
    }
    public Warehouse() {
    }

    public synchronized static int consumeItem(int n) {
        return totalItems = totalItems - n;
    }

    public synchronized static void addItem(int n) {
        totalItems = totalItems + n;
    }
}
