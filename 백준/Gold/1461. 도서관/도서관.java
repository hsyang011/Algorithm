import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 책의 개수와 들 수 있는 용량을 입력받습니다.
        String[] parts = br.readLine().split(" ");
        int numOfBook = Integer.parseInt(parts[0]);
        int capacity = Integer.parseInt(parts[1]);

        // 두 번째 줄에서 책들의 위치를 정수 배열로 입력받습니다.
        int[] books = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 음수와 양수를 분리합니다.
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        for (int book : books) {
            if (book < 0) negatives.add(Math.abs(book));
            else positives.add(book);
        }

        // 절댓값 기준 내림차순으로 정렬합니다.
        negatives.sort(Collections.reverseOrder());
        positives.sort(Collections.reverseOrder());

        long totalDistance = 0;
        int maxDistance = 0;

        // 음수 그룹을 처리합니다. i값은 capacity만큼 증가시키면서 반복합니다.
        for (int i = 0; i < negatives.size(); i += capacity) {
            int currentDistance = negatives.get(i); // 가장 먼 거리를 가져옵니다.
            totalDistance += currentDistance * 2;   // 왕복 거리를 추가합니다.
            maxDistance = Math.max(maxDistance, currentDistance); // 최대 거리를 갱신합니다.
        }

        // 양수 그룹을 처리합니다. i값은 capacity만큼 증가시키면서 반복합니다.
        for (int i = 0; i < positives.size(); i += capacity) {
            int currentDistance = positives.get(i); // 가장 먼 거리를 가져옵니다.
            totalDistance += currentDistance * 2;   // 왕복 거리를 추가합니다.
            maxDistance = Math.max(maxDistance, currentDistance); // 최대 거리를 갱신합니다.
        }

        // 모든 이동거리에서 최대 이동거리를 뺀 후 출력합니다.
        System.out.println(totalDistance - maxDistance);
    }
    
}