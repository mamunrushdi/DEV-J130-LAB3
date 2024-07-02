package lab3;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Thread producer = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            Producer producer = new Producer();
                            try {
                                producer.produce();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
            );
            int n = i + 1;
            producer.setName("producer-" + n);
            producer.start();
        }

        for (int i = 0; i < 7; i++) {
            Thread consumer = new Thread(new Runnable() {
                @Override
                public void run() {
                    Consumer consumer = new Consumer();
                    try {
                        consumer.consume();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            int n = i + 1;
            consumer.setName("consumer-" + n);
            consumer.start();
        }
    }
}
