/*
 author:changsiyuan
 creation time: 2014.11.15
 This program can help you deside when to reserve the train ticket.
 */
package ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.xml.crypto.Data;

public class TicketSale {

    public static void main(String[] args) throws ParseException {
        System.out.println("Please input the date you will go home in this format: ****-**-**");

        Scanner dataGo = new Scanner(System.in);
        String dataGoHome = dataGo.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   //change the date into yyyy-MM-dd format
        Date date = sdf.parse(dataGoHome);
        System.out.println("The day you will go home is: " + sdf.format(date));

        Date date1 = new Date(114, 11, 20);  //代表2014.12.20，原因见Date类
        Date date2 = new Date(114, 11, 21);   //2014.12.21
        Date date3 = new Date(114, 11, 31);   //2014.12.31
        Date date4 = new Date(115, 0, 7);   //2015.1.7
        Date date5 = new Date(115, 0, 14);   //2015.1.14
        Date date6 = new Date(115, 0, 21);   //2015.1.21
        Date date7 = new Date(115, 0, 28);   //2015.1.28
        Date date8 = new Date(115, 1, 4);   //2015.2.4

        Calendar calendar = Calendar.getInstance();  //change date to calendar
        calendar.setTime(date);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime(date4);
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime(date5);
        Calendar calendar6 = Calendar.getInstance();
        calendar6.setTime(date6);
        Calendar calendar7 = Calendar.getInstance();
        calendar7.setTime(date7);
        Calendar calendar8 = Calendar.getInstance();
        calendar8.setTime(date8);

        if (calendar.before(calendar1)) {    //calculate the date you should buy tickets
            String beforeDate = sdf.format(getDateBefore(date, 20));
            System.out.println("You can reserve the ticket after this date: " + beforeDate);
        } else if (calendar.equals(calendar1)) {
            String beforeDate = sdf.format(getDateBefore(date, 20));
            System.out.println("You can reserve the ticket after this date: " + beforeDate);
        } else if (calendar.after(calendar1)&&calendar.before(calendar3)||calendar.equals(calendar3)) {
            System.out.println("You can reserve the ticket after this date: 2014-12-1");
        } else if (calendar.after(calendar3)&&calendar.before(calendar4)||calendar.equals(calendar4)) {
            System.out.println("You can reserve the ticket after this date: 2014-12-2");
        } else if (calendar.after(calendar4)&&calendar.before(calendar5)||calendar.equals(calendar5)) {
            System.out.println("You can reserve the ticket after this date: 2014-12-3");
        } else if (calendar.after(calendar5)&&calendar.before(calendar6)||calendar.equals(calendar6)) {
            System.out.println("You can reserve the ticket after this date: 2014-12-4");
        } else if (calendar.after(calendar6)&&calendar.before(calendar7)||calendar.equals(calendar7)) {
            System.out.println("You can reserve the ticket after this date: 2014-12-5");
        } else if (calendar.after(calendar7)&&calendar.before(calendar8)||calendar.equals(calendar8)) {
            System.out.println("You can reserve the ticket after this date: 2014-12-6");
        } else if (calendar.after(calendar8)) {
            String beforeDate = sdf.format(getDateBefore(date, 60));
            System.out.println("You can reserve the ticket after this date: " + beforeDate);
        }
    }

    public static Date getDateBefore(Date d, int day) {    //calculate the date before a certain day
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }
}
