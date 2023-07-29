package Do_It.그래프.그래프의표현;

import java.util.*;

/**
 * p. 260
 * 문제 046. 특정 거리의 도시 찾기
 * 백준 18352 [특정 거리의 도시 찾기]
 */
public class P18352_특정거리의도시찾기 {

    static int[] visited;
    static ArrayList<Integer>[] map;
    static int city, bridge, distance, start;
    static List<Integer> answers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        city = sc.nextInt(); //도시 개수
        bridge = sc.nextInt(); //도로 개수
        distance = sc.nextInt(); //최단 거리
        start = sc.nextInt(); //출발 도시 번호

        map = new ArrayList[city + 1];
        answers = new ArrayList<>();

        for (int i = 1; i <= city; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < bridge; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map[from].add(to);
        }
        sc.close();

        visited = new int[city + 1];
        for (int i = 0; i <= city; i++) {
            visited[i] = -1;
        }

        bfs(start);

        for (int i = 1; i <= city; i++) {
            if (visited[i] == distance) {
                answers.add(i);
            }
        }

        if (answers.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answers);
            answers.forEach(System.out::println);
        }

    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode]++;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int nextNode : map[currentNode]) {
                if (visited[nextNode] != -1) continue;
                visited[nextNode] = visited[currentNode] + 1;
                queue.add(nextNode);
            }
        }
    }
}
