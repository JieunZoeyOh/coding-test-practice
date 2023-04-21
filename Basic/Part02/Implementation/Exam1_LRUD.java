package Basic.Part02.Implementation;

import java.util.Scanner;

/**
 * p. 110
 * 예제 4-1. 상하좌우
 */
public class Exam1_LRUD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");

        int x = 1, y = 1;
        String[] directions = {"L", "R", "U", "D"};
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (String plan : plans) {
            int index = 0;
            for (int j = 0; j < 4; j++) {
                if (plan.equals(directions[j])) {
                    index = j;
                    break;
                }
            }
            x += dx[index];
            y += dy[index];

            if (x < 1 || x > n) {
                x -= dx[index];
            }
            if (y < 1 || y > n) {
                y -= dy[index];
            }
        }

        System.out.println(x + " " + y);
    }
}
