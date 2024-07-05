package lab3;

public class Warehouse {
    private static int totalItems;

    private static boolean needToFill = true;

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
        Warehouse.setNeedToFill(false);
    }


    public  static boolean isNeedToFill() {
        return needToFill;
    }

    public synchronized static void setNeedToFill(boolean needToFill) {
        Warehouse.needToFill = needToFill;
    }
}
