package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Students {
    private static Students instance;
    private static final String FILE_NAME = "Students.csv";
    private List<Student> students;

    public Students() {
        this.students = loadStudents();
    }

    public static Students getInstance() { // de tao 1 doi tuong duy nhat???
        if (instance == null) {
            instance = new Students();
        }
        return instance;
    }

    private List<Student> loadStudents() {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                studentList.add(Student.fromCSV(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public void saveStudents() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                bw.write(student.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }
}
