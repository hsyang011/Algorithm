import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = reader.readLine().split(" ");

        // 입력이 정상적으로 들어왔는지 검증합니다.
        if (inputArr.length == 2) {
            // 불변객체인 String에서는 reverse()를 사용할 수 없으므로 StringBuilder로 변환합니다.
            int a = Integer.parseInt(new StringBuilder(inputArr[0]).reverse().toString());
            int b = Integer.parseInt(new StringBuilder(inputArr[1]).reverse().toString());

            System.out.println(a > b ? a : b);
        }
    }
}