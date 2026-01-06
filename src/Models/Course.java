package Models;

import Enums.CourseType;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Course {
    private int id;
    private String name;
    private String description;
    private int duration;
    private CourseType type;
    private BigDecimal price;

    public static ArrayList<Course> coursesList = new ArrayList<>();

    public Course(int id, String name, String description, int duration, CourseType type, BigDecimal price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.type = type;
        this.price = price;
        coursesList.add(this);
    }


    public Course(String name, String description, int duration, CourseType type, BigDecimal price){
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.type = type;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", type=" + type +
                ", price=" + price +
                '}';
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

    public BigDecimal price() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
