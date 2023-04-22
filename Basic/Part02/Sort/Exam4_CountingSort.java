package Basic.Part02.Sort;

/**
 * p. 171
 * 계수 정렬
 * 데이터의 크기가 한정되어 있고, 데이터의 크기가 많이 중복되어 있을수록 유리하며, 항상 사용할 수는 없다.
 * 데이터의 개수가 N, 데이터(양수) 중 최대값이 K일 때 최악의 경우에도 수행 시간 O(N + K)를 보장한다.
 */
public class Exam4_CountingSort {

    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        int n = 15;

        // 모든 원소의 값이 0보다 크거나 같다고 가정
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

        // 모든 범위를 포함하는 배열 선언(모든 값은 0으로 초기화)
        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]] += 1; // 각 데이터에 해당하는 인덱스의 값 증가
        }

        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
