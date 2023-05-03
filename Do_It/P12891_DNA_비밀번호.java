package Do_It;

import java.util.*;
import java.io.*;

/**
 * p. 67
 * 문제 009. DNA 비밀번호
 * 백준 12891 [DNA 비밀번호]
 */
public class P12891_DNA_비밀번호 {
    public static int cA, cC, cG, cT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dnaLength = Integer.parseInt(st.nextToken());
        int partLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String dna = st.nextToken();
        char[] dnaArr = dna.toCharArray();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        br.close();

        int start = 0, end = partLength - 1, count = 0;
        cA = 0; cC = 0; cG = 0; cT = 0;

        // 초기 값 세팅
        for (int i = 0; i < partLength; i++) {
            add(dnaArr[i]);
        }
        if (cA >= A && cC >= C && cG >= G && cT >= T) count++;

        while (++end < dnaLength) {
            add(dnaArr[end]);
            remove(dnaArr[start++]);
            if (cA >= A && cC >= C && cG >= G && cT >= T) count++;
        }

        System.out.println(count);
    }

    public static void add(char word) {
        if (word == 'A') cA += 1;
        else if (word == 'C') cC += 1;
        else if (word == 'G') cG += 1;
        else if (word == 'T') cT += 1;
    }

    public static void remove(char word) {
        if (word == 'A') cA -= 1;
        else if (word == 'C') cC -= 1;
        else if (word == 'G') cG -= 1;
        else if (word == 'T') cT -= 1;
    }
}
