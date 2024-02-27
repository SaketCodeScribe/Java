package learn.multithreading.synchronization;

/*
    Synchronization method.
 */

class Increment{
    int i=0;

    synchronized public void increment(){
        i++;
        System.out.println("Thread "+Thread.currentThread().getId()+": "+ i);
    }
}

public class SynchronizationMethod {

    public static void main(String[] args) {
        // Creating two threads
        Increment obj = new Increment();
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
        Increment inc;

        IncrementThread(Increment obj){
            inc = obj;
        }
        @Override
        public void run() {
            inc.increment();
        }
    }
}

