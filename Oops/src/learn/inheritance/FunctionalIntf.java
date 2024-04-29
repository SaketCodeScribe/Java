package learn.inheritance;
/*
    An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, static methods but can contain only one abstract method. It can also declare methods of object class(any interface can do so, and you don't need to provide abstract methods for these Object class methods as all java class inherits from the Object class. Hence, the class implementing intf will already have their abstract methods).

    Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces. It is a new feature in Java, which helps to achieve functional programming approach.
 */

@FunctionalInterface
interface sayable{
    void say();
    int hashCode();
    boolean equals(Object obj);
    String toString();
}
public class FunctionalIntf implements sayable{
    @Override
    public void say() {
        System.out.println("saying");
    }
    public static void main(String[] args) {
        FunctionalIntf obj = new FunctionalIntf();
        obj.say();
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        System.out.println(obj.equals(obj));
    }
}

