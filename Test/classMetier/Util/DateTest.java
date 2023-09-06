package classMetier.Util;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testNewDate() throws Exception {
        //date du jour
        String date = Date.newDate();

        assertEquals(Date.newDate(), date);
    }
}