package Basic.Part02.Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * p. 96
 * 숫자 카드 게임
 */
public class Exam_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 행
        int m = sc.nextInt(); // 열

        int[][] cards = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cards[i][j] = sc.nextInt();
            }
        }

        int[] minArrays = new int[n];
        for (int i = 0; i < n; i++) {
            Arrays.sort(cards[i]);
            minArrays[i] = cards[i][0];
        }

        Arrays.sort(minArrays);

        System.out.println(minArrays[n - 1]);
    }
}
