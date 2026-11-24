package com.assignment003;

import java.time.LocalDate;
import java.util.Objects;

public final class Enrollment {
    private final Student student;
    private final Course course;
    private final LocalDate enrollmentDate;
    private Double grade;

    public Enrollment(Student student, Course course, LocalDate enrollmentDate) {
        this.student = Objects.requireNonNull(student, "Student cannot be null.");
        this.course = Objects.requireNonNull(course, "Course cannot be null.");
        this.enrollmentDate = Objects.requireNonNull(enrollmentDate, "Enrollment date cannot be null.");
    }

    public void assignGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        this.grade = grade;
    }

    public boolean hasPassed() {
        return grade != null && grade >= 50;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public Double getGrade() {
        return grade;
    }
}
