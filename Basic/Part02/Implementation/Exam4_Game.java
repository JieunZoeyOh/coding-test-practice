package Basic.Part02.Implementation;

import java.util.Scanner;

/**
 * p. 118
 * 게임 개발
 */
public class Exam4_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] land = new boolean[n][m];
        boolean[][] visited = new boolean[n][m]; // false == 아직 안가봄

        int a = sc.nextInt();
        int b = sc.nextInt();
        int direction = sc.nextInt(); // (a, b)에 위치해있고 방향은 d이다.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // (a, b)는 가봄
        visited[a][b] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                land[i][j] = sc.nextInt() == 0; // true == 땅
            }
        }

        int count = 1;
        int turnTime = 0;

        while (true) {
            // 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향으로 돌아서 갈 수 있는 지 확인
            direction = turnLeft(direction);
            turnTime++;

            int nx = a + dx[direction];
            int ny = b + dy[direction];

            if (land[nx][ny] && !visited[nx][ny]) { // 땅이고 아직 안가봤으면
                a = nx;
                b = ny;

                visited[a][b] = true;
                count++;
                turnTime = 0;
                direction++;
                continue;
            }

            if (turnTime == 4) {
                // 방향 유지 뒤로 1칸
                nx = a - dx[direction];
                ny = b - dy[direction];

                turnTime = 0;
                if (!land[nx][ny]) { // 뒤에가 바다면
                    break;
                } else {
                    a = nx;
                    b = ny;
                }
            }
        }

        System.out.println(count);


    }

    // 반시계방향 북(0) -> 서(3) -> 남(2) -> 동(1) -> 북(0)
    public static int turnLeft(int direction) {
        return direction == 0 ? 3 : --direction;
    }
}
