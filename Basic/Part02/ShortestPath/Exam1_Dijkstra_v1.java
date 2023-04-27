package Basic.Part02.ShortestPath;

import java.util.*;

/**
 * p.236
 * 간단한 다익스트라 알고리즘
 */
class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}

public class Exam1_Dijkstra_v1 {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    // 방문한 적이 있는지 체크하는 목적의 배열
    public static boolean[] visited = new boolean[100_001]; // 노드 개수 최대 100,000개라 가정
    // 최단 거리 테이블 만들기
    public static int[] d = new int[100_001];

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int minValue = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < minValue && !visited[i]) {
                minValue = d[i];
                index = i;
            }
        }
        return index;
    }

    private static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0; // 자기 자신한테 가는 비용은 0
        visited[start] = true;

        ArrayList<Node> nodes = graph.get(start);
        for (Node node : nodes) {
            d[node.getIndex()] = node.getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문처리
            int now = getSmallestNode();
            visited[now] = true;
            ArrayList<Node> nextNodes = graph.get(now);
            for (Node nextNode : nextNodes) {
                int cost = d[now] + nextNode.getDistance();
                if (cost < d[nextNode.getIndex()]) {
                    d[nextNode.getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 개수
        m = sc.nextInt(); // 간선의 개수
        start = sc.nextInt(); // 시작 노드

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c이다
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) { // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                System.out.println("INFINITY");
            } else { // 도달할 수 있는 경우 거리를 출력
                System.out.println(d[i]);
            }
        }
    }
}
