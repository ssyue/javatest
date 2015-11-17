package javatest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSplit {
public static void main(String[] args) {
    
}
@Test
public void testSplit(){
     String s=" , ";//s=","
   System.out.println(s.split(",").length);
    assertTrue(s.split(",").length>0);
}
}
