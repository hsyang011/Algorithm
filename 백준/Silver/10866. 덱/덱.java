import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        // 덱을 생성합니다.
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i=0; i<size; i++) {
            String[] inputArr = reader.readLine().split(" ");
            String commandMsg = inputArr[0];

            int num = 0;
            switch (commandMsg) {
                case "push_front":
                    num = Integer.parseInt(inputArr[1]);
                    dq.offerFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(inputArr[1]);
                    dq.offerLast(num);
                    break;
                case "pop_front":
                    num = dq.isEmpty() ? -1 : dq.pollFirst();
                    System.out.println(num);
                    break;
                case "pop_back":
                    num = dq.isEmpty() ? -1 : dq.pollLast();
                    System.out.println(num);
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    System.out.println(dq.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    num = dq.isEmpty() ? -1 : dq.peekFirst();
                    System.out.println(num);
                    break;
                case "back":
                    num = dq.isEmpty() ? -1 : dq.peekLast();
                    System.out.println(num);
                    break;

            }
        }
    }

}