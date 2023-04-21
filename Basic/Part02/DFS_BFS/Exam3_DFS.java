package Basic.Part02.DFS_BFS;

import java.util.ArrayList;

/**
 * p.134~142
 * DFS 예제
 * DFS(Depth-First Search), 깊이 우선 탐색이라고도 부르며,
 * 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘이다.
 * DFS는 스택 자료구조를 이용한다.
 * 일반적으로 인접한 노드 중에서 방문하지 않은 노드가 여러 개 있으면 번호가 낮은 순서부터 처리한다.
 */
public class Exam3_DFS {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // DFS 함수 정의
    public static void dfs(int currentNode) {
        // 현재 노드를 방문 처리
        visited[currentNode] = true;
        System.out.print(currentNode + " ");

        for (int i = 0; i < graph.get(currentNode).size(); i++) {
            int nextNode = graph.get(currentNode).get(i);
            if (!visited[nextNode]) dfs(nextNode);
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }

        // 0은 사용 X

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }
}
