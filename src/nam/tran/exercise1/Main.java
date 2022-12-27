package nam.tran.exercise1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManagerStudent managerStudent = new ManagerStudent();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("CHÀO MỪNG ĐẾN QUẢN LÝ SINH VIÊN");
            System.out.println("1. Tạo");
            System.out.println("2. Tìm kiếm và Sắp xếp");
            System.out.println("3. Cập nhật/Xóa");
            System.out.println("4. Báo cáo");
            System.out.println("5. Thoát");
            String option = scanner.next();
            switch (option){
                case "1":{
                    managerStudent.createStudent(scanner);
                    break;
                }
                case "2":{
                    managerStudent.findAndSort(scanner);
                    break;
                }
                case "3":{
                    managerStudent.findAndUpdateOrDelete(scanner);
                    break;
                }
                case "4":{break;}
                case "5":{
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
