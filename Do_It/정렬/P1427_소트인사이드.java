package Do_It.정렬;

import java.util.*;

/**
 * p. 109
 * 문제 017. 내림차순으로 자릿수 정렬하기
 * 백준 1427 [소트인사이드]
 * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */
public class P1427_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();

        char[] arr = String.valueOf(number).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char max = arr[i];
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    idx = j;
                }
            }
            if (idx == i) continue;
            char temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        System.out.println(String.valueOf(arr));
    }
}
