import java.io.*;
import java.util.*;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 크기는 읽기만 하고 저장하지 않습니다.
        br.readLine();
        String[] input = br.readLine().split(" ");

        // 입력 배열을 정수 배열로 변환합니다.
        int[] original = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            original[i] = Integer.parseInt(input[i]);
        }

        // 원본 배열 복사 및 정렬합니다.
        int[] sorted = original.clone();
        Arrays.sort(sorted);
        // 또한 스트림으로도 정렬이 가능합니다.
//        int[] sorted2 = Arrays.stream(original).sorted().toArray();

        // 좌표 압축을 위한 순위 맵을 생성합니다.
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // forEach를 통해서 코드를 한 줄로 줄이려고 했으나, IntConsumer를 구현하는 과정에서 try-catch문을 사용해야하기에
        // 그냥 주석처리하고 for문으로 처리합니다.
//        Arrays.stream(original).forEach(num -> {
//            try {
//                bw.write(rankMap.get(num) + " ");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });

        // 원본 배열 순서대로 결과를 생성하고 출력합니다.
        for (int num : original) {
            bw.write(rankMap.get(num) + " ");
        }

        // 출력 버퍼를 비웁니다.
        bw.flush();
        br.close();
        bw.close();
    }
    
}