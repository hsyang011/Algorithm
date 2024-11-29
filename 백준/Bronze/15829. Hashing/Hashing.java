import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        // 입력받은 문자열을 chars()하여 IntStream을 생성하고 map()을 이용해서 배열의 요소의 값을 변경한 후 arr에 저장합니다.
        long[] arr = br.readLine().chars().mapToLong(c -> c - 'a' + 1).toArray();

        long sum = 0;
        long p = 31;
        long m = 1234567891;

        long power = 1; // 처음 31^0 = 1
        // 시그마 i=0부터 len-1까지 요소 X 31의 i제곱을 수행합시다.
        for (int i = 0; i < len; i++) {
            sum = (sum + arr[i] * power) % m; // 현재값에 power * arr[i] 값을 더하고 나머지 연산
            power = (power * p) % m; // power를 31^i로 누적 계산
        }

        System.out.println(sum);

        br.close();
    }
}
