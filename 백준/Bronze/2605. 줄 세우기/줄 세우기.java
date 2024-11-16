import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(reader.readLine());

        // 문자열배열로 Stream<String>형으로 생성 후, IntStream으로 변환한 후에 다시 배열로 변환합니다.
        int[] inputArr = Arrays.stream(reader.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // 중간 요소에 자주 삽입할 예정이기에 ArrayList대신 LinkedList를 사용합니다.
        List<Integer> orderList = new LinkedList<>();

        // add(index, value)를 이용하여 인덱스에 값을 삽입합니다.
        // 중간인덱스에 값을 삽입하면 그 뒤에 있는 요소들은 자동으로 +1씩 밀려나는 것을 이용합니다.
        for (int i=0; i<size; i++) {
            int idx = i-inputArr[i];
            orderList.add(idx, i+1);
        }

        // writer에 출력할 문자열을 담습니다.
        for (int order : orderList) {
            writer.write(order + " ");
        }

        writer.flush();
        reader.close();
        writer.close();

    }

}