package classMetier.Util;

import classMetier.gestion.Adresse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdresseTest {


        @Test
        public void testSetNumero() {
            Adresse adresse = new Adresse(0,123 ,"Rue du Faubourg Saint-Honoré",
                    "75008", "Paris");
            assertEquals(123, adresse.getNumero());

            try {
                adresse.setNumero(123456789);
                fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                assertEquals("Numéro adresse incorrecte", e.getMessage());
            }
        }


    @Test
    public void testSetRue() {
        Adresse adresse = new Adresse(0,123 ,"Rue du Faubourg Saint-Honoré",
                "75008", "Paris");

        adresse.setRue("Rue de la Paix");
        assertEquals("Rue de la Paix", adresse.getRue());

        adresse.setRue("123 Rue de la Paix");
        assertEquals("123 Rue de la Paix", adresse.getRue());

    }

    @Test
    public void testSetCodePostal() throws Exception {
        Adresse adresse = new Adresse(0,123 ,"Rue du Faubourg Saint-Honoré",
                "75008", "Paris");

        try {
            adresse.setCodePostal("75008a");
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("code postal incorrecte", e.getMessage());
        }
    }

    @Test
    public void testSetVille() throws Exception {
        Adresse adresse = new Adresse(0,123 ,"Rue du Faubourg Saint-Honoré",
                "75008", "Paris");
        try {
            adresse.setVille("123 Paris");
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("ville incorrecte", e.getMessage());
        }
    }
}