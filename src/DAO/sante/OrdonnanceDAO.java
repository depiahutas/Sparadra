package DAO.sante;

import DAO.DAO;
import classMetier.sante.Ordonnance;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrdonnanceDAO extends DAO<Ordonnance> {
    @Override
    public boolean create(Ordonnance obj) {
        return false;
    }

    @Override
    public boolean delete(Ordonnance obj) {
        return false;
    }

    @Override
    public boolean update(Ordonnance obj) throws SQLException {
        return false;
    }

    @Override
    public Ordonnance find(Integer pID) {
        return null;
    }

    @Override
    public ArrayList<Ordonnance> findAll() {
        return null;
    }
}
