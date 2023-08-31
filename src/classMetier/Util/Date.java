package classMetier.Util;

import java.text.DateFormat;
import java.util.Locale;

public class Date {
    private static DateFormat dateFormat;

    public static String newDate() {

        dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);

        return dateFormat.format(new java.util.Date());
    }

}
