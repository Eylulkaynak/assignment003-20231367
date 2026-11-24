# Assignment 003 — Student Class Diagram

This project maps a student class diagram to Java code. It demonstrates
encapsulation, associations between classes, validation, and a many-to-many
relationship implemented through an `Enrollment` class.

## Class diagram

```mermaid
classDiagram
    class Student {
        -int studentId
        -String fullName
        -String email
        -List~Enrollment~ enrollments
        +Student(studentId, fullName, email)
        +enroll(course) Enrollment
        +getEnrolledCourses() List~Course~
        +displayInfo() String
    }

    class Course {
        -String courseCode
        -String courseName
        -int credits
        -List~Enrollment~ enrollments
        +Course(courseCode, courseName, credits)
        +getStudents() List~Student~
    }

    class Enrollment {
        -Student student
        -Course course
        -LocalDate enrollmentDate
        -Double grade
        +Enrollment(student, course, enrollmentDate)
        +assignGrade(grade) void
        +hasPassed() boolean
    }

    Student "1" --> "0..*" Enrollment : has
    Course "1" --> "0..*" Enrollment : has
```

## Design summary

- `Student` stores student information and enrolls in courses.
- `Course` stores course information and exposes its enrolled students.
- `Enrollment` connects one student to one course and stores enrollment data.
- Private fields and public methods follow the visibility shown in the diagram.
- Constructor and method validation prevent invalid objects and duplicate enrollment.

## Run

Requirements: JDK 17 or newer.

```bash
javac -d out src/com/assignment003/*.java
java -cp out com.assignment003.Main
```

## Test

The tests use Java assertions and require no external library.

```bash
javac -d out src/com/assignment003/*.java test/com/assignment003/*.java
java -ea -cp out com.assignment003.StudentSystemTest
```

## Project structure

```text
src/com/assignment003/
  Course.java
  Enrollment.java
  Main.java
  Student.java
test/com/assignment003/
  StudentSystemTest.java
```
