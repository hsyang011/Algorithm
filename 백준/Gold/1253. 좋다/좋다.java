import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기는 C언어로 푸는 사람들을 위한 것이므로 날려버립니다.
        br.readLine();
        // 입력을 받아 배열에 저장합니다.
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = 0;

        // 3중for문을 돌립니다. 다만 큰 그림을 보자면, 배열의 각각의 요소의 값을 꺼내기 위한 for문과,
        // 그 내부에서 모든 두 수의 합을 구하기 위한 2중for문을 돌립니다.
        for (int i=0; i<arr.length; i++) {
            boolean flag = true;
            // 좋은 수를 판별할 숫자를 꺼내옵니다.
            int currNum = arr[i];

            // 2중 for문으로 두 수의 합을 모두 구합니다.
            for (int j=0; j<arr.length; j++) {
                // 반복문의 탈출조건에 걸렸다면 빠져나옵니다.
                if (!flag) break;

                // arr[j]를 저장합니다.
                int n1 = arr[j];

                for (int k=j+1; k<arr.length; k++) {
                    int n2 = arr[k];

                    // 좋은 수를 판별합니다.
                    if (currNum == n1+n2 && i!=j && i!=k) {
                        answer++;
                        flag = false;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

}