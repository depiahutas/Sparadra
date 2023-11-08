package classMetier.Util;

import classMetier.gestion.Achat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AchatTest {

    @Test
    void testSetPrix() throws Exception {


        Achat achat1 = new Achat(null, new ArrayList<>(), 25.37, "30/08/2023",
                null);
        assertEquals(25.37, achat1.getPrix());

        try {
            achat1.setPrix(-10.0);
            fail("La méthode setPrix() doit lever une exception pour un prix négatif");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }
}