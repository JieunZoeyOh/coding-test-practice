package Basic.Part02.Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * p. 92
 * 큰 수의 법칙
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 배열 길이
        int m = sc.nextInt(); // 더할 수 있는 횟수
        int k = sc.nextInt(); // 최대 연속으로 더할 수 있는 횟수

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int first = arr[n - 1];
        int second = arr[n - 2];

        int result = (first * k + second) * (m / (k + 1)) + first * (m % (k + 1));

        System.out.println(result);
    }
}
