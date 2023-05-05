package Do_It.정렬;

import java.io.*;
import java.util.StringTokenizer;

/**
 * p. 133
 * 문제 021. 버블 소트 프로그램
 * 백준 1517 [버블 소트]
 * N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에 대해서 버블 소트를 수행할 때, Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오.
 * N(1 ≤ N ≤ 500,000)
 */
public class P1517_버블_소트2 {
    public static int[] arr, temp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        temp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(1, n);

        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1)
            return;

        int middle = start + (end - start) / 2;

        // 재귀 함수 형태로 구현
        mergeSort(start, middle);
        mergeSort(middle + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int k = start;
        int idx1 = start;
        int idx2 = middle + 1;
        while (idx1 <= middle && idx2 <= end) {
            if (temp[idx1] > temp[idx2]) {
                arr[k] = temp[idx2];
                result = result + idx2 - k; // 뒤쪽 데이터 값이 작은 경우 result 업데이트
                k++; // 업데이트 후 index+1
                idx2++;
            } else {
                arr[k] = temp[idx1];
                k++;
                idx1++;
            }
        }

        // 한 쪽 그룹이 다 선택된 경우 나머지 그룹 정리
        while (idx1 <= middle) {
            arr[k] = temp[idx1];
            k++;
            idx1++;
        }

        while (idx2 <= end) {
            arr[k] = temp[idx2];
            k++;
            idx2++;
        }
    }
}
