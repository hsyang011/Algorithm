import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        
        if (input.isEmpty()) {
            System.out.println(0); // 빈 문자열이면 단어 개수는 0개
        } else {
            System.out.println(input.split(" ").length);
        }
    }
}
