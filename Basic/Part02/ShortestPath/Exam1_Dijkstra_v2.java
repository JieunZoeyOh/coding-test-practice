package Basic.Part02.ShortestPath;

import java.util.*;

/**
 * p.239
 * 개선된 다익스트라 알고리즘
 */
class NewNode implements Comparable<NewNode> {
    private final int index;
    private final int distance;

    public NewNode(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(NewNode other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Exam1_Dijkstra_v2 {
    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<NewNode>> graph = new ArrayList<>();
    // 최단 거리 테이블
    public static int[] d = new int[100_001];

    public static void dijkstra(int start) {
        PriorityQueue<NewNode> q = new PriorityQueue<>();
        q.offer(new NewNode(start, 0));
        d[start] = 0;
        while (!q.isEmpty()) {
            NewNode node = q.poll(); // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            int dist = node.getDistance(); // 현재 노드까지의 비용
            int now = node.getIndex(); // 현재 노드 번호

            if (d[now] < dist) continue; // 더 작은 게 있으면 무시

            // 인접한 다른 노드 확인
            ArrayList<NewNode> nextNodes = graph.get(now);
            for (NewNode nextNode : nextNodes) {
                int cost = d[now] + nextNode.getDistance();

                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[nextNode.getIndex()]) {
                    d[nextNode.getIndex()] = cost;
                    q.offer(new NewNode(nextNode.getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선정보 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c이다.
            graph.get(a).add(new NewNode(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }
    }
}
