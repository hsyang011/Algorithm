import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에 입력된 문자열을 문자열배열에 저장합니다.
        String[] phoneArr = reader.readLine().split(" ");
        // 조건으로 사용될 문자열로 저장합니다.
        String condition = reader.readLine();

        // 조건에 맞는 전화번호의 갯수를 출력할 변수를 선언합니다.
        int answer = 0;
        for (String phone : phoneArr) {
            // condition과 다르고, condition으로 시작하면 answer를 카운트합니다.
            if (!phone.equals(condition) && phone.startsWith(condition)) {
                answer++;
            }
        }

        System.out.println(answer);

    }

}