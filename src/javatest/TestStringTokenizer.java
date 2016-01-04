package javatest;

import java.util.StringTokenizer;

public class TestStringTokenizer {
    public static void main(String[] args) {
        String s="1,2:3,4";
        StringTokenizer token=new  StringTokenizer(s);
        while(token.hasMoreTokens()){
            System.out.println(token.nextToken());
        }
    }
}
