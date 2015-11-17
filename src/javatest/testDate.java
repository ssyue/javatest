package javatest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;


public class testDate {
	public static void main(String[] args) throws ParseException {
	//	getDatesBetweenTwoDate("2012-01-03", "2012-03-03");
		//getMonthDays("2012-02-03");
	//	getDaysByYearMonth(2012,04);
		String s ="2015-10-03";
		String[] ss=s.split("-");
		//getDaysByYearMonth(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]));
	//	getMonthsByYearMonth(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]));
//		System.out.println("2015-12".substring(5, 7));
	System.out.println(getAfterDate("2015-1-01","month"));
	}
private static void getMonthsByYearMonth(int parseInt, int parseInt2) {
        
    }
public static int getDaysByYearMonth(int year, int month) {
		
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		System.out.println(maxDate);
		return maxDate;
	}
	private static void getMonthDays(String string) {
		Calendar cal=new GregorianCalendar();
		SimpleDateFormat f=new SimpleDateFormat("",Locale.ENGLISH);
		f.applyPattern("yyyyMM");
		try {
			System.out.println(f.parse(string));
			cal.setTime(f.parse(string));
			int num=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println(num);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}public static String getAfterDate(String beginDate,String type) throws ParseException {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date date = f.parse(beginDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if((type)!=null) {
            if("day".equals(type)) {// 一天前
                cal.add(Calendar.DAY_OF_MONTH, -1);
                date = cal.getTime();
            }
            else if ("week".equals(type)) {// 一周前
                cal.add(Calendar.DAY_OF_MONTH, -7);
                date  = cal.getTime();
            }
            else if ("month".equals(type)) {// 一月前
                cal.add(Calendar.MONTH, 1);
                date  = cal.getTime();
            }
            return date2str(date, "yyyy/MM/dd");
        }
        return null;
    }
	public static String date2str(Date date,String format) {
        if(null != date) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
        return null;
    }
	private static List getDatesBetweenTwoDate(String beginDate, String endDate) {
		List<String> list = new ArrayList<String>();
		list.add(beginDate);
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = f.parse(beginDate);
			Date end = f.parse(endDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(begin);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			boolean bContinue = true;
			while (bContinue) {
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				cal.add(Calendar.MONTH, 1);
				// 测试此日期是否在指定日期之后
				if (end.after(cal.getTime())) {
					list.add(f.format((cal.getTime())));
				} else {
					break;
				}
			}
			list.add(f.format(cal.getTime()));
			list.add(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		for (Iterator it = list.iterator(); it.hasNext();) {
//			System.out.println(it.next());
//		}
		for(int i=0,size=list.size();i<size;i++)
			System.out.println(list.get(i));
		for(String str: list){
		}
		return list;
}
}
