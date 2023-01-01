package nam.tran.exercise3;

import nam.tran.Utils;
import nam.tran.exercise1.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class ManagerFruit {

    private List<Fruit> fruits;
    private HashMap<String, List<Fruit>> orders;

    public ManagerFruit() {
        fruits = new ArrayList<>();
        orders = new HashMap<>();
    }

    private boolean isExist(String id) {
        for (Fruit fruit : fruits) {
            if (fruit.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void createFruit(Scanner scanner) {
        while (true) {
            String id;
            while (true) {
                System.out.println("Nhập mã trái cây:");
                id = scanner.next();
                if (isExist(id)) {
                    System.out.println("Id này đã tồn tại trong hệ thống");
                } else {
                    break;
                }
            }
            System.out.println("Nhập tên trái cây:");
            String name = scanner.next();

            int price;
            while (true) {
                System.out.println("Nhập giá trái cây:");
                try {
                    price = Integer.parseInt(scanner.next());
                    break;
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập giá trái cây!!!");
                }
            }


            System.out.println("Nhập nguồn gốc trái cây:");
            String origin = Utils.inputLine(scanner);

            int quality = inputQuality(scanner, -1);
            fruits.add(new Fruit(id, name, price, quality, origin));
            System.out.println("Bạn có muốn nhập tiếp (Y/N) không?");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n")) {
                displayFruits(fruits);
                break;
            }
        }
    }

    private int inputQuality(Scanner scanner, int number) {
        while (true) {
            System.out.println("Nhập số lượng trái cây:");
            try {
                int quality = Integer.parseInt(scanner.next());
                if (number == -1) {
                    return quality;
                }
                if (quality > number) {
                    System.out.println("Bạn đang nhập số lượng lớn hơn hiện có!!!");
                }else{
                    return quality;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số lượng trái cây!!!");
            }
        }
    }

    private void displayFruits(List<Fruit> fruits) {
        System.out.println("Danh sách trái cây:");
        System.out.println("| ++ Mục++ | ++Tên trái cây++ | ++Xuất xứ++ | ++Giá++ |");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("     " + (i + 1) + fruits.get(i).toString());
        }
    }

    public void displayOrder(){
        if (orders.isEmpty()){
            System.out.println("Không có đơn đặt hàng nào");
            return;
        }
        orders.forEach((name, fruits) -> {
            System.out.println("Khách hàng: " + name);
            displayOrder(fruits);
        });
    }

    public void order(Scanner scanner) {
        if (fruits.isEmpty()) {
            System.out.println("Danh mục hàng đang trống ,vui lòng tạo trái cây!!!");
            return;
        }
        int position;
        List<Fruit> orderFruits = new ArrayList<>();
        while (true) {
            List<Fruit> fruitUpdates = new ArrayList<>();
            if (orderFruits.isEmpty()) {
                fruitUpdates = fruits;
            } else {
                for (Fruit fruit : fruits) {
                    int index = orderFruits.indexOf(fruit);
                    if (index != -1) {
                        Fruit fruitOrder = orderFruits.get(index);
                        fruitUpdates.add(new Fruit(fruit.getId(), fruit.getName(), fruit.getPrice(), fruit.getQuantity() - fruitOrder.getQuantity(), fruit.getOrigin()));
                    } else {
                        fruitUpdates.add(fruit);
                    }
                }
            }
            displayFruits(fruitUpdates);
            while (true) {
                System.out.println("Quý khách hàng vui lòng chọn mặt hàng:");
                try {
                    position = Integer.parseInt(scanner.next());
                    position = position - 1;
                    if (position > fruitUpdates.size() - 1 || position < 0) {
                        System.out.println("Chọn mặt hàng là số thứ tự ");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Chọn mặt hàng là số thứ tự ");
                }
            }
            Fruit currentFruit = fruitUpdates.get(position);
            System.out.println("Bạn đã chọn: " + currentFruit.getName());
            int quality = inputQuality(scanner, currentFruit.getQuantity());
            System.out.println("Bạn có muốn đặt hàng ngay bây giờ (Y/N):");
            String answer = scanner.next();
            int index = orderFruits.indexOf(currentFruit);
            if (index != -1){
                Fruit fruitUpdate = orderFruits.get(index);
                fruitUpdate.setQuantity(fruitUpdate.getQuantity() + quality);
            }else {
                orderFruits.add(new Fruit(currentFruit.getId(), currentFruit.getName(), currentFruit.getPrice(), quality, currentFruit.getOrigin()));
            }
            if (answer.equalsIgnoreCase("y")) {
                displayOrder(orderFruits);
                String nameClient;
                while (true){
                    System.out.println("Nhập tên của bạn:");

                    nameClient = Utils.inputLine(scanner);

                    if (orders.containsKey(nameClient)){
                        System.out.println("Khách hàng đã tồn tại");
                    }else {
                        break;
                    }
                }
                for (int i = 0; i < fruits.size(); i++) {
                    Fruit fruit = fruits.get(i);
                    int indexItem = orderFruits.indexOf(fruit);
                    if (indexItem != -1) {
                        Fruit fruitOrder = orderFruits.get(indexItem);
                        fruit.setQuantity(fruit.getQuantity() - fruitOrder.getQuantity());
                        if (fruit.getQuantity() == 0){
                            fruits.remove(fruit);
                        }
                    }
                }
                orders.put(nameClient,orderFruits);
                break;
            }
        }
    }

    private void displayOrder(List<Fruit> orderFruit){
        int sum = 0;
        System.out.println("Sản phẩm | Số lượng | Giá |  Số tiền");
        for (Fruit fruit : orderFruit) {
            int sumFruit = fruit.getQuantity() * fruit.getPrice();
            System.out.println(fruit.getName() + "      " + fruit.getQuantity() + "      "  + fruit.getPrice() + "$      "  + sumFruit + "$");
            sum += sumFruit;
        }
        System.out.println("Tổng cộng: " + sum + "$");
    }
}
