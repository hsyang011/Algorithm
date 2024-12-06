import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        while (size-- > 0) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            // 공통 조상 찾기
            while (a != b) {
                if (a > b) a /= 2;
                else b /= 2;
            }

            // 공통 조상에 10을 곱하여 출력
            System.out.println(a * 10);
        }

        br.close();
    }
}
