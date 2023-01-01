package nam.tran.exercise5;

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
        bubbleSort(arr);
        System.out.println("Mảng đã được sắp xếp :");
        display(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
//                display(arr);
            }
//            display(arr);
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
