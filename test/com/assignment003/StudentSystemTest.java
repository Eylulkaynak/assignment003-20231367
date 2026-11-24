package com.assignment003;

public final class StudentSystemTest {
    private StudentSystemTest() {
    }

    public static void main(String[] args) {
        Student student = new Student(1, "Test Student", "student@example.com");
        Course course = new Course("CSE101", "Programming", 6);
        Enrollment enrollment = student.enroll(course);

        assert student.getEnrolledCourses().size() == 1;
        assert course.getStudents().contains(student);
        assert !enrollment.hasPassed();

        enrollment.assignGrade(75);
        assert enrollment.hasPassed();

        boolean duplicateRejected = false;
        try {
            student.enroll(course);
        } catch (IllegalStateException expected) {
            duplicateRejected = true;
        }
        assert duplicateRejected;

        boolean invalidGradeRejected = false;
        try {
            enrollment.assignGrade(101);
        } catch (IllegalArgumentException expected) {
            invalidGradeRejected = true;
        }
        assert invalidGradeRejected;

        System.out.println("All tests passed.");
    }
}
