package DAO;

import classMetier.Util.Singleton;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {

    protected Connection connection = Singleton.getInstanceDB();

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(Integer pID);

    public abstract List<T> findAll();
}
