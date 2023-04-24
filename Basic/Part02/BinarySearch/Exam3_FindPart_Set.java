package Basic.Part02.BinarySearch;

import java.util.*;

/**
 * p. 197
 * 부품 찾기
 * Set을 이용하여 문제 해결
 */
public class Exam3_FindPart_Set {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 집합(Set) 정보를 처리하기 위한 HashSet 라이브러리
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        int m = sc.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = sc.nextInt();
        }

        sc.close();

        for (int i = 0; i < m; i++) {
            if (s.contains(mArr[i])) {
                System.out.print("YES ");
            } else {
                System.out.print("NO ");
            }
        }
    }

}
