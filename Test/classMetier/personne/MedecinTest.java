package classMetier.personne;

import classMetier.gestion.Adresse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedecinTest {

    @Test
    void setNumAgr() {
        Medecin medecin=new Medecin("Martin", "Martin","martin.martin@mail.com","0123456789",
                new Adresse(13 ,"rue Saint-Honoré", "75008", "Paris"),
                "M123456789");
        assertEquals("M123456789",medecin.getNumAgr());
        try {
            medecin.setNumAgr("123");
            fail("La méthode setNumAgr() doit lever une exception pour un numéro d'agréement incorrecte");
        }
        catch (IllegalArgumentException e){
            // OK
        }
    }
}