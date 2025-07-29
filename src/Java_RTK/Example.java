package Java_RTK;

public class Example {
    public static void main(String[] args) {
        int a = (int)(Math.random() * (double)10.0F);
        int b = a > 5 ? a : 0;
        System.out.println(b);
    }
}
