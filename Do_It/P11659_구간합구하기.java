package Do_It;

import java.io.*;
import java.util.*;

/**
 * p. 44
 * 문제 003. 구간 합 구하기
 * 백준 11659 [구간합 구하기4]
 */
public class P11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] numbers = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(numbers[j] - numbers[i - 1]);
        }
        br.close();
    }
}
