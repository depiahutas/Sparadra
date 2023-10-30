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

            String sql = "select * from client inner join personne on cli_per=per_id;";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                System.out.println("resultat : "+result.getInt("cli_id") + "-"+result.getString("per_nom"));
            }

            sql="select * from client inner join personne on cli_per=per_id where cli_id= ?";
            PreparedStatement statement1 = conn.prepareStatement(sql);
            statement1.setInt(1,1);
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next()){
                System.out.println("resultat : "+resultSet.getInt("cli_id") + "-"+resultSet.getString("per_nom"));
            }
            conn.close();
            System.out.println("Deconnecter");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }

    }
        
}
