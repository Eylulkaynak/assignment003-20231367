package com.assignment003;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Student {
    private final int studentId;
    private final String fullName;
    private final String email;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Student(int studentId, String fullName, String email) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Student ID must be positive.");
        }
        this.studentId = studentId;
        this.fullName = requireText(fullName, "Full name");
        this.email = requireText(email, "Email");
    }

    public Enrollment enroll(Course course) {
        Objects.requireNonNull(course, "Course cannot be null.");
        boolean alreadyEnrolled = enrollments.stream()
                .anyMatch(enrollment -> enrollment.getCourse().equals(course));
        if (alreadyEnrolled) {
            throw new IllegalStateException("Student is already enrolled in this course.");
        }

        Enrollment enrollment = new Enrollment(this, course, LocalDate.now());
        enrollments.add(enrollment);
        course.addEnrollment(enrollment);
        return enrollment;
    }

    public List<Course> getEnrolledCourses() {
        return enrollments.stream().map(Enrollment::getCourse).toList();
    }

    public List<Enrollment> getEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }

    public String displayInfo() {
        return "Student{id=%d, name='%s', email='%s', courseCount=%d}"
                .formatted(studentId, fullName, email, enrollments.size());
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank.");
        }
        return value.trim();
    }
}
