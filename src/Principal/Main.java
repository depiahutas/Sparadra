package Principal;

import Frame.Principale;
import classMetier.Util.Adresse;
import classMetier.personne.Client;
import classMetier.personne.Medecin;
import classMetier.sante.Mutuelle;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Principale start = new Principale();

        //creation jeux de données pour test
        Client client1 = new Client("Dupont","Marie","dupont.marie@mail.com","0612345678",
                new Adresse(123,"rue de la République",75001,"Paris"),
                new Date("20/07/1995"),
                new Medecin("A","B","A.B@mail@.com","0123456789",
                        new Adresse(1,"a",75001,"Paris"),1),
                new Mutuelle(),
                "123 456 789 012 345"
                );

        Client client2 = new Client("Martin","Jean","martin.jean@mail.com","0789101112",
                new Adresse(456,"avenue de la libération",69007,"Lyon"),
                new Date("10/05/1975"),
                new Medecin("C","D","C.D@mail@.com","0234567891",
                        new Adresse(2,"b",69007,"Lyon"),2),
                new Mutuelle(),
                "123 456 789 012 346"
                );



    }

}