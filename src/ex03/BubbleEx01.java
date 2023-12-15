package ex03;

public class BubbleEx01 {

    static void bubble(int[] arr) {
        final int N = arr.length;

        int temp;

        for (int loop = 1; loop < N; loop++) {
            for (int i = 0; i < N - loop; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        // 출력코드
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 2, 4, 3};
        BubbleEx01.bubble(arr);
        System.out.println();

        int[] arr2 = {5, 8, 2, 4, 3, 10, 500, 7, 6};
        BubbleEx01.bubble(arr2);
    }
}