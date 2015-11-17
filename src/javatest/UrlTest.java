package javatest;

import java.net.URL;

public class UrlTest {
    public static void main(String[] args) {
       URL url=UrlTest.class.getClassLoader().getResource("");
       System.out.println(url.getPath());
    }
}
