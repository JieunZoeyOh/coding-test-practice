package Basic.Part02.BinarySearch;

import java.util.Scanner;

/**
 * p. 190
 * 반복문으로 구현한 이진 탐색 소스코드
 */
public class Exam2_BinarySearch_Loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int start = 0;
        int end = n - 1;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(index + 1);
    }
}
