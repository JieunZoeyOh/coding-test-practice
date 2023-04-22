package Basic.Part02.Sort;

import java.util.Scanner;

/**
 * p. 178
 * 위에서 아래로
 * 하나의 수열에는 다양한 수가 존재한다. 이러한 수는 크기에 상관없이 나열되어 있다.
 * 이 수를 큰 수부터 작은 수의 순서로 정렬해야 한다.
 * 수열을 내림차순으로 정렬하는 프로그램을 만드시오
 * 첫째 줄에 수열에 속해 있는 수의 개수 N이 주어진다 (1 <= N <= 500)
 * 둘째 줄부터 N + 1번째 줄까지 N개의 수가 입력된다. (1 <= x <= 100,000)
 */
public class Test1_UpToDown_v2 {
    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] >= arr[pivot]) left++;
            while (right > start && arr[right] <= arr[pivot]) right--;

            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // 퀵 정렬
        quickSort(arr, 0, n - 1);

        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
