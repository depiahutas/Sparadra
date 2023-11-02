package DAO.Util;

import DAO.DAO;
import classMetier.Util.Panier;

import java.sql.SQLException;
import java.util.ArrayList;

public class PanierDAO extends DAO<Panier> {
    @Override
    public boolean create(Panier obj) {
        return false;
    }

    @Override
    public boolean delete(Panier obj) {
        return false;
    }

    @Override
    public boolean update(Panier obj) throws SQLException {
        return false;
    }

    @Override
    public Panier find(Integer pID) {
        return null;
    }

    @Override
    public ArrayList<Panier> findAll() {
        return null;
    }

    public Panier findwithAchat(int pID){
        return null;
    }
}
