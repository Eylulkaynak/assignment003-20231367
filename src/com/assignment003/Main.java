package com.assignment003;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Student student = new Student(1001, "Eylul Yilmaz", "eylul@example.com");
        Course programming = new Course("CSE101", "Introduction to Programming", 6);
        Course databases = new Course("CSE202", "Database Systems", 5);

        Enrollment programmingEnrollment = student.enroll(programming);
        programmingEnrollment.assignGrade(85);
        student.enroll(databases);

        System.out.println(student.displayInfo());
        student.getEnrollments().forEach(enrollment -> System.out.printf(
                "%s - %s | Grade: %s | Passed: %s%n",
                enrollment.getCourse().getCourseCode(),
                enrollment.getCourse().getCourseName(),
                enrollment.getGrade() == null ? "Not assigned" : enrollment.getGrade(),
                enrollment.hasPassed()));
    }
}
