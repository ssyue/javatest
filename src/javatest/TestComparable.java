package javatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparable {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
            Person p1=new Person("a",12);
            Person p2=new Person("e",13);
            Person p3=new Person("d",15);
            Person p4=new Person("b",16);
            List<Person> list=new ArrayList<Person>();
            list.add(p1);
            list.add(p2);
            list.add(p3);
            list.add(p4);
            printlist(list);
            Collections.sort(list);
            printlist(list);
     }

    private static void printlist(List<Person> list) {
        for(Person p:list){
            System.out.println(p.name+":"+p.age);
        }
    }

    static class Person implements Comparable {
        int age;

        String name;
        
        Person(String name,int age){
            this.age=age;
            this.name=name;
        }
        @Override
        public int compareTo(Object o) {
            if(this.age<((Person)o).age){
                return 1;
            }else if(this.age>((Person)o).age){
                return -1;
            }
            return 0;
        }
    }
}
