package Basic.Part02.BinarySearch;

import java.util.*;

/**
 * p. 197
 * 부품 찾기
 * 이진 탐색을 이용하여 문제 해결
 */
public class Exam3_FindPart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = sc.nextInt();
        }

        sc.close();
        Arrays.sort(nArr);

        for (int findItem : mArr) {
            int index = binaryPartSearch(nArr, findItem, 0, n - 1);
            System.out.println(index == -1 ? "NO": "YES");
        }
    }

    private static int binaryPartSearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binaryPartSearch(arr, target, start, mid - 1);
        else return binaryPartSearch(arr, target, mid + 1, end);
    }
}
