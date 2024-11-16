import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Character> charDq = new ArrayDeque<>();
        Stack<Boolean> boolSt = new Stack<>();

        while (n-- > 0) {
            String input = br.readLine();
            char op = input.charAt(0);

            if (op == '1') {
                charDq.offerLast(input.charAt(2));
                boolSt.push(true);
            } else if (op == '2') {
                charDq.offerFirst(input.charAt(2));
                boolSt.push(false);
            } else if (!charDq.isEmpty()) {
                if (boolSt.pop()) charDq.removeLast();
                else charDq.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : charDq)
            sb.append(c);

        bw.write(sb.length() > 0 ? sb.toString() : "0");
        bw.flush();
    }
}