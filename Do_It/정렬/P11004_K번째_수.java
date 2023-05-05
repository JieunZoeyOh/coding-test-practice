package Do_It.정렬;

import java.util.*;
import java.io.*;

/**
 * p. 121
 * 문제 019. K번째 수 구하기
 * 백준 11004 [K번째 수]
 * 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
 * 퀵 정렬로 풀어보기
 */
public class P11004_K번째_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1, k - 1);

        System.out.println(arr[k - 1]);
    }

    public static void quickSort(int[] arr, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot == k)
                return;
            else if (k < pivot)
                quickSort(arr, start, pivot - 1, k);
            else
                quickSort(arr, pivot + 1, end, k);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        if (start + 1 == end) {
            if (arr[start] > arr[end]) {
                swap(arr, start, end);
            }
            return end;
        }

        int middle = (start + end) / 2;
        swap(arr, start, middle); // 중앙값을 1번째 요소와 바꾸기
        int pivot = arr[start];
        int left = start + 1;
        int right = end;
        while (left <= right) {
            while (pivot < arr[right] && right > start) right--;  //피벗보다 작은 수가 나올 떄까지 j--
            while (pivot > arr[left] && left <= end) left++;   //피벗보다 큰 수가 나올 떄까지 left++
            if (left < right) {
                swap(arr, left++, right--);
            } else {
                break;
            }
        }
        // 피벗 데이터를 나눠진 두 경계 index에 저장한다
        arr[start] = arr[right];
        arr[right] = pivot;
        return right;
    }

    // 배열의 두 자리 변경
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
