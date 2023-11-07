/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Course;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nuha
 */
public class CourseDao {

    private static final String INSERT_COURSE_SQL = "insert into coursedetails (coursename, date, duration, venue, instructor, grade, category, maximum, about, lesson) values "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_COURSE_BY_ID = "select id, coursename, date, duration, venue, instructor, grade, category, maximum, about, lesson from coursedetails where id=?";
    private static final String SELECT_ALL_COURSE = "select * from coursedetails";
    private static final String REGISTER_COURSE = "insert into profile_course (profile_name, course_id, course_status) values (?, ?, ?)";
    private static final String UPDATE_COURSE_STATUS = "update profile_course SET course_status = ? WHERE course_id = ? AND profile_name = ?";
    private static final String GET_REGISTERED_COURSE = "select c.id, c.coursename, c.date, pc.course_status from coursedetails c "
                + "inner join profile_course pc ON c.id = pc.course_id where pc.profile_name = ?";
    private static final String GET_REGISTERED_PROFILENAME = "select pc.profile_name, pc.course_status from coursedetails c "
                + "inner join profile_course pc ON c.id = pc.course_id where c.id = ?";
    private static final String DELETE_COURSE = "delete from coursedetails where id = ?";

    private final Connection con;

    public CourseDao() throws SQLException, ClassNotFoundException {
        con = DBConnection.getConnection();
    }

    public List<Course> selectAllCourse() throws SQLException {
        List<Course> courseList = new ArrayList<>();
        try ( PreparedStatement ps = con.prepareStatement(SELECT_ALL_COURSE)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setCoursename(rs.getString("coursename"));
                course.setGrade(rs.getString("grade"));
                course.setDate(rs.getDate("date"));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public List<Course> selectAllDetails(int courseId) {
        List<Course> courses = new ArrayList<>();
        try ( PreparedStatement ps = con.prepareStatement(SELECT_COURSE_BY_ID);) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String coursename = rs.getString("coursename");
                Date date = rs.getDate("date");
                String duration = rs.getString("duration");
                String venue = rs.getString("venue");
                String instructor = rs.getString("instructor");
                String grade = rs.getString("grade");
                String category = rs.getString("category");
                int maximum = rs.getInt("maximum");
                String about = rs.getString("about");
                String lesson = rs.getString("lesson");
                courses.add(new Course(id, coursename, date, duration, venue, instructor, grade, category, maximum, about, lesson));
            }
        } catch (SQLException e) {
        }
        return courses;
    }

    public Course getCourseById(int id) {
        Course courses = null;
        try ( PreparedStatement ps = con.prepareStatement(SELECT_COURSE_BY_ID);) {
            ps.setInt(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String coursename = rs.getString("coursename");
                Date date = rs.getDate("date");
                String duration = rs.getString("duration");
                String venue = rs.getString("venue");
                String instructor = rs.getString("instructor");
                String grade = rs.getString("grade");
                String category = rs.getString("category");
                int maximum = rs.getInt("maximum");
                String about = rs.getString("about");
                String lesson = rs.getString("lesson");
                //id = rs.getInt("id");
                courses = new Course(id, coursename, date, duration, venue, instructor, grade, category, maximum, about, lesson);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public void registerCourse(String profileName, int courseId, String courseStatus) throws SQLException {

        try ( PreparedStatement ps = con.prepareStatement(REGISTER_COURSE)) {
            ps.setString(1, profileName);
            ps.setInt(2, courseId);
            ps.setString(3, courseStatus);

            ps.executeUpdate();
        }
    }

    public List<Course> getRegisteredCourses(String profileName) throws SQLException {
        
        List<Course> registeredCourses = new ArrayList<>();

        try ( PreparedStatement statement = con.prepareStatement(GET_REGISTERED_COURSE)) {
            statement.setString(1, profileName);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int courseId = resultSet.getInt("id");
                String courseName = resultSet.getString("coursename");
                Date date = resultSet.getDate("date");
                String courseStatus = resultSet.getString("course_status");

                Course course = new Course(courseId, courseName, date);
                course.setCourseStatus(courseStatus);
                registeredCourses.add(course);
            }
        }
        return registeredCourses;
    }

    public List<String> getRegisteredProfileNames(int courseId) throws SQLException {
       
        List<String> registeredProfileNames = new ArrayList<>();

        try ( PreparedStatement ps = con.prepareStatement(GET_REGISTERED_PROFILENAME)) {
            ps.setInt(1, courseId);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String profileName = resultSet.getString("profile_name");
                String courseStatus = resultSet.getString("course_status");
                registeredProfileNames.add(profileName + " - " + courseStatus);
            }
        }

        return registeredProfileNames;
    }

    public void insertCourse(Course course) throws SQLException {
        try ( PreparedStatement ps = con.prepareStatement(INSERT_COURSE_SQL)) {

            // Set the values for the prepared statement
            ps.setString(1, course.getCoursename());
            ps.setDate(2, course.getDate());
            ps.setString(3, course.getDuration());
            ps.setString(4, course.getVenue());
            ps.setString(5, course.getInstructor());
            ps.setString(6, course.getGrade());
            ps.setString(7, course.getCategory());
            ps.setInt(8, course.getMaximum());
            ps.setString(9, course.getAbout());
            ps.setString(10, course.getLesson());

            // Execute the SQL statement
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void deleteCourse(int courseId) throws SQLException {

        try ( PreparedStatement statement = con.prepareStatement(DELETE_COURSE)) {
            statement.setInt(1, courseId);
            statement.executeUpdate();
        }
    }

    public void updateCourseStatus(int courseId, String profileName, String status) throws SQLException {

        try ( PreparedStatement statement = con.prepareStatement(UPDATE_COURSE_STATUS)) {
            statement.setString(1, status);
            statement.setInt(2, courseId);
            statement.setString(3, profileName);
            statement.executeUpdate();
        }
    }

}
