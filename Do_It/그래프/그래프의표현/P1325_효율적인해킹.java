package Do_It.그래프.그래프의표현;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * p. 265
 * 문제 047. 효율적으로 해킹하기
 * 백준 1325 [효율적인 해킹]
 */
public class P1325_효율적인해킹 {

    static int node, edge;
    static ArrayList<Integer>[] nodes;
    static int[] answers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[node + 1];
        for (int i = 0; i <= node; i++) {
            nodes[i] = new ArrayList<>();
        }
        answers = new int[node + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from].add(to);
        }
        br.close();

        for (int i = 1; i <= node; i++) {
            visited = new boolean[node + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= node; i++) {
            max = Math.max(max, answers[i]);
        }

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int nextNode : nodes[nowNode]) {
                if (visited[nextNode]) {
                    continue;
                }
                visited[nextNode] = true;
                answers[nextNode]++;
                queue.add(nextNode);
            }
        }
    }
}
