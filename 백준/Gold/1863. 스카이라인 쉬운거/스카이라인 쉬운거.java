import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        // 건물들의 높이를 담을 덱을 생성합니다.
        Deque<Integer> deque = new ArrayDeque<>();
        // 정답을 도출할 변수를 선언합니다.
        int sum = 0;

        while (size--> 0) {
            int y = Integer.parseInt(br.readLine().split(" ")[1]);
            // 횡스크롤 마리오 게임을 생각해보았을 때 마리오 시점에서 보면 이해가 빠를 것 같습니다.
            // 현재 높이가 덱의 top보다 낮아지면 덱에서 값을 빼며 처리합니다.
            while (!deque.isEmpty() && deque.peekLast() > y) {
                deque.pollLast();
                sum++; // 스카이라인 구간 종료
            }

            // 덱에 같은 높이가 없으면 새로운 스카이라인 시작된 것으로 간주합니다.
            if (y>0 && (deque.isEmpty() || deque.peekLast() < y)) {
                deque.offerLast(y);
            }
        }

        // 입력의 끝을 마주하면 덱에 담겨져 있던 서로 다른 높이의 수를 sum에 누적합니다.
        sum += deque.size();
        System.out.println(sum);

        br.close();
    }

}