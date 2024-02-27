package learn.multithreading.multithreading;

/*
    Priority of thread is set using Thread.setPriority(int num), num can be between 1-10.
    JVM first creates the main thread, and it searches for the main() to execute.
    Child threads are spawned from the main thread.
    child thread has the same priority as of parent thread.
 */

class Threads extends Thread{
    @Override
    public void run() {
        System.out.println("Hello World!");

    }
}

public class ThreadPriority {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+" thread priority is: "+Thread.currentThread().getPriority());
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Threads thread = new Threads();
        thread.start();
        Thread.currentThread().setPriority(6);
        System.out.println(Thread.currentThread().getName()+" thread priority set to: "+Thread.currentThread().getPriority());
        System.out.println(thread.getName()+" thread priority is: "+thread.getPriority());

    }
}
