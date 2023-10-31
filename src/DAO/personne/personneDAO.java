package DAO.personne;

import DAO.DAO;
import classMetier.personne.Personne;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class personneDAO extends DAO<Personne> {

    @Override
    public boolean create(Personne obj) {
        StringBuilder sqlInsertPersonne = new StringBuilder();
        sqlInsertPersonne.append("insert into personne ");
        sqlInsertPersonne.append("(per_id,per_nom,per_prenom,per_mail,per_tel,per_adresse)");
        sqlInsertPersonne.append("values (null,?,?,?,?,?)");

        boolean requetOK=false;

        try(PreparedStatement preparedStatement =
                    this.connection.prepareStatement(sqlInsertPersonne.toString())){
            preparedStatement.setString(2,obj.getNom());
            preparedStatement.setString(3,obj.getPrenom());
            preparedStatement.setString(4,obj.getMail());
            preparedStatement.setString(5,obj.getTel());
            preparedStatement.setInt(6,obj.getAdresse().getID());

            preparedStatement.executeUpdate();
            requetOK=true;
        }
        catch (SQLException e){
            System.out.println("RelationWithDB erreur : "+e.getMessage()+" [SQL error code : "+ e.getSQLState()+"]");
        }

        return requetOK;
    }

    @Override
    public boolean delete(Personne obj) {
        return false;
    }

    @Override
    public boolean update(Personne obj) {
        StringBuilder sqlInsertPersonne = new StringBuilder();
        sqlInsertPersonne.append("update personne ");
        sqlInsertPersonne.append("(per_nom,per_prenom,per_mail,per_tel,per_adresse)");
        sqlInsertPersonne.append("where per_id=?");
        sqlInsertPersonne.append("values (?,?,?,?,?,?)");

        boolean requetOK=false;

        try(PreparedStatement preparedStatement =
                    this.connection.prepareStatement(sqlInsertPersonne.toString())){
            preparedStatement.setString(1,obj.getNom());
            preparedStatement.setString(2,obj.getPrenom());
            preparedStatement.setString(3,obj.getMail());
            preparedStatement.setString(4,obj.getTel());
            preparedStatement.setInt(5,obj.getAdresse().getID());
            preparedStatement.setInt(6,obj.getId());

            preparedStatement.executeUpdate();
            requetOK=true;
        }
        catch (SQLException e){
            System.out.println("RelationWithDB erreur : "+e.getMessage()+" [SQL error code : "+ e.getSQLState()+"]");
        }

        return requetOK;
    }

    @Override
    public Personne find(Integer pID) {
        StringBuilder sqlInsertPersonne = new StringBuilder();
        sqlInsertPersonne.append("select * from personne ");
        sqlInsertPersonne.append("where per_id=?");
        sqlInsertPersonne.append("values (?)");



        try(PreparedStatement preparedStatement =
                    this.connection.prepareStatement(sqlInsertPersonne.toString())){
            preparedStatement.setInt(1,pID);
;
            //ResultSet resultSet = statement.executeQuery(test);

            //Personne p=new Personne() {
            //}

        }
        catch (SQLException e){
            System.out.println("RelationWithDB erreur : "+e.getMessage()+" [SQL error code : "+ e.getSQLState()+"]");
        }

        //return ;

        return null;
    }

    @Override
    public List<Personne> findAll() {
        return null;
    }
}
