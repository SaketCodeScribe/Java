package learn.multithreading.multithreading;

/*
        Thread v/s Runnable:
            1. If we extend the Thread class, our class cannot extend any other class because Java doesn’t support
               multiple inheritance. But, if we implement the Runnable interface, our class can still extend other
               base classes.
            2. We can achieve basic functionality of a thread by extending Thread class because it provides some
               inbuilt methods like yield(), interrupt() etc. that are not available in Runnable interface.
            3. Using runnable will give you an object that can be shared amongst multiple threads.
 */

/*
    Thread creation by extending Thread class.
 */
class ThreadDemo extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("Thread "+ Thread.currentThread().getId()+ " running.");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

/*
    Thread creation using Runnable interface.
 */
class ThreadRunnableDemo implements  Runnable{
    @Override
    public void run() {
        try{
            System.out.println("Thread "+ Thread.currentThread().getId()+ " running.");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}

public class Multithreading {
    public static void main(String[] args){
        int i;
        System.out.println("Thread creation using Thread class.");
        for(i=0; i<10; i++){
            ThreadDemo thread = new ThreadDemo();
            thread.start();
        }

        System.out.println("\nThread creation implementing Runnable interface.");
        for(i=0; i<10; i++){
            Thread thread = new Thread(new ThreadRunnableDemo());
            thread.start();
        }
    }
}
