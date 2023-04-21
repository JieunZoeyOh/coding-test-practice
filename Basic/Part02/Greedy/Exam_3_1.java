package Basic.Part02.Greedy;

import java.util.Scanner;

/**
 * p. 96
 * 숫자 카드 게임
 */
public class Exam_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 행
        int m = sc.nextInt(); // 열
        int result = 0;

        for (int i = 0; i < n; i++) {
            int minValue = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                minValue = Math.min(x, minValue);
            }
            result = Math.max(minValue, result);
        }

        System.out.println(result);
    }
}
