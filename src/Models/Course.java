package Models;

import Enums.CourseType;

public class Course {
    private int id;
    private String name;



    private String description;
    private int duration;
    private CourseType type;

    public Course(String name, String description, int duration, CourseType type){
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.type = type;
    }

    public Course(String name, int duration, CourseType type){
        this.name = name;
        this.duration = duration;
        this.type = type;
    }

    public Course(String name, CourseType type){
        this.name = name;
        this.type = type;
    }
    public Course(String name, int duration){
        this.name = name;
        this.duration = duration;
    }

    public Course(String name){
        this.name = name;
    }

    /* GETTER AND SETTER */

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int duration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType type() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }
}
