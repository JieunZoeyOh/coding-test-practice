package Basic.Part02.Sort;

import java.util.*;

public class Test1_UpToDown_v3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 기본 정렬 라이브러리를 이용하여 내림차순 정렬 수행
        Arrays.sort(arr, Collections.reverseOrder());

        for (Integer element : arr) {
            System.out.print(element + " ");
        }
    }
}
