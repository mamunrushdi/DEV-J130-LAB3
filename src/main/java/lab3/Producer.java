package lab3;

import java.util.concurrent.ThreadLocalRandom;

public class Producer {
    public synchronized void produce() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(800, 1000));
        while (!Warehouse.isNeedToFill()){
            wait();
            System.out.printf(Thread.currentThread().getName() +  " went to sleep.");

        }
        int item = ThreadLocalRandom.current().nextInt(1, 3);
        Warehouse.addItem(item);
        System.out.printf(Thread.currentThread().getName() +  " added %d item(s) to warehouse.\n", item);
        // notify consumer that new item has been added to Warehouse
        // it can starts consume now
        notify();
        Thread.sleep(ThreadLocalRandom.current().nextInt(800, 1000));
    }
}
