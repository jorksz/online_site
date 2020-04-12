package com.online.site.start.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 时间相关工具类
 */

public class TimeTransform {

	private TimeTransform(){}
	
	/*
	 * 时间转换
	 * @param date 传入的时间
	 * @return 时间字符串
	 */
	public static String nowDateTrans(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);
		return time;
	}
	
	/*
	 * 将现有时间加上10分钟
	 * @param bTime 字符串时间
	 * return 10分钟后的时间
	 */
	public static String nextTenMiDateTrans(String bTime){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nextDate = null;
		try{
			nextDate =sdf.parse(bTime);
		}catch(ParseException ex){
			System.out.println("转化时间出现错误!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nextDate);
		calendar.add(Calendar.MINUTE, 10);
		String nextTenMinues = sdf.format(calendar.getTime());
		//System.out.println(nextTenMinues);
		return nextTenMinues;
	}
	
	/*
	 * 时间比较
	 * @param nowTime 现在时间
	 * @pram eTime  结束时间
	 * @return 返回比较结果
	 */
	public static int  CompareTime(String nowTime, String eTime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int flag = 0;
		try {  
            Date dt1 = df.parse(nowTime);//将字符串转换为date类型  
            Date dt2 = df.parse(eTime);  
            if(dt1.getTime()>dt2.getTime())//比较时间大小,如果dt1大于dt2  
            {  
                flag=1;
            }  
            else  
            {  
               flag=2;
            }  
        } catch (ParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }
		return flag;
	}
}
