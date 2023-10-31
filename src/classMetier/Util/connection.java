package classMetier.Util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class connection {

    public connection(String PATHCONF) throws IOException, ClassNotFoundException {
        Properties props = new Properties();

        try(FileInputStream fis = new FileInputStream(PATHCONF)){
            props.load(fis);
        }

        Class.forName(props.getProperty("jdbc.driver.class"));
        System.out.println("class: "+props.getProperty("jdbc.drive.class"));
        String url = props.getProperty("jdbc.url");
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");

        try{
            Connection conn = DriverManager.getConnection(url,login,password);
            System.out.println("Connecter");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }

    }
        
}
