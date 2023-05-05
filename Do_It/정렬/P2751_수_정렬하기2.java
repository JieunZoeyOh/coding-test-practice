package Do_It.정렬;

import java.io.*;

/**
 * p. 128
 * 문제 020. 수 정렬하기2
 * 백준 2751 [수 정렬하기]
 * N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
 */
public class P2751_수_정렬하기2 {
    public static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        temp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        mergeSort(1, n); // 병합정렬 수행하기
        for (int i = 1; i <= n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) return;

        int middle = start + ((end - start) / 2);

        // 재귀 함수 형태로 구현
        mergeSort(start, middle);
        mergeSort(middle + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int k = start;
        int first = start;
        int second = middle + 1;
        while (first <= middle && second <= end) {
            // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
            // 선택된 데이터의 index값을 오른쪽으로 한 칸 이동하기
            if (temp[first] > temp[second]) {
                arr[k] = temp[second];
                k++;
                second++;
            } else {
                arr[k] = temp[first];
                k++;
                first++;
            }
        }
        // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
        while (first <= middle) {
            arr[k] = temp[first];
            k++;
            first++;
        }
        while (second <= end) {
            arr[k] = temp[second];
            k++;
            second++;
        }
    }
}
