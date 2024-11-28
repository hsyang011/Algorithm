import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 크기를 입력받습니다.
        int size = Integer.parseInt(br.readLine());
        // 입력받은 문장을 정수형 배열로 변환하여 저장합니다.
        int[] balloons = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 덱배열을 생성합니다.
        // size만큼 반복하여 인덱스 번호와 풍선의 값이 담긴 배열을 생성하여 덱배열에 추가합니다.
        Deque<int[]> balloonsDQ = IntStream.range(0, size)
                .mapToObj(i -> new int[] {i, balloons[i]})
                .collect(Collectors.toCollection(ArrayDeque::new));

        int arr[] = balloonsDQ.poll();
        int idx = arr[0], val = arr[1];
        System.out.print(idx+1 + " ");
        // 덱이 비어있지 않을동안 반복합니다.
        while (!balloonsDQ.isEmpty()) {
            if (val > 0) {
                while (val > 0) {
                    val--;
                    int[] tmp = balloonsDQ.pollFirst();
                    if (val > 0) {
                        balloonsDQ.offerLast(tmp);
                    } else {
                        if (!balloonsDQ.isEmpty()) val = tmp[1];
                        System.out.print(tmp[0]+1 + " ");
                    }
                }
            } else if (val < 0) {
                while (val < 0) {
                    val++;
                    int[] tmp = balloonsDQ.pollLast();
                    if (val < 0) {
                        balloonsDQ.offerFirst(tmp);
                    } else {
                        if (!balloonsDQ.isEmpty()) val = tmp[1];
                        System.out.print(tmp[0]+1 + " ");
                    }
                }
            }


        }

        // 자원 반납
        br.close();
    }

}