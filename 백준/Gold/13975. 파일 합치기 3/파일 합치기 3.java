import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스를 받은 후 반복을 돌립니다.
        int size = Integer.parseInt(br.readLine());
        while (size--> 0) {
            // 배열의 길이를 저장합니다.
            int len = Integer.parseInt(br.readLine());
            // 입력된 문자열을 문자열배열로 받아 스트림을 생성합니다.
            // 중간연산 map으로 형변환을 해주고, 최종연산 collect를 통해 PriorytyQueue타입으로 생성합니다.
            Queue<Long> priorityQueue = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toCollection(PriorityQueue::new));

            // 누적합계를 저장할 변수입니다.
            long sum = 0;

            while (priorityQueue.size() > 1) {
                long file1 = priorityQueue.poll();
                long file2 = priorityQueue.poll();;
                sum += file1+file2;
                priorityQueue.offer(file1+file2);
            }

            System.out.println(sum);

        }

        br.close();
    }

}