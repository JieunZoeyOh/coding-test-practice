package Do_It;

import java.util.Scanner;

/**
 * p. 56
 * 문제 006. 연속된 자연수의 합 구하기
 * 백준 2018 [수들의 합 5]
 */
public class P2018_수들의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long start = 1, end = 1, sum = 1, count = 1;

        while (end < n) {
            if (sum == n) {
                count++;
                end++;
                sum = sum + end;
            } else if (n < sum) {
                sum = sum - start;
                start++;
            } else {
                end++;
                sum = sum + end;
            }
        }

        sc.close();
        System.out.println(count);
    }
}
