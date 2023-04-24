package Basic.Part02.BinarySearch;

import java.util.*;

/**
 * p. 186
 * 순차 탐색
 */
public class Exam1_SequentialSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
        int n = sc.nextInt();
        String target = sc.next();

        int findIndex = -1;
        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        for (int i = 0; i < n; i++) {
            String inputValue = sc.next();
            if (target.equals(inputValue)) {
                findIndex = i;
            }
        }

        sc.close();

        if (findIndex == -1) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(findIndex + 1);
        }

    }
}
