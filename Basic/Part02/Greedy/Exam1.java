package Basic.Part02.Greedy;

/**
 * 당장 좋은 것만 선택하는 그리디
 * p. 87
 * 예제 3-1. 거스름돈
 * 당신은 음식점의 계산을 도와주는 점원이다. 카운터에는 거스름돈으로 사용할
 * 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다.
 * 손님에게 거슬러 줘야 할 돈이 N원일 때
 * 거슬러 줘야 할 동전의 최소 개수를 구해라.
 * 단, 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
 */
public class Exam1 {
    public static void main(String[] args) {
        int[] coins = {500, 100, 50, 10};

        int n = 1260;
        int count = 0;

        for (int coin : coins) {
            count += n / coin;
            n %= coin;
        }

        System.out.println("count = " + count);
    }
}
