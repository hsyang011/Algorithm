import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받음
        StringBuilder sb = new StringBuilder(br.readLine());
        int size = Integer.parseInt(br.readLine());

        // 커서의 위치를 나타내는 변수 선언
        int pointer = sb.length();

        for (int i=0; i<size; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("P")) {
                // 추가할 문자열을 가져옵니다.
                String addStr = cmd.split(" ")[1];
                // 해당 인덱스에 문자열을 추가하고 pointer을 증가시킵니다.
                sb.insert(pointer++, addStr);
            } else {
                switch (cmd) {
                    case "L":
                        if (pointer > 0) pointer--;
                        break;
                    case "D":
                        if (pointer < sb.length()) pointer++;
                        break;
                    case "B":
                        if (pointer > 0) {
                            sb.replace(pointer-1, pointer, "");
                            pointer--;
                        } else if (pointer == 0) {

                        }
                        break;
                }
            }
        }

        System.out.println(sb);

        // 자원 반납
        br.close();
    }

}