package nam.tran.exercise1;

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

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%-3s | %-3d | %-3s", this.name, semester, courseName);
    }
}
