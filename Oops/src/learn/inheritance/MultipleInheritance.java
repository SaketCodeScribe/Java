package learn.inheritance;

/*
    Using interface java achieves multiple inheritance.

    When diamond problem occurs in interface/class for concrete method, java resolves it by
    Overriding the method and calling the method which is desired by
    interfaceName.super.method(). below code sample shows the behaviour for class
    and interface.
    For concrete methods it'll not occur as java will provide the implementation.
    Hence, no collision.

    if two functions defined in diff interface have same name but different return type.
    Java throws compilation error.
    'method()' in 'learn.inheritance.MultipleInheritance' clashes with
    'method()' in 'learn.inheritance.Bintf'; attempting to use incompatible return type
 */

interface Ax{
    public void m1();

    default void m2(){
        System.out.println("Axm2");
    }
}

interface Bx{
    public void m1();

    static void m2(){
        System.out.println("Bxm2");
    }
}

interface Aintf extends Ax, Bx{
    public void fun();
    default void print(){
        System.out.println("def");
    }

    @Override
    default void m2() {
        Ax.super.m2();
    }
//    default String check(){
//        return "check";
//    }
//    public String method();
}

interface  Bintf{
    public void fun();
    default void print(){
        System.out.println("abc");
    }
//    default int check(){
//        return 1;
//    }
//    public int method();
}
public class MultipleInheritance implements Aintf, Bintf{
    @Override
    public void fun() {
        System.out.println("fun");
    }

//    @Override
//    public void fun(){
//        System.out.println("fun");
//    }
    @Override
    public void print() {
        Aintf.super.print();
    }

    @Override
    public void m1() {
        System.out.println("m1");
    }

//    @Override
//    public String method() {
//        return null;
//    }

//    @Override
//    public String check() {
//        return Aintf.super.check();
//    }
}
