package nam.tran.exercise1;

import java.util.*;

public class ManagerStudent {

    private List<Student> students;

    public ManagerStudent() {
        students = new ArrayList<>();
    }

    private boolean isExist(String id){
        for (Student student : students) {
            if (student.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    private Student foundStudent(String id){
        for (Student student : students) {
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public void createStudent(Scanner scanner){
        while (true){
            String id;
            while (true){
                System.out.println("Nhập id học viên:");
                id = scanner.next();
                if (isExist(id)){
                    System.out.println("Id này đã tồn tại trong hệ thống");
                }else {
                    break;
                }
            }
            System.out.println("Nhập tên học viên:");
            String name = scanner.next();
            int semester;
            while (true){
                try {
                    System.out.println("Nhập học kỳ:");
                    semester = Integer.parseInt(scanner.next());
                    break;
                }catch (Exception ignored){
                    System.out.println("Học kỳ cần phải là số");
                }
            }
            String[] courses = new String[3];
            courses[0] = "Java";
            courses[1] = ".Net";
            courses[2] = "C/C++";
            String course = courses[0];
            boolean isCompleteChooseCourse = false;
            while (!isCompleteChooseCourse){
                System.out.println("Chọn khóa học:");

                System.out.println("1 : Java\n2 : .Net\n3 : C/C++");
                int choose = scanner.nextInt();
                switch (choose){
                    case 1:{
                        course = courses[0];
                        isCompleteChooseCourse = true;
                        break;
                    }
                    case 2:{
                        course = courses[1];
                        isCompleteChooseCourse = true;
                        break;
                    }
                    case 3:{
                        course = courses[2];
                        isCompleteChooseCourse = true;
                        break;
                    }
                    default:
                        System.out.println("Bạn cần chọn khóa học phù hợp!!!");
                        break;
                }
            }
            students.add(new Student(id,name,semester,course));
            System.out.println("Tạo sinh viên thành công");
            if (students.size() > 10){
                System.out.println("Bạn có muốn nhập tiếp (Y/N) không?");
                String answer = scanner.next();
                if (answer.equals("N")){
                    break;
                }
            }
        }
    }

    public void findAndSort(Scanner scanner){
        System.out.println("Nhập tên sinh viên:");
        String name = scanner.next();
        List<Student> founds = new ArrayList<>();
        for (Student student: students) {
            if (student.getName().contains(name)){
                founds.add(student);
            }
        }
        if (founds.isEmpty()){
            System.out.println("Không tìm thấy sinh viên!!!");
        }else {
            founds.sort(Comparator.comparing(Student::getName));
            founds.forEach(student -> System.out.println(student.toString()));
        }
    }

    public void findAndUpdateOrDelete(Scanner scanner) {
        System.out.println("Nhập id sinh viên:");
        String id = scanner.next();
        Student student = foundStudent(id);
        if (student == null){
            System.out.println("Không tìm thấy sinh viên!!!");
        }else {
            System.out.println("Bạn muốn cập nhật (U) hay xóa (D) học sinh:");
            String answer = scanner.next();
            if (answer.equals("U")){

            }else if (answer.equals("D")){

            }
        }
    }

}
