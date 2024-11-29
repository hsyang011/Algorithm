import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 공백이 구분된 문자열을 입력받아 스트림을 생성하고, IntStream으로 변환 후, 배열로 반환
        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int size = arr[0];
        int myHeight = arr[1];
        int numOftry = arr[2];

        // 우선순위 큐 생성, 다만 기본값은 최소힙이므로 최대힙으로 생성해줍니다.
        // 2로 나누기 때문에 소수가 나올 수 있어 Double타입으로 생성합니다.
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (size--> 0) {
            int height = Integer.parseInt(br.readLine());
            pq.offer(height);
        }

        int cnt = 0;
        while (numOftry > 0) {
            // 최대 거인의 크기를 찾습니다.
            // 최대 크기의 거인의 키를 찾아서 1/2 크기로 다시 오퍼합니다.
            int maxHeight = pq.peek();

            // 만약 거인의 키가 나보다 작다면 반복문을 빠져나옵니다.
            if (maxHeight<myHeight || maxHeight==1) {
                break;
            }
            pq.offer(pq.poll()/2);

            cnt++;
            numOftry--;

        }

        if (pq.peek() < myHeight) {
            System.out.printf("YES\n%d", cnt);
        } else {
            System.out.printf("NO\n%d", pq.peek());
        }

        br.close();
    }

}