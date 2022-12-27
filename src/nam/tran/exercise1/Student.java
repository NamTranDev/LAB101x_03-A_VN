package nam.tran.exercise1;

import java.util.Objects;
import java.util.UUID;

public class Student {
    private String id;
    private String name;
    private int semester;
    private String courseName;

    public Student(String id, String name, int semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-5d | %-5s", this.name, semester, courseName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
