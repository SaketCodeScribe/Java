package learn.multithreading.synchronization;

/*
    When thread acquires a lock then all synchronized method aren't accessible to other locks
    until thread has executed.
    For any deadlock scenarios to occur, some statements should be present before accessing another
    locked object.
    ** Need to check is it true for wait and notify methods as well.
 */

class Shared{
    synchronized void test1(Shared s2){
        System.out.println("test1-begin");
        System.out.println(Thread.currentThread().getName());
        s2.test2();
        System.out.println("test1-end");
    }

    synchronized void test2() {
        System.out.println("test2-begin");
        System.out.println(Thread.currentThread().getName());
        System.out.println("test2-end");
    }
}


class Thread1 extends Thread{
    private Shared s1, s2;

    Thread1(Shared s1, Shared s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run(){
        s1.test1(s2);
    }
}

class Thread2 extends Thread{
    private Shared s1, s2;

    Thread2(Shared s1, Shared s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run(){
        s2.test1(s1);
    }
}

public class Deadlock {
    public static void main(String[] args) {
        Shared s1 = new Shared();
        Shared s2 = new Shared();
        Thread1 t1 = new Thread1(s1, s2);
        Thread2 t2 = new Thread2(s1, s2);
        t1.start();
        t2.start();

    }
}
