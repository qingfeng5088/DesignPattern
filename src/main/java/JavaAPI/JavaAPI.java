package JavaAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaAPI {
    public static void main(String[] args) {
        Calendar calendar = new Calendar.Builder().set(Calendar.YEAR,2021).set(Calendar.MONTH, 11).build();
        System.out.println((calendar));

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(calendar.getTime()));

        Calendar calendar2 = Calendar.getInstance();
        System.out.println(df.format(calendar2.getTime()));
    }
}
