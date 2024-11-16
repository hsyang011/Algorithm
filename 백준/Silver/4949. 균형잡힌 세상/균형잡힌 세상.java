import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            String line = reader.readLine();

            // .만 입력되면 종료되어 while문을 빠져나옵니다.
            if (line.equals(".")) {
                break;
            }

            if (isBalanced(line)) {
                result.append("yes\n");
            } else {
                result.append("no\n");
            }
        }

        System.out.print(result);
    }

    public static boolean isBalanced(String line) {
        // 데크를 생성합니다.
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : line.toCharArray()) {
            // 여는 괄호는 스택에 추가합니다.
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            // 닫는 괄호는 스택에서 확인합니다.
            else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // 스택이 비었거나 짝이 안 맞음
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false; // 스택이 비었거나 짝이 안 맞음
                }
            }
        }

        // 모든 여는 괄호가 짝을 맞췄는지 확인합니다.
        return stack.isEmpty();
    }
}
