package Services;

import Enums.CourseType;
import Models.Course;

import java.sql.*;
import java.util.ArrayList;

public class CourseService {

    private static String url = "jdbc:mysql://localhost:3306/buymy_course";
    private static String user = "tp_java";
    private static String password = "java8";

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static ArrayList<Course> displayAll() throws SQLException {
        String query = "SELECT * FROM courses";
        ArrayList<Course> courses = new ArrayList<>();

        try{
            PreparedStatement ps;
            try (Connection c = connect()) {
                ps = c.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    Course new_course = new Course(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("duration"), Enum.valueOf(CourseType.class, rs.getString("type")), rs.getBigDecimal("price"));
                    courses.add(new_course);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }
}
