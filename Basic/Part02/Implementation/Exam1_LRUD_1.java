package Basic.Part02.Implementation;

import java.util.Scanner;

/**
 * p. 110
 * 예제 4-1. 상하좌우
 */
public class Exam1_LRUD_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");

        int x = 1, y = 1;
        char[] directions = {'L', 'R', 'U', 'D'};
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 이동 계획을 하나씩 확인
        for (String s : plans) {
            char plan = s.charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == directions[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
