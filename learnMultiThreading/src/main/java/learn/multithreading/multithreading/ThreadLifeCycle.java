package learn.multithreading.multithreading;

/*
    There are 6 states of a thread in java:
    1. New state
    2. Running state
    3. Blocked state
    4. Waiting state
    5. Time-waiting state
    6. Terminate state
 */

class thread implements Runnable {
    public void run()
    {
        // moving thread2 to timed waiting state
        try {
            Thread.sleep(15000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
                "State of thread1 while it called join() method on thread2 -"
                        + ThreadLifeCycle.thread1.getState());
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLifeCycle implements Runnable {
    public static Thread thread1;
    public static ThreadLifeCycle obj;

    public static void main(String[] args)
    {
        obj = new ThreadLifeCycle();
        thread1 = new Thread(obj);

        // thread1 created and is currently in the NEW
        // state.
        System.out.println(
                "State of thread1 after creating it - "
                        + thread1.getState());
        thread1.start();

        // thread1 moved to Runnable state
        System.out.println(
                "State of thread1 after calling .start() method on it - "
                        + thread1.getState());
    }

    public void run()
    {
        thread myThread = new thread();
        Thread thread2 = new Thread(myThread);

        // thread1 created and is currently in the NEW
        // state.
        System.out.println(
                "State of thread2 after creating it - "
                        + thread2.getState());
        thread2.start();

        // thread2 moved to Runnable state
        System.out.println(
                "State of thread2 after calling .start() method on it - "
                        + thread2.getState());

        // moving thread1 to timed waiting state
        try {
            // moving thread1 to timed waiting state
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "State of thread2 after calling .sleep() method on it - "
                        + thread2.getState());

        try {
            // waiting for thread2 to die. thread1 moves to waiting state.
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "State of thread2 when it has finished it's execution - "
                        + thread2.getState());
    }
}
