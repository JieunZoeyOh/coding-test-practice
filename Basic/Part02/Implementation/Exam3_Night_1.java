package Basic.Part02.Implementation;

import java.util.Scanner;

/**
 * p. 115
 * 왕실의 나이트
 */
public class Exam3_Night_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int col = input.charAt(0) - 'a' + 1;
        int row = input.charAt(1) - '0';

        int[] dx = {-2, -2, 2, 2, 1, -1, 1, -1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};

        int result = 0;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <= 8) {
                result++;
            }
        }

        System.out.println(result);
    }

}
