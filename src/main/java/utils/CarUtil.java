package com.wb.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CarUtil {
	 public static boolean Rule(String carid,String time) throws Exception{
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date parse = format.parse(time);
	        Calendar instance = Calendar.getInstance();
	        instance.setTime(parse);
	        int week= instance.get(Calendar.DAY_OF_WEEK);//返回的是（对应周一到周日2 3 4 5 6 7 1）
	        System.out.println(week);
//	        通过trycatch来判断汽车牌照的后一位是否是数字或者字母，字母的话是双号，数字的话根据奇数偶数来确定单双号
	        try {
	            int id = Integer.parseInt(carid.substring(carid.length()-1));
	            if(week-1==0){
//	                week-1==0表明今天是周日 双数限号，所以直接判断车牌号尾号能否被2整除返回是否限行
	                return id%2==0;
	            }
//	            不是周日就用（week-1）- id 除2看是否能被2整除，能整除表明该车辆不限号，不能整除限号
	            return (week-id-1)%2!=0;
	        } catch (Exception e) {
//	            字母的话进这里  先判断是否是周日  如果周日的话肯定限号  字母是双号
	            if(week-1==0){
	                return true;
	            }
//	            不是周日只用判断今天是双号还是单号即可
	            return (week-1)%2!=0;
	        }

	    }
}
