package nam.tran.exercise6;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng của mảng: ");
        int length = inputLength(scanner);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }
        System.out.println("Mảng chưa được sắp xếp :");
        display(arr);
        selectionSort(arr);
        System.out.println("Mảng đã được sắp xếp :");
        display(arr);
    }

    /*
     *   Thuật toán sắp xếp lựa chọn(Selection Sort) sắp xếp một mảng bằng cách liên tục tìm phần tử tối thiểu (xét
     *   theo thứ tự tăng dần) từ phần không được sắp xếp và đặt nó ở đầu.
     **/
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    private static int inputLength(Scanner scanner){
        int length = 0;
        while (true){
            try {
                length = Integer.parseInt(scanner.next());
                if (length > 1){
                    return length;
                }else {
                    System.out.println("Cần mảng tối thiểu 2 phần tử để sắp xếp");
                }
            }catch (Exception e){
                System.out.println("Vui lòng nhập số nguyên");
            }
        }
    }

    private static void display(int[] array){
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
