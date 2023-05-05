package Do_It.정렬;

import java.util.*;
import java.io.*;

/**
 * p. 115
 * 문제 018. ATM 인출 시간 계산하기
 * 백준 11399 [ATM]
 */
public class P11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum += i * arr[n - i];
        }

        System.out.println(sum);
        br.close();
    }
}
