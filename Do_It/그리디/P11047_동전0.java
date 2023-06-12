package Do_It.그리디;

import java.util.Scanner;

/**
 * p. 196
 * 문제 032. 동전 개수의 최솟값 구하기
 * 백준 11047 [동전 0]
 */
public class P11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            int coin = arr[i];
            if (coin > total) {
                continue;
            }

            int temp = total / coin;
            count = count + temp;
            total = total - (coin * temp);

            if (total == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}
