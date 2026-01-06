package DAO;

import Enums.CourseType;
import Exceptions.UnknownCourseException;
import JDBC.MariaDbConnection;
import Models.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO extends DAO<Course> {

    /**
     * Call db utility class to get a connection instance
     * @return Connection instance object
     * @throws SQLException: If it can't connect
     */
    private static Connection connect() throws SQLException {
        return MariaDbConnection.getInstance();
    }

    /**
     * Find a Course in the db
     * @param id: the Course row id
     * @return The Course object, if found
     * @throws SQLException: If it can't connect / execute the query
     * @throws UnknownCourseException: if nothing is found
     */
    @Override
    public Course find(int id) throws SQLException {
        String query = "SELECT * FROM courses WHERE id = ?";
        try  {
            PreparedStatement ps;
            try (Connection c = connect()) {
                ps = c.prepareStatement(query);
                // Insertion de l'ID
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    return new Course(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("duration"), Enum.valueOf(CourseType.class, rs.getString("type")), rs.getBigDecimal("price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UnknownCourseException("La formation avec l'id:" + id + " n'éxiste pas.");
    }

    /**
     *
     * @param obj The Course object to be saved in db
     * @return The created Course object with an id
     * @throws SQLException: If it can't connect / execute the query
     * @throws UnknownCourseException: if nothing is returned
     */
    @Override
    public Course create(Course obj) throws SQLException {
        String query = "INSERT INTO courses (name, description, duration, type, price) VALUES (?, ?, ?, ?, ?)";
        try  {
            PreparedStatement ps;
            try (Connection c = connect()){
                ps = c.prepareStatement(query);
                ps.setString(1, obj.name());
                ps.setString(2, obj.description());
                ps.setInt(3, obj.duration());
                ps.setString(4, obj.type().name());
                ps.setBigDecimal(5, obj.price());
                ps.executeUpdate();
            }
            // Rechercher le dernier id + 1
            int id = Course.coursesList.size() + 1;
            // Ajouter la Course à la liste statique
            return new Course(id, obj.name(), obj.description(), obj.duration(), obj.type(), obj.price());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UnknownCourseException("Problème durant la création de la formation. vérifiez les attributs");
    }

    /**
     * Update a Course entry on the database
     * @param obj: A Course object to be updated
     * @return Course updated object
     * @throws SQLException: If it can't connect / execute the query
     * @throws UnknownCourseException: if nothing is returned
     */
    @Override
    public Course update(Course obj) throws SQLException {
        String query = "UPDATE courses SET name = ?, description = ?, duration = ?, type = ?, price = ? WHERE id = ?";
        try  {
            PreparedStatement ps;
            try (Connection c = connect()) {
                ps = c.prepareStatement(query);
                ps.setString(1, obj.name());
                ps.setString(2, obj.description());
                ps.setInt(3, obj.duration());
                ps.setString(4, obj.type().name());
                ps.setBigDecimal(5, obj.price());
                ps.setInt(6, obj.id());
                ps.executeUpdate();
                return obj;
            }
        } catch (SQLException e ){
            e.printStackTrace();
        }
        throw new UnknownCourseException("Impossible de mettre a jour la formation");
    }

    /**
     * Delete a course from the database
     * @param obj: the Course object to delete
     */
    @Override
    public void delete(Course obj) {
        String query = "DELETE FROM courses WHERE ID = ?";
        try {
            PreparedStatement ps;
            try(Connection c = connect()){
                ps = c.prepareStatement(query);
                ps.setInt(1, obj.id());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Course.coursesList.remove(obj);
    }
}
