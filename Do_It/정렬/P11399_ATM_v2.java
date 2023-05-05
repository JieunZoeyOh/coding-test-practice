package Do_It.정렬;

import java.io.*;
import java.util.*;

/**
 * p. 115
 * 문제 018. ATM 인출 시간 계산하기
 * 백준 11399 [ATM]
 */
public class P11399_ATM_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 합배열
        int[] sumArr = new int[n];
        sumArr[0] = arr[0];
        int sum = arr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
            sum += sumArr[i];
        }

        System.out.println(sum);
        br.close();
    }
}
