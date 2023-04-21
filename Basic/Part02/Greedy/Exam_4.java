package Basic.Part02.Greedy;

import java.util.Scanner;

/**
 * p. 99
 * 1이 될 때까지
 */
public class Exam_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int count = 0;

        while (k <= n) {
            int remain = n % k;
            n -= remain;
            count += remain;
            n /= k;
            count++;
        }

        count += (n - 1);
        System.out.println(count);
    }
}
