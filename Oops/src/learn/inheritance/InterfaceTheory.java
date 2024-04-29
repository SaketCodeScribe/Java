package learn.inheritance;

/*
    You need to only provide implementations of abstract public methods.
    You can't declare abstract static, private and default methods.
    You don't need to Override static methods of interface. it'll throw compilation error.
 */
public interface InterfaceTheory {
    static void print_(){
        System.out.println();
    }
    public void llm();
     default void prints(){
         System.out.println("prints");
     }
     static final int val = 5;
     final int v = 10;
     static int t = 5;

     private void privateMethod(){
         System.out.println("private Method");
     }
}

class impl implements InterfaceTheory{

    @Override
    public void llm() {

    }

    @Override
    public void prints() {
        InterfaceTheory.super.prints();
        // static methods needs to be called from intf only
        // InterfaceTheory.print();
    }

    public void print_(){
        System.out.println("sdfds");
    }
}
