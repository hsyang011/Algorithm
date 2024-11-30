import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());  // 입력된 숫자 개수
        StringBuilder result = new StringBuilder();

        // 최소 힙과 최대 힙을 생성합니다.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(reader.readLine());  // 입력된 숫자

            // 최대 힙이 비어 있거나 num이 최대 힙의 루트보다 작거나 같으면, 최대 힙에 num을 추가합니다.
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else { // num이 최대 힙의 루트보다 크면 최소 힙에 num을 추가합니다.
                minHeap.offer(num);
            }

            // 최대 힙의 크기가 최소 힙보다 2개 이상 클 경우, 최대 힙의 루트를 최소 힙으로 이동합니다.
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                // 최소 힙의 크기가 최대 힙보다 클 경우, 최소 힙의 루트를 최대 힙으로 이동합니다.
                maxHeap.offer(minHeap.poll());
            }

            // 중간값을 출력합니다.
            result.append(maxHeap.peek()).append("\n");
        }
        System.out.println(result);
    }
}
