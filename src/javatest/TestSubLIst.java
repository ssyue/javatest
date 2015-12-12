package javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSubLIst {
        public static void main(String[] args) {
            List<String> list=Arrays.asList("1","2","3","4","5","6");
            List<String> res=new ArrayList<String>();
            res.addAll(list.subList(1,list.size()));
            System.out.println(res.size());
        }
}
