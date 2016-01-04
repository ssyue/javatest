package javatest;


import org.junit.Test;

public class TestDouble {
    public static void main(String[] args) {
        double a=1.1;
        long l=(long)a;
        long l2=new Double(1.11111).longValue();
        double d=l2;
        int a1=(int) a;
        System.out.println(l+" "+l2+" "+d+" "+a1);
        System.out.println(a/2);
    }
    
    @Test
    void test(){
        double a=1.0;
        long l=(long)a;
        System.out.println(l);
      //  assertTrue(l==1);
    }
}
