// StudentOperations.java

import java.util.ArrayList;
import java.util.Scanner;

class StudentOperations {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Scanner scan) throws DuplicatePRNException, InvalidCGPAException, InvalidBatchFormatException {
        System.out.print("Enter name: ");
        String name = scan.nextLine();
        System.out.print("Enter PRN: ");
        long prn = scan.nextLong();
        scan.nextLine();
        System.out.print("Enter Department: ");
        String dept = scan.nextLine();
        System.out.print("Enter Batch (YYYY-YY): ");
        String batch = scan.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = scan.nextDouble();
        scan.nextLine();

        for (Student s : students) {
            if (s.getPRN() == prn) throw new DuplicatePRNException("PRN already exists.");
        }
        if (cgpa < 0.0 || cgpa > 10.0) throw new InvalidCGPAException("CGPA must be between 0.0 and 10.0.");
        if (!batch.matches("\\d{4}-\\d{2}")) throw new InvalidBatchFormatException("Batch format must be YYYY-YY.");

        students.add(new Student(name, prn, dept, batch, cgpa));
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) student.display();
    }

    public void searchByPRN(Scanner scan) throws StudentNotFoundException {
        System.out.print("Enter PRN: ");
        long prn = scan.nextLong();
        scan.nextLine();
        for (Student student : students) {
            if (student.getPRN() == prn) {
                student.display();
                return;
            }
        }
        throw new StudentNotFoundException("Student with PRN not found.");
    }

    public void searchByName(Scanner scan) throws StudentNotFoundException {
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.display();
                return;
            }
        }
        throw new StudentNotFoundException("Student with Name not found.");
    }

    public void updateStudent(Scanner scan) throws StudentNotFoundException, InvalidCGPAException {
        System.out.print("Enter PRN of student to update: ");
        long prn = scan.nextLong();
        scan.nextLine();
        for (Student student : students) {
            if (student.getPRN() == prn) {
                System.out.print("Enter new name: ");
                student.setName(scan.nextLine());
                System.out.print("Enter new Department: ");
                student.setDept(scan.nextLine());
                System.out.print("Enter new Batch: ");
                student.setBatch(scan.nextLine());
                System.out.print("Enter new CGPA: ");
                double cgpa = scan.nextDouble();
                scan.nextLine();
                if (cgpa < 0.0 || cgpa > 10.0) throw new InvalidCGPAException("Invalid CGPA value.");
                student.setCGPA(cgpa);
                System.out.println("Student details updated.");
                return;
            }
        }
        throw new StudentNotFoundException("Student not found for update.");
    }

    public void deleteStudent(Scanner scan) throws StudentNotFoundException {
        System.out.print("Enter PRN of student to delete: ");
        long prn = scan.nextLong();
        scan.nextLine();
        boolean removed = students.removeIf(student -> student.getPRN() == prn);
        if (!removed) throw new StudentNotFoundException("Student not found to delete.");
        System.out.println("Student deleted successfully.");
    }
}
