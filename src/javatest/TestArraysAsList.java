package javatest;

import java.util.Arrays;
import java.util.List;

public class TestArraysAsList {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(new People(10,170)).size());
        List l =Arrays.asList(new People(10,170));
        if(l.get(0)  instanceof People){
            People p=(People) l.get(0);
            System.out.println(p.age);
        }
    }
}
class People{
    int age;
    int height;
public People(int a,int b){
    this.age=a;
    this.height=b;
}
}