package Basic.Part02.Implementation;

import java.util.Scanner;

/**
 * p. 115
 * 왕실의 나이트
 */
public class Exam3_Night {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int col = input.charAt(0) - 'a' + 1;
        int row = input.charAt(1) - '0';

        int result = 0;
        result += countPath(col, row);
        result += countPath(row, col);

        System.out.println(result);
    }

    private static int countPath(int first, int second) {
        int result = 0;
        if (first > 2) {
            if (second > 1) result++;
            if (second < 8) result++;
        }
        if (first < 7) {
            if (second > 1) result++;
            if (second < 8) result++;
        }
        return result;
    }
}
