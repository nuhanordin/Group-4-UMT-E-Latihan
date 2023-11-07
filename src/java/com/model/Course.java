/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.sql.Date;

/**
 *
 * @author nuha
 */
public class Course {
    int id;
    String coursename;
    Date date;
    String duration;
    String venue;
    String instructor;
    String grade;
    String category;
    int maximum;
    String about;
    String lesson;
    String courseStatus;

    public Course() {
    }

    public Course(int id, String coursename, Date date) {
        this.id = id;
        this.coursename = coursename;
        this.date = date;
    }

    public Course(String coursename, Date date, String duration, String venue, String instructor, String grade, String category, int maximum, String about, String lesson) {
        this.coursename = coursename;
        this.date = date;
        this.duration = duration;
        this.venue = venue;
        this.instructor = instructor;
        this.grade = grade;
        this.category = category;
        this.maximum = maximum;
        this.about = about;
        this.lesson = lesson;
    }

    public Course(int id, String coursename, Date date, String duration, String venue, String instructor, String grade, String category, int maximum, String about, String lesson) {
        this.id = id;
        this.coursename = coursename;
        this.date = date;
        this.duration = duration;
        this.venue = venue;
        this.instructor = instructor;
        this.grade = grade;
        this.category = category;
        this.maximum = maximum;
        this.about = about;
        this.lesson = lesson;
    }

    
    public int getId() {
        return id;
    }

    public String getCoursename() {
        return coursename;
    }

    public Date getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }

    public String getVenue() {
        return venue;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getGrade() {
        return grade;
    }

    public String getCategory() {
        return category;
    }

    public int getMaximum() {
        return maximum;
    }

    public String getAbout() {
        return about;
    }

    public String getLesson() {
        return lesson;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }
    
    
}
