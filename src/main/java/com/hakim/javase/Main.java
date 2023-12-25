package com.hakim.javase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Hakim
 */
public class Main {
    public static void main(String[] args) {

        TimeZone timeZone = TimeZone.getTimeZone("Asia/Manila");
        TimeZone.setDefault(timeZone);
        String time = "2023-11-01T00:00:00.000+00:00";
        // Specify the date format of the input string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        try {
            // Parse the string to obtain a Date object
            Date date = dateFormat.parse(time);

//            // Create a Calendar instance and set its time to the parsed Date
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(date);
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(outputFormat.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., invalid date format
        }
    }
}
