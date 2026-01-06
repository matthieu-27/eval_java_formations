package App;

import Enums.CourseType;
import Models.Course;
import Services.CourseService;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseApp {
    public static void menu() {
        try(Scanner sc = new Scanner(System.in)){
            boolean quit = false;

            while(!quit){
                System.out.println("\n---MENU UTILISATEUR BUY MY COURSE! ---");
                System.out.println("1. Afficher toutes les formations disponibles");
                System.out.println("2. Faire une recherche par type (Distanciel/Présentiel)");
                System.out.println("3. Faire une recherche par mot clé");
                System.out.println("4. Quitter");
                System.out.print("Choix : ");

                int choice = sc.nextInt();
                sc.nextLine(); // Consommer le retour ligne

                try {
                    switch (choice) {
                        case 1:
                            ArrayList<Course> courses = CourseService.getAllCourses();
                            for(Course c: courses){
                                System.out.println(c.toString());
                            }
                            break;
                        case 2:
                            System.out.println("1: "+ CourseType.DISTANCIEL.name() + ", 2: " + CourseType.PRESENTIEL.name());
                            int answer = sc.nextInt();

                            if(answer == 1){
                                ArrayList<Course> coursesDist = CourseService.getCourses(CourseType.DISTANCIEL);
                                for(Course c: coursesDist){
                                    System.out.println(c.toString());
                                }
                            } else if (answer == 2) {
                                ArrayList<Course> coursesPres =  CourseService.getCourses(CourseType.PRESENTIEL);
                                for(Course c: coursesPres){
                                    System.out.println(c.toString());
                                }
                            } else {
                                System.out.println("Choix invalide");
                                break;
                            }
                        case 3:
                            System.out.println("Veuillez entrer un mot clé :");
                            String keyword = sc.nextLine().trim();
                            if(!keyword.isEmpty()){
                                ArrayList<Course> coursesKey = CourseService.searchCourses(keyword);
                                for(Course c: coursesKey){
                                    System.out.println(c.toString());
                                }
                            }
                            break;

                        case 4:
                            quit = true;
                            break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
