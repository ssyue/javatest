package javatest;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class TestDate {
        public static void main(String[] args) {
            Timestamp t=new Timestamp(Calendar.getInstance().getTimeInMillis());
               System.out.println(Calendar.getInstance().getTimeInMillis()+","+t);
               System.out.println(t.toString());
               System.out.println(new Date(Calendar.getInstance().getTimeInMillis()));
               System.out.println(new Date(Calendar.getInstance().getTimeInMillis()).toString());
               System.out.println(Calendar.getInstance().getTime());
        }
}
