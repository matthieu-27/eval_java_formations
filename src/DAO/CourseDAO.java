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
    public Course create(Course obj) {
        return null;
    }

    @Override
    public Course update(Course obj) {
        return null;
    }

    @Override
    public void delete(Course obj) {

    }
}
