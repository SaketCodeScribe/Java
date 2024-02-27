package learn.multithreading.synchronization;

/*
    Synchronization means coordination between multiple processes/threads.

    Java Synchronization is used to make sure by some synchronization method that only one thread can access the
    resource at a given point in time. Only one thread can own a monitor at a given time. When a thread acquires
    a lock, it is said to have entered the monitor. All other threads attempting to enter the locked monitor will
    be suspended until the first thread exits the monitor.
    If there are 100 of synchronized methods, then at any given time only one thread can execute a synchronized
    method. Non-synchronized methods can be executed concurrently.

    Types of synchronization:
    1. Process synchronization - Coordination of execution of multiple process.
    2. Thread synchronization

    Types of Thread synchronization
    1. Mutual Exclusive : Helps keep threads from interfering with each other.
                            a. Synchronized block
                            b. Synchronized method
                            c. Static synchronization
    2. Cooperation: Inter-Thread communication in java
 */

class Sender {
    public void send(String msg) {
        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}

class ThreadedSend extends Thread {
    private String msg;
    Sender sender;

    // Receives a message object and a string
    // message to be sent
    ThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        // Only one thread can send a message
        // at a time.
        synchronized (sender) {
            // synchronizing the send object
            sender.send(msg);
        }
    }
}

public class SynchronizationInJava {
    public static void main(String args[]) {
        Sender send = new Sender();
        ThreadedSend S1 = new ThreadedSend(" Hi ", send);
        ThreadedSend S2 = new ThreadedSend(" Bye ", send);

        // Start two threads of ThreadedSend type
        S1.start();
        S2.start();

        // wait for threads to end
        try {
            S1.join();
            S2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}
