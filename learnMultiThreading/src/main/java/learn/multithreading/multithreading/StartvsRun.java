package learn.multithreading.multithreading;

/*
    if you call the run() method directly, then
 */
class ThreadTest extends Thread{
    public void run(){
        try{
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getName() +
                    " is running");

        }
        catch (Exception e){
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}
public class StartvsRun{
    public static void main(String[] args) {
        int i;
        StartvsRun threads = new StartvsRun();
        for(i=0; i<10; i++){
            ThreadTest thread = new ThreadTest();
            thread.run();
        }
    }
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName()+" is running.");
//    }
}
