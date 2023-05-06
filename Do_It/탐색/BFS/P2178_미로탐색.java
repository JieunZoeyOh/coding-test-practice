package Do_It.탐색.BFS;

import java.io.*;
import java.util.*;

public class P2178_미로탐색 {
    static boolean[][] visited;
    static int[][] check;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N x M
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 1: 이동 가능, 0: 이동 불가
        int[][] map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        check = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            char[] chars = str.toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = chars[j-1] - '0';
                check[i][j] = Integer.MAX_VALUE;
            }
        }
        br.close();

        bfs(map, 1, 1);

        System.out.println(check[n][m]);
    }

    private static void bfs(int[][] map, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        check[x][y] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = now.getN() + dx[i];
                int tempY = now.getM() + dy[i];

                if (tempX < 1 || tempX > n || tempY < 1 || tempY > m) {
                    continue;
                }
                if (map[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                    q.add(new Node(tempX, tempY));
                    visited[tempX][tempY] = true;
                    check[tempX][tempY] = Math.min(check[tempX][tempY], check[now.getN()][now.getM()] + 1);
                }
            }

        }
    }

    private static class Node {
        private int n;
        private int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }
    }
}
