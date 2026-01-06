package Services;

import Enums.CourseType;
import JDBC.MariaDbConnection;
import Models.Course;

import java.sql.*;
import java.util.ArrayList;

public class CourseService {

    private static Connection connect() throws SQLException {
        return MariaDbConnection.getInstance();
    }

    public static ArrayList<Course> getAllCourses() throws SQLException {
        String query = "SELECT * FROM courses";
        ArrayList<Course> courses = new ArrayList<>();

        try{
            PreparedStatement ps;
            try (Connection c = connect()) {
                ps = c.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Course new_course = new Course(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("duration"), Enum.valueOf(CourseType.class, rs.getString("type")), rs.getBigDecimal("price"));
                    courses.add(new_course);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }

    public ArrayList<Course> getCourses(CourseType type) throws SQLException{
        String query = "SELECT * FROM courses c WHERE c.type LIKE ?";
        ArrayList<Course> courses = new ArrayList<>();
        try {
            PreparedStatement ps;
            try(Connection c = connect()) {
                ps = c.prepareStatement(query);
                ps.setString(1, type.name());
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Course new_course = new Course(rs.getString("name"), rs.getString("description"), rs.getInt("duration"), Enum.valueOf(CourseType.class, rs.getString("type")), rs.getBigDecimal("price"));
                    courses.add(new_course);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }


}
