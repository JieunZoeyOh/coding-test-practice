package Basic.Part02.BinarySearch;

import java.util.*;

/**
 * p. 201
 * 떡볶이 떡 만들기
 */
public class Exam4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 떡볶이 개수
        int target = sc.nextInt(); // 요청한 떡볶이 길이

        int[] riceCakes = new int[n];
        for (int i = 0; i < n; i++) {
            riceCakes[i] = sc.nextInt();
        }

        sc.close();
        Arrays.sort(riceCakes);
        int start = 0;
        int end = riceCakes[n - 1]; // 최대값
        int height = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;
            for (int i = 0; i < n; i++) {
                int riceCake = riceCakes[i];
                if (riceCake > mid) {
                    total += riceCake - mid;
                }
            }

            if (total < target) { // 모자른 경우
                end = mid - 1;
            } else {
                height = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에 일단 기록
                start = mid + 1;
            }
        }

        System.out.println(height);
    }
}
