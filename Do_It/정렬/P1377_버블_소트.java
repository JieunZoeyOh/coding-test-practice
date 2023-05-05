package Do_It.정렬;

import java.io.*;
import java.util.*;

/**
 * p. 104
 * 문제 016. 버블 소트 프로그램 1
 * 백준 1377 [버블 소트]
 */
public class P1377_버블_소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Bubble[] arr = new Bubble[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Bubble(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);

        int max = -1;
        for (int idx = 0; idx < n; idx++) {
            int before = arr[idx].getIndex();
            if (max < before - idx ) max = before - idx;
        }

        System.out.println(max + 1);
    }

    static class Bubble implements Comparable<Bubble> {
        private final int index;
        private final int value;

        public Bubble(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() { return index; }
        public int getValue() { return value; }

        @Override
        public int compareTo(Bubble o) {
            return this.getValue() - o.getValue();
        }

    }
}
