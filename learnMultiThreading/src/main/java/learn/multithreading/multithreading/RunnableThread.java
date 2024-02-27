package learn.multithreading.multithreading;

public class RunnableThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableThread().new RunnableDemo());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }

    private class RunnableDemo implements Runnable{
        @Override
        public void run() {

        }
    }
}
