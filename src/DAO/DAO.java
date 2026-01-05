package DAO;

import JDBC.MariaDbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T>  {

    public Connection connect = MariaDbConnection.getInstance();
    /**
     * Permet de récupérer un objet via son ID
     * @param id
     * @return
     */
    public abstract T find(int id) throws SQLException;

    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    public abstract T create(T obj) throws SQLException;

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     * @param obj
     */
    public abstract T update(T obj) throws SQLException;

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    public abstract void delete(T obj) throws SQLException;

}


