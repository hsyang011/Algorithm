import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        // Map컬렉션을 생성하여 플레이보드를 저장합니다.
        Map<String, Integer> board = new HashMap<>();

        for (int i=0; i<size; i++) {
            String[] inputs = reader.readLine().split(" ");
            String fruit = inputs[0];
            int cnt = board.getOrDefault(fruit, 0) + Integer.parseInt(inputs[1]);
            
            board.put(fruit, cnt);
        }

        if (board.containsValue(5)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        reader.close();
    }

}