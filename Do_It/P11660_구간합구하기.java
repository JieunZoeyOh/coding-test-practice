package Do_It;

import java.io.*;
import java.util.*;

/**
 * p. 47
 * 문제 004. 구간 합 구하기 2
 * 백준 11660 [구간합 구하기5]
 */
public class P11660_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // nXn 표
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

        long[][] table = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long sum = 0;
            for (int j = x1; j <= x2; j++) {
                sum += table[j][y2] - table[j][y1 - 1];
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
