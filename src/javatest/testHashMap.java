package javatest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testHashMap {

    public static void main(String[] args) {
        Map<Long, List<Long>> res=new HashMap<Long,List<Long>>();
        for(Map.Entry<Long, List<Long>> e:res.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }

}
