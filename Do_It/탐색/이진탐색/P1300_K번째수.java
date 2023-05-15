package Do_It.탐색.이진탐색;

import java.util.Scanner;

/**
 * p.190
 * 문제 031. 배열에서 K번째 수 찾기
 * 백준 1300 [K번째 수]
 */
public class P1300_K번째수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        long start = 1;
        long end = k;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += Math.min(mid / i, n);
            }
            if (sum < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
