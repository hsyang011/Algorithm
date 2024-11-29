import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // 우선순위큐를 최대힙으로 생성합니다.
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 사이즈 만큼 반복합니다.
        while (size--> 0) {
            // 문자열을 배열로 받습니다.
            String[] parts = br.readLine().split(" ");

            // 만약 0을 입력받았다면 비어있을 때 -1, 있을 때 최댓값을 꺼내옵니다.
            if (parts[0].equals("0")) {
                if (pq.isEmpty()) System.out.println(-1);
                else System.out.println(pq.poll());
            } else {
                // 길이를 저장합니다.
                int len = Integer.parseInt(parts[0]);
                // 우선순위 큐에 오퍼합니다.
                for (int i=0; i<len; i++) {
                    pq.offer(Integer.parseInt(parts[i+1]));
                }
            }
        }

        br.close();
    }

}