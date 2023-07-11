package Do_It.정수론.소수구하기;

import java.io.*;
import java.util.*;

/**
 * p. 220
 * 문제 038. 거의 소수 구하기
 * 백준 1929 [거의 소수]
 */
public class P1456_거의소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 범위 1 ~ 10^14
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long[] primeArr = new long[10_000_001];
        for (int i = 2; i <= 10_000_000; i++) {
            primeArr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(10_000_000); i++) {
            if (primeArr[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= 10_000_000; j = j + i) {
                primeArr[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i <= 10_000_000; i++) {
            long temp = primeArr[i];
            if (temp == 0) {
                continue;
            }

            while ((double) primeArr[i] <= (double) max / temp) {
                if ((double) primeArr[i] >= (double) min / temp) {
                    count++;
                }
                temp *= primeArr[i];
            }
        }
        System.out.println(count);
    }
}
