import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        // 입력받은 문자열을 chars()하여 IntStream을 생성하고 map()을 이용해서 배열의 요소의 값을 변경한 후 arr에 저장합니다.
        int[] arr = br.readLine().chars().map(c -> c-'a'+1).toArray();

        int sum = 0;
        // 시그마 i=0부터 len-1까지 요소 X 31의 i제곱을 수행합시다.
        for (int i=0; i<len; i++) {
            sum += arr[i] * (int)Math.pow(31, i);
        }

        System.out.println(sum);

        br.close();
    }

}