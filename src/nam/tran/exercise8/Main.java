package nam.tran.exercise8;

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
        quickSort(arr);
        System.out.println("Mảng đã được sắp xếp :");
        display(arr);
    }

    private static void quickSort(int[] arr){
        sort(arr,0,arr.length - 1);
    }

    // Hàm nhận phần tử cuối cùng làm chốt,
    // đặt các phần tử nhỏ hơn chốt ở trước
    // và lớn hơn ở sau nó
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
//        System.out.println("Pivot : " + pivot);
        int i = start;  // index of smaller element
        for (int j = start; j < end; j++) {
            // Nếu phần tử hiện tại nhỏ hơn chốt
            if (arr[j] < pivot){
                // swap arr[i] và arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        // swap arr[i] và arr[end] (hoặc pivot)
        int temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;
//        System.out.println("partition");
//        display(arr);
        return i;
    }

    // arr[] --> Mảng cần được sắp xếp,
    // low --> chỉ mục bắt đầu,
    // high --> chỉ mục kết thúc
    private static void sort(int[] arr, int low, int high) {
        if (low < high) {

            // pi là chỉ mục của chốt, arr[pi] vị trí của chốt
            int pi = partition(arr, low, high);

            // Sắp xếp đệ quy các phần tử
            // trước phân vùng và sau phân vùng
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
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
