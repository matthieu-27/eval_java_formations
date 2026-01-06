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

    private static Connection connect() throws SQLException {
        return MariaDbConnection.getInstance();
    }

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
            return new Course(id, obj.name(), obj.description(), obj.duration(), obj.type(), obj.price());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UnknownCourseException("Problème durant la création de la formation. vérifiez les attributs");
    }

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
                ps.setObject(4, obj.type());
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
    }
}
