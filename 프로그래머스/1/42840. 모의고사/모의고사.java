import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        int[][] patterns = {
                { 1, 2, 3, 4, 5 },
                { 2, 1, 2, 3, 2, 4, 2, 5 },
                { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
        };

        // 수포자들을 저장할 배열
        int[] scores = new int[3];

        // 정답 배열을 모두 순회합니다.
        for (int i=0; i<arr.length; i++) {
            // 2차원 배열을 순회합니다.
            for (int j=0; j< patterns.length; j++) {
                // 배열의 인덱스 범위를 초과하지 않게 %연산자로 인덱스를 재구성합니다.
                if (arr[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 배열의 최대 점수를 먼저 구합니다.
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 최대 점수인 사람들을 담는 리스트를 생성합니다.
        List<Integer> list = new ArrayList<>();
        // score배열을 순회합니다. 그리고 maxScore인 사람들을 리스트에 담습니다.
        IntStream.range(0, scores.length)
                .forEach(i -> {
                    if (scores[i] == maxScore) {
                        list.add(i+1);
                    }
                });

        // 리스트를 정렬하고 배열로 변환하여 반환합니다.
        return list.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
}