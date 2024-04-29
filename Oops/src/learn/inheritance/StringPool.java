package learn.inheritance;

/*
    String var = ".." is created at compile time.
    String var = new String("..") is create at run time.
 */
public class StringPool {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println((a == b) + " " + (a == c) + " " + (b == c));
        System.out.println(a.equals(b) + " " + a.equals(c) + " " + b.equals(c));
        try {
            int val = 1 / 0;
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            System.out.println("hi");
        }
    }
}
