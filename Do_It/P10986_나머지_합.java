package Do_It;

import java.util.*;
import java.io.*;

/**
 * p. 52
 * 문제 005. 나머지 합 구하기
 * 백준 10986 [나머지 합]
 * 구분합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수 구하기
 */
public class P10986_나머지_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] table = new long[n];
        table[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            table[i] = table[i - 1] + Integer.parseInt(st.nextToken());
        }

        long[] count = new long[m];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int remainder = (int) (table[i] % m);
            if (remainder == 0) sum += 1;
            count[remainder] += 1;
        }

        for (int i = 0; i < m; i++) {
            if (count[i] < 2) continue;
            sum = sum + (count[i] * (count[i] - 1) / 2);
        }

        br.close();
        System.out.println(sum);
    }
}
