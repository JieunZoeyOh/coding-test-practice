package Basic.Part02.BinarySearch;

import java.util.*;

/**
 * p. 188
 * 재귀 함수로 구현한 이직 탐색 소스코드
 */
public class Exam2_BinarySearch_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int index = binarySearch(arr, target, 0, n - 1);
        System.out.println(index + 1);
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2; // 괄호!
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        else return binarySearch(arr, target, mid + 1, end);
    }
}
