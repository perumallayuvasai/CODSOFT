import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    String studentID;
    String name;
    List<String> registeredCourses;

    Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

public class Codsoft_taskno_5 {
    List<Course> courses;
    List<Student> students;

    public Codsoft_taskno_5() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void registerStudent(Student student, String courseCode) {
        for (Course course : courses) {
            if (course.code.equals(courseCode)) {
                if (course.capacity > 0) {
                    course.capacity--;
                    student.registeredCourses.add(courseCode);
                    System.out.println(student.name + " has successfully registered for " + course.title);
                } else {
                    System.out.println("Sorry, " + course.title + " is full.");
                }
                return;
            }
        }
        System.out.println("Course with code " + courseCode + " not found.");
    }

    public void removeCourse(Student student, String courseCode) {
        if (student.registeredCourses.contains(courseCode)) {
            student.registeredCourses.remove(courseCode);
            for (Course course : courses) {
                if (course.code.equals(courseCode)) {
                    course.capacity++;
                    System.out.println(student.name + " has successfully dropped " + course.title);
                    return;
                }
            }
        }
        System.out.println("Course with code " + courseCode + " not found in registered courses of " + student.name);
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Code: " + course.code);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Capacity: " + course.capacity + " slots available out of 30");
            System.out.println("Schedule: " + course.schedule);
            System.out.println("--------------------------------------");
        }
    }

    public static void main(String[] args) {
        Codsoft_taskno_5 managementSystem = new Codsoft_taskno_5();
        Scanner scanner = new Scanner(System.in);

        // Adding sample courses
        Course computers = new Course("CS001", "Introduction to Computer Science", "Basic concepts of programming", 30, "Mon/Wed/Fri 9-11 AM");
        Course math = new Course("MATH001", "Calculus", "Fundamental principles of calculus", 30, "Tue/Thu 1-3 PM");
        managementSystem.addCourse(computers);
        managementSystem.addCourse(math);

        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("Welcome to Student Management System");
            System.out.println("1. Register Student to a Course");
            System.out.println("2. Remove Student from a Course");
            System.out.println("3. Display Available Courses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.next();
                    System.out.print("Enter student name: ");
                    scanner.nextLine(); // Consume newline character
                    String studentName = scanner.nextLine();
                    System.out.print("Enter course code to register: ");
                    String courseCode = scanner.next();
                    managementSystem.registerStudent(new Student(studentID, studentName), courseCode);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String removeStudentID = scanner.next();
                    System.out.print("Enter course code to remove: ");
                    String removeCourseCode = scanner.next();
                    managementSystem.removeCourse(new Student(removeStudentID, ""), removeCourseCode);
                    break;
                case 3:
                    managementSystem.displayAvailableCourses();
                    break;
                case 4:
                    continueOperations = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }

        scanner.close();
    }
}
