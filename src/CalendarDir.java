import java.io.File;
import java.util.Calendar;

public class CalendarDir {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        String monthString;
        String dayString;

        if (month < 10) {
            monthString = "0" + month;
        } else {
            monthString = Integer.toString(month);
        }

        if (day < 10) {
            dayString = "0" + day;
        } else {
            dayString = Integer.toString(day);
        }


        String fileName = File.separator + "tmp" + File.separator + year + File.separator + monthString + File.separator + dayString;
        System.out.println(fileName);
        File file = new File(fileName);

        if (!file.exists()) {
            file.mkdirs();
        }
    }

    }

