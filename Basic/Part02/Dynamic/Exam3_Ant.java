package Basic.Part02.Dynamic;

import java.util.Scanner;

/**
 * p. 220
 * 개미 전사
 */
public class Exam3_Ant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // DP 테이블
        int[] memo = new int[100];

        int n = sc.nextInt();
        int[] warehouse = new int[n];

        for (int i = 0; i < n; i++) {
            warehouse[i] = sc.nextInt();
        }

        sc.close();

        memo[0] = warehouse[0];
        memo[1] = Math.max(warehouse[0], warehouse[1]);

        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + warehouse[i]);
        }

        System.out.println(memo[n - 1]);
    }
}
