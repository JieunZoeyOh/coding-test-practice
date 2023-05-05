package Do_It.정렬;

import java.io.*;

/**
 * p. 139
 * 문제 022. 수 정렬하기3
 * 백준 10989 [수 정렬하기]
 * 기수 정렬 이용
 */
public class P10989_수_정렬하기3_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            max = Math.max(max, num);
        }
        br.close();

        radixSort(arr, n, max);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] arr, int n, int max) {
        for (int i = 1; (max / i) > 0; i *= 10) {
            countSort(arr, n, i);
        }
    }

    private static void countSort(int[] arr, int n, int digit) {
        int[] temp = new int[n];
        int[] cnt = new int[10];

        for (int i = 0; i < n; i++) {
            int digitNum = (arr[i] / digit) % 10;
            cnt[digitNum]++;
        }

        // 합배열
        for (int i = 1; i <= 9; i++) {
            cnt[i] = cnt[i - 1] + cnt[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digitNum = (arr[i] / digit) % 10;
            int newIndex = --cnt[digitNum];
            temp[newIndex] = arr[i];
        }

        // temp -> arr 데이터 옮기기
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
