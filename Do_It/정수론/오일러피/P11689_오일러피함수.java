package Do_It.정수론.오일러피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * p. 233
 * 문제 041. 오일러 피 함수 구현하기
 * 백준 11689 [GCD(n, k) = 1]
 */
public class P11689_오일러피함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;

        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p != 0) {
                continue;
            }
            result = result - (result / p);
            while (n % p == 0) {
                n = n / p;
            }
        }

        if (n > 1) {
            result = result - (result / n);
        }

        System.out.println(result);
    }
}
