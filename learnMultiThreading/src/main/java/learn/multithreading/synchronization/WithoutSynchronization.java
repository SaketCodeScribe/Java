package learn.multithreading.synchronization;

public class WithoutSynchronization {
    private static int i = 0;

    public static void main(String[] args) {
        // Creating two threads
        Thread firstThread = new Thread(new IncrementThread());
        Thread secondThread = new Thread(new IncrementThread());

        // Starting both threads
        firstThread.start();
        secondThread.start();

        try {
            // Waiting for both threads to finish
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Displaying the final value of the shared variable i
        System.out.println("Final value of i (without synchronization): " + i);
    }

    // Runnable class to be used by threads
    static class IncrementThread implements Runnable {
        @Override
        public void run() {
            // Accessing and updating the shared variable i without synchronization
            int currentValue = i;
            System.out.println("Thread " + Thread.currentThread().getId() + " - Current value of i: " + currentValue);

            // Simulating some computation or delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Incrementing and updating the shared variable i
            i = currentValue + 1;
            System.out.println("Thread " + Thread.currentThread().getId() + " - Updated value of i: " + i);
        }
    }
}

