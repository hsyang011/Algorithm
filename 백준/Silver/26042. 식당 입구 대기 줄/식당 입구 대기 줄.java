import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // 대기인원을 담을 큐를 사용합니다.
        Deque<Integer> deque = new ArrayDeque<>();
        // 최댓값을 찾기 위한 배열을 선언합니다. 각각 최대 인원, 번호를 뜻합니다.
        int[] arr = { -1, -1 };

        while (size--> 0) {
            String[] parts = br.readLine().split(" ");
            int numOfCase = Integer.parseInt(parts[0]);

            switch (numOfCase) {
                case 1:
                    int id = Integer.parseInt(parts[1]);
                    // 덱에 인원을 담습니다.
                    deque.offerLast(id);
                    // 만약 대기인원 수가 최대를 넘어서면 배열에 추가합니다.
                    if (deque.size() > arr[0]) {
                        arr[0] = deque.size();
                        arr[1] = deque.peekLast();
                    // 만약 최대 대기인원수가 같다면 조건을 부여합니다.
                    } else if (deque.size() == arr[0]) {
                        arr[1] = deque.peekLast() < arr[1] ? deque.peekLast() : arr[1];
                    }
                    break;
                case 2:
                    deque.pollFirst();
                    break;
            }
        }

        System.out.printf("%d %d\n", arr[0], arr[1]);

        br.close();
    }

}