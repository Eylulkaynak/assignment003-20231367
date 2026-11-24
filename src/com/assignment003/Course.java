package com.assignment003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Course {
    private final String courseCode;
    private final String courseName;
    private final int credits;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = requireText(courseCode, "Course code");
        this.courseName = requireText(courseName, "Course name");
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be positive.");
        }
        this.credits = credits;
    }

    void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Student> getStudents() {
        return enrollments.stream().map(Enrollment::getStudent).toList();
    }

    public List<Enrollment> getEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank.");
        }
        return value.trim();
    }
}
