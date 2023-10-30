package classMetier.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Singleton {
    private static final String PATHCONF = ".\\src\\ressources\\sql\\conf.properties";
    private static final Properties props = new Properties();
    private static Connection connection;

    private Singleton(){
        try{
            Class.forName(props.getProperty("jdbc.driver.class"));
            FileInputStream file = new FileInputStream(PATHCONF);
            props.load(file);
            props.setProperty("user",props.getProperty("jdbc.login"));
            props.setProperty("password",props.getProperty("jdbc.password"));

            connection = DriverManager.getConnection(props.getProperty("jdbc.url"));

        }catch (ClassNotFoundException | IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection getConnection(){
        return connection;
    }

    private static Connection getInstanceDB(){
        if (getConnection()==null){
            new Singleton();
            System.out.println("Connecter");
        }
        else {
            System.out.println("Connexion existance");
        }
        return getConnection();
    }

    public static void closeInstanceDB(){
        try{
            Singleton.getConnection().close();
            System.out.println("Connexion fermé");
        } catch (SQLException e) {
            System.out.println("Erreur : "+e.getMessage()+" [SQL code erreur : "+e.getSQLState()+" ]");
        }
    }
}
