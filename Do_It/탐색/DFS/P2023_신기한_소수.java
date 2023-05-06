package Do_It.탐색.DFS;

import java.util.Scanner;

/**
 * p. 153
 * 문제 024. 신기한 소수 찾기
 * 백준 2023 [신기한 소수]
 */
public class P2023_신기한_소수 {
    static boolean[] isNotPrime;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        setIsNotPrime((int) Math.pow(10, n) - 1);

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int number, int digit) {
        if (digit == n) {
            if (!isNotPrime[number]) {
                System.out.println(number);
            }
            return;
        }

        for (int i = 1; i < 10; i += 2) {
            if (!isNotPrime[number * 10 + i]) { // 소수라면 재귀 함수로 자릿수를 늘린다
                dfs(number * 10 + i, digit + 1);
            }
        }
    }

    static void setIsNotPrime(int num) {
        isNotPrime = new boolean[num + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= num; i++) {
            for (int j = i * i; j <= num; j+=i) {
                isNotPrime[j] = true; // 2를 제외한 2의 배수: 소수가 아님
            }
        }
    }
}
