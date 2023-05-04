package Do_It;

import java.io.*;
import java.util.*;

/**
 * p. 74
 * 문제 010. 최솟값 찾기
 * 백준 11003 [최솟값 찾기]
 */
public class P11003_최솟값_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> myDeque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!myDeque.isEmpty() && myDeque.getLast().getValue() > now) {
                myDeque.removeLast();
            }
            myDeque.add(new Node(i, now));

            // 범위에서 벗어나면 제거
            if (myDeque.getFirst().getIndex() <= i - size) {
                myDeque.removeFirst();
            }

            sb.append(myDeque.getFirst().getValue()).append(" ");
        }

        System.out.println(sb);
    }

     static class Node {
        private final int index;
        private final int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        int getIndex() {
            return this.index;
        }

        int getValue() {
            return this.value;
        }
    }
}

