package Basic.Part02.Dynamic;

import java.util.*;

/**
 * p. 223
 * 바닥 공사
 */
public class Exam4_Tiles {
    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    public static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
        }

        System.out.println(dp[n]);
    }
}
