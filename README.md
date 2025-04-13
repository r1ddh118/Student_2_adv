# Student Data Entry System

## Author
**Name:** Riddhi Poddar  
**PRN:** 23070126105  
**Batch:** AIML-B2

---

## Overview

This Java-based console application allows users to manage student data efficiently. The system supports functionalities such as adding, displaying, updating, deleting, and searching for student records. It is developed using object-oriented programming principles and includes custom exception handling for robust performance.

---

## File Structure

| File Name                       | Description |
|--------------------------------|-------------|
| `Main.java`                    | Entry point of the program. Handles the user interface and menu-driven control flow. |
| `Student.java`                 | Defines the `Student` class with fields and methods to manage student data. |
| `StudentOperations.java`       | Contains all operations related to student data such as add, display, update, delete, and search. |
| `StudentNotFoundException.java` | Custom exception thrown when a student is not found in the list. |
| `InvalidCGPAException.java`    | Custom exception for CGPA values outside the range of 0.0 to 10.0. |
| `DuplicatePRNException.java`   | Custom exception for duplicate PRN entries during student addition. |
| `InvalidBatchFormatException.java` | Custom exception for incorrect batch formatting (not in YYYY-YY format). |

---

## Functionalities and Method Descriptions

### addStudent(Scanner scan)
- Adds a new student to the list.
- Validates:
  - PRN must be unique.
  - CGPA must be between 0.0 and 10.0.
  - Batch must match the format `YYYY-YY`.
- Throws:
  - `DuplicatePRNException`
  - `InvalidCGPAException`
  - `InvalidBatchFormatException`

### displayStudents()
- Displays all student records in the list.
- Shows a message if no students are available.

### searchByPRN(Scanner scan)
- Searches for a student using their PRN.
- Throws:
  - `StudentNotFoundException`

### searchByName(Scanner scan)
- Searches for a student using their name (case-insensitive).
- Throws:
  - `StudentNotFoundException`

### updateStudent(Scanner scan)
- Updates details of an existing student identified by PRN.
- Validates new CGPA.
- Throws:
  - `StudentNotFoundException`
  - `InvalidCGPAException`

### deleteStudent(Scanner scan)
- Deletes a student record using their PRN.
- Throws:
  - `StudentNotFoundException`

---

## Custom Exceptions

| Exception Class                | Description |
|--------------------------------|-------------|
| `StudentNotFoundException`     | Thrown when a student is not found during search, update, or delete operations. |
| `InvalidCGPAException`         | Thrown when CGPA is out of the valid range (0.0 to 10.0). |
| `DuplicatePRNException`        | Thrown when trying to add a student with an existing PRN. |
| `InvalidBatchFormatException`  | Thrown when the batch format is incorrect (not in `YYYY-YY`). |

---
