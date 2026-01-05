import Enums.CourseType;
import Models.Course;
import Models.User;


public class Main {
    public static void main(String[] args) {
        User matt = new User("Matthieu");
        System.out.println(matt.getId() + " : " + matt.getName());
        User tristan = new User("Tristan");
        System.out.println(tristan.getId() + " : " + tristan.getName());

        Course eps = new Course("EPS");
        Course svt = new Course("SVT", CourseType.DISTANCIEL);

        System.out.println(eps.name() + ", " + svt.name() + ":" + svt.type());
    }
}