package nam.tran.exercise9;

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
        mergeSort(arr);
        System.out.println("Mảng đã được sắp xếp :");
        display(arr);
    }

    public static void mergeSort(int[] arr){
        seperate(arr,0,arr.length - 1);
    }

    private static void seperate(int[] arr, int start, int end) {
        if (start < end) {

            // Tìm điểm chính giữa
            int m = (start + end) / 2;

            // Hàm đệ quy tiếp tục chia đôi
            seperate(arr, start, m);
            seperate(arr, m + 1, end);

            merge(arr, start, m, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        // Tìm kích thước của 2 mảng con để merged
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // Tạo mảng tạm
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + i + 1];
        }

        // Merge các mảng tạm lại

        // Chỉ mục ban đầu của 2 mảng con
        int i = 0, j = 0;

        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int index = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[index] = left[i];
                i++;
            } else {
                arr[index] = right[j];
                j++;
            }
            index++;
        }

        // Sao chép các phần tử còn lại của L[] nếu có
        while (i < n1) {
            arr[index] = left[i];
            i++;
            index++;
        }

        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[index] = right[j];
            j++;
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
