import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    /*

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수를 문자열로 받음
        String numStr = br.readLine();


        int cnt = 0;
        // 한 자리 수가 될 때까지 반복
        while (numStr.length() > 1) {
            int sum = 0;
            char[] numArr = numStr.toCharArray();

            // 배열 순회
            for (int i=0; i<numArr.length; i++) {
                sum += numArr[i]-'0';
            }

            // 합계를 numStr에 저장
            numStr = Integer.toString(sum);
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(Integer.parseInt(numStr) % 3 == 0 ? "YES" : "NO");

        br.close();
    }

}