import java.util.Scanner;

public class Codsoft_taskno_2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Student Grade Calculator:\n");

            System.out.print("Enter the number of subjects: ");
            int numSubjects = sc.nextInt();
            int[] marks = new int[numSubjects];

            // Input marks for each subject
            int totalMarks = 0;
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                int subjectMarks = sc.nextInt();

                // Validate marks (assuming marks should be between 0 and 100)
                while (subjectMarks < 0 || subjectMarks > 100) {
                    System.out.println("Invalid input! Marks should be between 0 and 100.");
                    System.out.print("Enter marks for subject " + (i + 1) + " again: ");
                    subjectMarks = sc.nextInt();
                }

                marks[i] = subjectMarks;
                totalMarks += subjectMarks;
            }

            // Calculate total marks and average percentage
            int totalPossibleMarks = numSubjects * 100;
            double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

            System.out.println("\nResults:\n");
            System.out.println("Total marks obtained: " + totalMarks + "/" + totalPossibleMarks);
            System.out.printf("Average percentage: %.2f%%\n", averagePercentage);

            // Grade assigning
            System.out.println("\nGrades:");
            for (int i = 0; i < marks.length; i++) {
                int val = marks[i];
                System.out.print("Subject " + (i + 1) + " Grade: ");
                if (val >= 90) {
                    System.out.println("S");
                } else if (val >= 80) {
                    System.out.println("A");
                } else if (val >= 70) {
                    System.out.println("B");
                } else if (val >= 60) {
                    System.out.println("C");
                } else if (val >= 50) {
                    System.out.println("D");
                } else {
                    System.out.println("F");
                }
            }
        }
    }
}
