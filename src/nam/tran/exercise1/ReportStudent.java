package nam.tran.exercise1;

import java.util.Objects;

public class ReportStudent {
    private String name;
    private String course;
    private int count;

    public ReportStudent(String name, String course) {
        this.name = name;
        this.course = course;
        count = 1;
    }

    public void updateCount(){
        count++;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-5s | %-5d", this.name, course, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportStudent that = (ReportStudent) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }
}
