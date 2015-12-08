package javatest;

public class JString {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        String s="123";
        System.out.println(s.substring(0,s.length()-1));
        char c[] = new char[10];
        s.getChars(0, 2, c, 0);
        System.out.println(c[0]);
    }
}
