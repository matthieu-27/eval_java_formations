package DAO;

import java.sql.SQLException;

public abstract class DAO<T>  {

    /**
     * Permet de récupérer un objet via son ID
     * @param id: int
     * @return T
     */
    public abstract T find(int id) throws SQLException;
    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj: T
     */
    public abstract T create(T obj) throws SQLException;

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     * @param obj: T
     * @return obj: T
     */
    public abstract T update(T obj) throws SQLException;

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj: T
     */
    public abstract void delete(T obj) throws SQLException;

}


