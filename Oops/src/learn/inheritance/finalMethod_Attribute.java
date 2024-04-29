package learn.inheritance;

/*
    final keyword - for constant dataype
                  - for not overriding method
                  - for making class uninheritable
 */

class A{
    final int a = 5;
    static int b;
    final void print(){
        System.out.println("abc");
    }
}

class B extends A{
    B(){
        super();
    }
//    @Override
//    void print(){
//        System.out.println("dsfds");
//    }
}
public class finalMethod_Attribute {
    public static void main(String[] args) {
        B obj = new B();
        A a = new A();
        a.print();

        obj.print();
        System.out.println(obj.a);
        System.out.println(obj.b);
        try{
            System.exit(0);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("error");
        }
    }
}
