package javatest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNull {
         public static void main(String[] args) {
             System.out.println(null==null);
             Integer i1=127;//128
             Integer i2=127;//128
             System.out.println(i1==i2);//127 true 128 false
        }

    @Test
   public void testNull(){
        assertEquals(new Integer(0),new Integer(0));
        Integer i1=127;//128
        Integer i2=127;//128
        assertTrue(i1==i2);
        assertTrue(null==null);
    }
}
