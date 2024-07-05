package lab3;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer {
    public synchronized void consume() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(800, 1000));
        int item = ThreadLocalRandom.current().nextInt(1, 3);
        while(Warehouse.getTotalItems() < item){
            Warehouse.setNeedToFill(true);
            // Notify the producer
            notify();
            System.out.println(Thread.currentThread().getName() +  " is waiting");
            wait();
        }
        // consume item
        Warehouse.consumeItem(item);
        System.out.printf(Thread.currentThread().getName() +  " consumed %d item.\n", item);

        Thread.sleep(ThreadLocalRandom.current().nextInt(800, 1000));
    }
}
