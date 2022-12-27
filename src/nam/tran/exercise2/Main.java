package nam.tran.exercise2;

import nam.tran.exercise1.ManagerStudent;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManagerCandidate managerCandidate = new ManagerCandidate();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("HỆ THỐNG QUẢN LÝ ỨNG VIÊN");
            System.out.println("1. Có kinh nghiệm");
            System.out.println("2. Fresher");
            System.out.println("3. Thực tập sinh");
            System.out.println("4. Đang tìm kiếm");
            System.out.println("5. Thoát");
            System.out.println("Chọn :");
            String option = scanner.next();
            switch (option){
                case "1":{
                    managerCandidate.insertCandidate(scanner,1);
                    break;
                }
                case "2":{
                    managerCandidate.insertCandidate(scanner,2);
                    break;
                }
                case "3":{
                    managerCandidate.insertCandidate(scanner,3);
                    break;
                }
                case "4":{
                    managerCandidate.search(scanner);
                    break;
                }
                case "5":{
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
