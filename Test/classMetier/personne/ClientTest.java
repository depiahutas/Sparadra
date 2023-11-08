package classMetier.personne;

import classMetier.gestion.Adresse;
import classMetier.sante.Mutuelle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class ClientTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void setDateNaiss() {


    }

    @Test
    void setNumSecu() {
    }

    @Test
    public void testConstructeur() {
        Client client = new Client(0,
                new Personne(0,"Dupont", "Jean", "jean.dupont@example.com", "0612345678",
                    new Adresse(0,123 ,"rue du Faubourg Saint-Honoré", "75008", "Paris")),
                "01/01/1980",
                new Medecin(0,new Personne(1,"Martin", "Martin","martin.martin@mail.com",
                        "0123456789",new Adresse(0,13 ,"rue Saint-Honoré", "75008", "Paris")),
                        "M123456789"),
                new Mutuelle(0,new Adresse(0,75,"rue Saint-Honoré", "75008", "Paris"),
                        "Mutuelle Nationale", "0123456789","mutuelle.nationale@mut.com",2),
                "2012345678");

        Assertions.assertEquals("Dupont", client.getPersonne().getNom());
        Assertions.assertEquals("Jean", client.getPersonne().getPrenom());
        Assertions.assertEquals("jean.dupont@example.com", client.getPersonne().getMail());
        Assertions.assertEquals("0612345678", client.getPersonne().getTel());
        Assertions.assertEquals("01/01/1980",client.getDateNaiss());
        Assertions.assertEquals("2012345678", client.getNumSecu());
    }

    @Test
    void testSetNumSecu() throws Exception {

        Client client = new Client(0,
                new Personne(0,"Dupont", "Jean", "jean.dupont@example.com", "0612345678",
                        new Adresse(0,123 ,"rue du Faubourg Saint-Honoré", "75008", "Paris")),
                "01/01/1980",
                new Medecin(0,new Personne(1,"Martin", "Martin","martin.martin@mail.com",
                        "0123456789",new Adresse(0,13 ,"rue Saint-Honoré", "75008", "Paris")),
                        "M123456789"),
                new Mutuelle(0,new Adresse(0,75,"rue Saint-Honoré", "75008", "Paris"),
                        "Mutuelle Nationale", "0123456789","mutuelle.nationale@mut.com",2),
                "2012345678");

        try {
            client.setNumSecu("2012345678");
        } catch (IllegalArgumentException e) {
            Assertions.fail("La méthode setNumSecu() ne doit pas lever une exception pour un numéro de sécurité sociale valide");
        }

        try {
            client.setNumSecu("12345678");
            Assertions.fail("La méthode setNumSecu() doit lever une exception pour un numéro de sécurité sociale invalide");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

}