package DAO.Util;

import DAO.DAO;
import DAO.personne.ClientDAO;
import DAO.sante.CategorieMedicamentDAO;
import DAO.sante.OrdonnanceDAO;
import classMetier.Util.Achat;
import classMetier.sante.Medicament;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AchatDAO extends DAO<Achat> {
    @Override
    public boolean create(Achat obj) {
        return false;
    }

    @Override
    public boolean delete(Achat obj) {
        return false;
    }

    @Override
    public boolean update(Achat obj) throws SQLException {
        return false;
    }

    @Override
    public Achat find(Integer pID) {
        return null;
    }

    @Override
    public ArrayList<Achat> findAll() {
        ArrayList<Achat> listAchat = new ArrayList<>();

        ClientDAO clientDAO = new ClientDAO();
        OrdonnanceDAO ordonnanceDAO = new OrdonnanceDAO();
        PanierDAO panierDAO = new PanierDAO();

        StringBuilder sqlFindAllAchat = new StringBuilder();
        sqlFindAllAchat.append("select * from achat ");


        try (PreparedStatement preparedStatement =
                     this.connection.prepareStatement(sqlFindAllAchat.toString())) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                listAchat.add(new Achat(resultSet.getInt("ach_id"),
                        clientDAO.find(resultSet.getInt("ach_cli")),
                        panierDAO.findwithAchat(resultSet.getInt("ach_id")),
                        resultSet.getFloat("ach_prixTot"),
                        resultSet.getString("ach_date"),
                        ordonnanceDAO.find(resultSet.getInt("ach_ord"))
                ));
            }

            return listAchat;
        } catch (SQLException e) {
            System.out.println("RelationWithDB erreur : " + e.getMessage() + " [SQL error code : " + e.getSQLState() + "]");
        }

        return null;
    }
}
