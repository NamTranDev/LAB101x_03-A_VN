package nam.tran.exercise1;

import nam.tran.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {

    private List<Student> students;

    public ManagerStudent() {
        students = new ArrayList<>();
    }

    private boolean isExist(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private Student foundStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void createStudent(Scanner scanner) {
        while (true) {
            String id;
            while (true) {
                System.out.println("Nhập id học viên:");
                id = scanner.next();
                if (isExist(id)) {
                    System.out.println("Id này đã tồn tại trong hệ thống");
                } else {
                    break;
                }
            }
            String name = inputName(scanner);
            int semester = inputSemester(scanner);
            String course = inputCourse(scanner);
            students.add(new Student(id, name, semester, course));
            System.out.println("Tạo sinh viên thành công");
            if (students.size() > 10) {
                System.out.println("Bạn có muốn nhập tiếp (Y/N) không?");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }

    private String inputName(Scanner scanner) {
        System.out.println("Nhập tên học viên:");
        return Utils.inputLine(scanner);
    }

    private int inputSemester(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Nhập học kỳ:");
                return Integer.parseInt(scanner.next());
            } catch (Exception ignored) {
                System.out.println("Học kỳ cần phải là số");
            }
        }
    }

    private String inputCourse(Scanner scanner) {
        String[] courses = new String[3];
        courses[0] = "Java";
        courses[1] = ".Net";
        courses[2] = "C/C++";
        String course = courses[0];
        boolean isCompleteChooseCourse = false;
        while (!isCompleteChooseCourse) {
            System.out.println("Chọn khóa học:");

            System.out.println("1 : Java\n2 : .Net\n3 : C/C++");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    course = courses[0];
                    isCompleteChooseCourse = true;
                    break;
                }
                case 2: {
                    course = courses[1];
                    isCompleteChooseCourse = true;
                    break;
                }
                case 3: {
                    course = courses[2];
                    isCompleteChooseCourse = true;
                    break;
                }
                default:
                    System.out.println("Bạn cần chọn khóa học phù hợp!!!");
                    break;
            }
        }
        return course;
    }

    public void findAndSort(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("Không có dữ liệu!!!");
            return;
        }
        System.out.println("Nhập tên sinh viên:");
        String name = Utils.inputLine(scanner);
        List<Student> founds = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                founds.add(student);
            }
        }
        if (founds.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên!!!");
        } else {
            founds.sort(Comparator.comparing(Student::getName));
            founds.forEach(student -> System.out.println(student.toString()));
        }
    }

    public void findAndUpdateOrDelete(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("Không có dữ liệu!!!");
            return;
        }
        System.out.println("Nhập id sinh viên:");
        String id = scanner.next();
        Student student = foundStudent(id);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên!!!");
        } else {
            System.out.println(student);
            System.out.println("Bạn muốn cập nhật (U) hay xóa (D) học sinh:");
            String answer = scanner.next();
            if (answer.equals("U")) {
                System.out.println("Bạn muốn cập nhật tên(1),học kỳ(2),khoá học(3)");
                String option = scanner.next();
                switch (option) {
                    case "1": {
                        String name = inputName(scanner);
                        student.setName(name);
                        break;
                    }
                    case "2": {
                        int semester = inputSemester(scanner);
                        student.setSemester(semester);
                        break;
                    }
                    case "3": {
                        String course = inputCourse(scanner);
                        student.setCourseName(course);
                        break;
                    }
                }
            } else if (answer.equals("D")) {
                students.remove(student);
                System.out.println("Xoá thành công.");
            }
        }
    }

    public void report() {
        if (students.isEmpty()) {
            System.out.println("Không có dữ liệu!!!");
            return;
        }
        System.out.println("Báo cáo như sau:");
        List<ReportStudent> reports = new ArrayList<>();
        for (Student student : students) {
            ReportStudent report = new ReportStudent(student.getName(), student.getCourseName());
            if (!reports.contains(report)) {
                reports.add(report);
            } else {
                int position = reports.indexOf(report);
                reports.get(position).updateCount();
            }
        }
        for (ReportStudent report : reports) {
            System.out.println(report.toString());
        }
    }

}
