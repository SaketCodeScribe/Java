package learn.inheritance;

/*
    Why do abstract classes have constructor?
 */
abstract class Aclass{
    public String var;
    Aclass(){}
    Aclass(String var){
        this.var = var;
    }
}

public class abstractClass extends Aclass{
    abstractClass(){
        super("abc");
    }

    public static void main(String[] args) {
        new abstractClass();
    }
}
