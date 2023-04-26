package Basic.Part02.Dynamic;

import java.util.*;

public class Exam5_Money {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 화폐 종류 개수
        int m = sc.nextInt(); // 합

        int[] units = new int[n];
        for (int i = 0; i < n; i++) {
            units[i] = sc.nextInt();
        }

        sc.close();
        int[] dp = new int[10_001];
        Arrays.fill(dp, 10_001); // 10,001이라면 경우의 수가 없는 것.
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int unit = units[i];
            for (int j = unit; j <= 10_000; j++) {
                if (dp[j - unit] != 10_001) {
                    dp[j] = Math.min(dp[j], dp[j - unit] + 1);
                }
            }
        }

        if (dp[m] == 10_001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }

    }
}
