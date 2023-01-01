package nam.tran.exercise7;

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
        insertionSort(arr);
        System.out.println("Mảng đã được sắp xếp :");
        display(arr);
    }

    /*
     *   Thuật toán sắp xếp chèn (Insertion Sort) thực hiện sắp xếp các phần tử theo cách duyệt từng phần tử. Và chèn
     *   từng phần tử đó vào đúng vị trí trong mảng con. Phần tử được chuyền vào vị trí thích hợp sao cho mảng con vẫn
     *   đảm bảo sắp xếp theo đúng thứ tự.
     **/
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = value;
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
