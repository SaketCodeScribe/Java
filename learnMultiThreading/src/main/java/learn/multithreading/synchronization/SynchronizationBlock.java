package learn.multithreading.synchronization;

class Increments{
    int i=0;

    public void increment(){
        synchronized (this) {
            i++;
            System.out.println("Thread "+Thread.currentThread().getId()+": "+ i);
        }
    }
}

public class SynchronizationBlock {

    public static void main(String[] args) {
        // Creating two threads
        Increments obj = new Increments();
        Thread firstThread = new Thread(new IncrementThread(obj));
        Thread secondThread = new Thread(new IncrementThread(obj));

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

    }

    // Runnable class to be used by threads
    static class IncrementThread implements Runnable {
        Increments inc;

        IncrementThread(Increments obj){
            inc = obj;
        }
        @Override
        public void run() {
            inc.increment();
        }
    }
}
