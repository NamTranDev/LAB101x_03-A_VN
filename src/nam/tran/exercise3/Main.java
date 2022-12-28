package nam.tran.exercise3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManagerFruit managerFruit = new ManagerFruit();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("HỆ THỐNG CỬA HÀNG TRÁI CÂY");
            System.out.println("1. Tạo trái cây");
            System.out.println("2. Xem đơn đặt hàng");
            System.out.println("3. Mua sắm (cho người mua)");
            System.out.println("4. Thoát");
            System.out.println("Chọn :");
            String option = scanner.next();
            switch (option){
                case "1":{
                    managerFruit.createFruit(scanner);
                    break;
                }
                case "2":{
                    managerFruit.displayOrder();
                    break;
                }
                case "3":{
                    managerFruit.order(scanner);
                    break;
                }
                case "4":{
                    scanner.close();
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("Vui lòng chọn giá trị từ 1 -> 4");
                    break;
                }
            }
        }

    }
}
