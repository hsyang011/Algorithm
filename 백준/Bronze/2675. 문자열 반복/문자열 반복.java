import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        for (int i=0; i<num; i++) {
            String line = reader.readLine();
            String[] parts = line.split(" ");

            // IndexOutOfRange예외가 떨어지지 않도록
            // 길이가 2일 때만 0, 1번 인덱스를 참조하게 설계합니다.
            if (parts.length == 2) {
                String result = parsing(Integer.parseInt(parts[0]), parts[1]);

                // 파싱완료된 문자열을 출력합니다.
                System.out.println(result);
            }
        }

    }

    static String parsing(int num, String str) {
        // 문자열을 문자배열로 변환합니다.
        char[] cArr = str.toCharArray();

        // 반환할 문자열을 StringBuilder로 생성합니다.
        StringBuilder sb = new StringBuilder();
        
        
        for (int i=0; i<cArr.length; i++) {
            for (int j=0; j<num; j++) {
                sb.append(cArr[i]);
            }
        }

        return sb.toString();
    }

}