package com.niliv.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	
	/**
     * 获取a-z的随机数
     */
    public static String randomString(int count){
        //a-z 97-122 
        String str = "";
        for (int i = 0; i < count; i++) {
            str += (char)(Math.random()*26+'a');
             
        }
        return str;
    }
	
	/**
     * 随机生成时间
     */
     public static String randomDate(String beginDate,String endDate){
    	 
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);
  
            if(start.getTime() >= end.getTime()){
                return null;
            }
            long date = random(start.getTime(),end.getTime());
             
            return format.format(new Date(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
  
    private static long random(long begin,long end){
        return begin + (long)(Math.random() * (end - begin));
    }

}
