import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int size = Integer.parseInt(parts[0]);
        int jump = Integer.parseInt(parts[1]);
        // 정답으로 선언할 변수를 생성합니다.
        StringBuilder sbAnswer = new StringBuilder();
        sbAnswer.append("<");

        // 링크드리스트로 생성합니다.
        List<Integer> list = IntStream.range(1, size+1)
                        .boxed()
                        .collect(Collectors.toCollection(LinkedList::new));

        // 현재 포인터의 위치를 나타내는 변수를 선언합니다.
        int pointer = -1;
        // 리스트가 빌 때까지 반복합니다.
        while (!list.isEmpty()) {
            // 포인터의 위치를 포인터+jump를 통해 이동시키고,
            // 리스트의 크기를 넘어가게 하지 않기 위해 % 연산을 수행합니다.
            pointer = (pointer+jump) % list.size();

            int outputNum = list.remove(pointer);
            pointer--;

            if (!list.isEmpty()) {
                sbAnswer.append(outputNum).append(", ");
            } else {
                sbAnswer.append(outputNum).append(">");
            }
        }

        System.out.println(sbAnswer);

        br.close();
    }

}