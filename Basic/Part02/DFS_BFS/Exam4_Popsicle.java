package Basic.Part02.DFS_BFS;

import java.util.Scanner;

/**
 * p. 149
 * 음료수 얼려 먹기
 * DFS 방식으로 해결
 */
public class Exam4_Popsicle {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];
    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }

        // 현재 노드를 아직 방문하지 않은 경우
        if (graph[x][y] == 0) {
            graph[x][y] = 1; // 방문 처리
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        for (int i = 0; i < n; i++) {
            //String[] row = sc.nextLine().split("");
            String row = sc.nextLine();
            for (int j = 0; j < m; j++) {
                // graph[i][j] = Integer.parseInt(row[j]);
                graph[i][j] = row.charAt(j) - '0';
            }
        }
        sc.close();

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
