package Basic.Part02.Dynamic;

import java.util.Scanner;

/**
 * p. 217
 * 1로 만들기
 * 경우의 수: -1, /2, /3, /5
 */
public class Exam2_Make1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // DP 테이블
        int[] memo = new int[30_001];

        int x = sc.nextInt();
        sc.close();

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        // 1은 0이므로 2부터 시작
        for (int i = 2; i <= x; i++) {
            memo[i] = memo[i - 1] + 1;

            if (i % 5 == 0) memo[i] = Math.min(memo[i], memo[i / 5] + 1);
            if (i % 3 == 0) memo[i] = Math.min(memo[i], memo[i / 3] + 1);
            if (i % 2 == 0) memo[i] = Math.min(memo[i], memo[i / 2] + 1);
        }

        System.out.println(memo[x]);
    }
}
