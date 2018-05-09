package Utils;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        calendar.getTimeInMillis();
        System.out.print(calendar.get(Calendar.DAY_OF_YEAR));

    }
}
