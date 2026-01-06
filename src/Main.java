import App.CourseApp;


public class Main {
    public static void main(String[] args) {
//        User matt = new User("Matthieu");
//        System.out.println(matt.getId() + " : " + matt.getName());
//        User tristan = new User("Tristan");
//        System.out.println(tristan.getId() + " : " + tristan.getName());
//
//        Course eps = new Course("EPS");
//        Course svt = new Course("SVT", CourseType.DISTANCIEL);
//
//        System.out.println(eps.name() + ", " + svt.name() + ":" + svt.type());
        // Lecture via Service (DB)
//        try {
//            ArrayList<Course> courses = CourseService.getAllCourses();
//            for(Course c: courses){
//                System.out.println(c.name());
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        // Lecture via l'ArrayList statique de Course
//        ArrayList<Course> staticCourses = Course.coursesList;
//        for(Course c: staticCourses){
//            System.out.println(c.toString());
//        }
//
//
//        // Utilisation DAO
//
//        // test find
//
//        try {
//            CourseDAO daoF = new CourseDAO();
//            Course testF = daoF.find(11);
//            System.out.println(testF.toString());
//        } catch (SQLException e ){
//            e.printStackTrace();
//        }
//
//
//        try{
//            CourseDAO dao = new CourseDAO();
//            Course cobble = new Course("Ruby", "Almost as cool as python", 40, CourseType.DISTANCIEL, BigDecimal.valueOf(75.342));
//            Course cobbleDb = dao.create(cobble);
//            System.out.println(cobbleDb.toString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        CourseApp.menu();


    }
}
