import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // 각각의 테스트케이스마다 명령을 처리합니다.
        // 덱을 생성합니다.
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0; i<size; i++) {
            // 명령어를 입력받습니다.
            String inputCmd = br.readLine();

            // 명령어가 push로 시작할 경우 split을 진행하고, 그 외의 경우는 명령어 처리를 수행합니다.
            if (inputCmd.startsWith("push")) {
                int num = Integer.parseInt(inputCmd.split(" ")[1]);
                dq.offerLast(num);
            } else {
                switch (inputCmd) {
                    case "pop":
                        System.out.println(!dq.isEmpty() ? dq.pop() : -1);
                        break;
                    case "size":
                        System.out.println(dq.size());
                        break;
                    case "empty":
                        System.out.println(dq.isEmpty() ? 1 : 0);
                        break;
                    case "front":
                        System.out.println(!dq.isEmpty() ? dq.peekFirst() : -1);
                        break;
                    case "back":
                        System.out.println(!dq.isEmpty() ? dq.peekLast() : -1);
                        break;
                }
            }
        }

        // 자원 반납
        br.close();
    }

}