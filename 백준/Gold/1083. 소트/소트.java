import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기와 내용을 입력받습니다.
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 스왑 가능한 횟수를 입력받습니다.
        int numOfSwap = Integer.parseInt(br.readLine());

        for (int i=0; i<n && numOfSwap>0; i++) {
            // 현재 위치에서 남은 스왑 횟수 내에서 최대 값을 찾습니다.
            int maxIdx = i;
            for (int j=i+1; j<n && j<=i+numOfSwap; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j; // 최대값의 인덱스를 갱신합니다.
                }
            }

            // 최대값을 현재 위치로 이동합니다.
            for (int j=maxIdx; j>i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                numOfSwap--; // 스왑 횟수를 줄입니다.
            }

            // 남은 스왑 횟수가 0이면 루프를 종료합니다.
            if (numOfSwap == 0) break;
        }

        // 결과를 출력합니다.
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        br.close();
    }
    
}