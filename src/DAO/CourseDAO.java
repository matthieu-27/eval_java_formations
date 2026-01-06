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

    private Connection connect() {
        return MariaDbConnection.getInstance();
    }

    @Override
    public Course find(int id) throws SQLException {
        String query = "SELECT * FROM courses WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            // Insertion de l'ID
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Course(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("duration"), Enum.valueOf(CourseType.class, rs.getString("type")), rs.getBigDecimal("price"));
            }
        }
        throw new UnknownCourseException("La formation avec l'id:" + id + " n'éxiste pas.");
    }

    @Override
    public Course create(Course obj) throws SQLException {
        String query = "INSERT INTO comptes VALUES (?, ?, ?, ?, ?)";
        ResultSet rs;
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, obj.name());
            ps.setString(2, obj.description());
            ps.setInt(3, obj.duration());
            ps.setObject(4, obj.type());
            ps.setBigDecimal(5, obj.price());
            rs = ps.executeQuery();
        }
        if(rs.next()){
            return new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), Enum.valueOf(CourseType.class, rs.getString(5)), rs.getBigDecimal(6));
        }
        throw new UnknownCourseException("Problème durant la création de la formation. vérifiez les attributs");
    }

    @Override
    public Course update(Course obj) {
        return null;
    }

    @Override
    public void delete(Course obj) {

    }
}
