import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력을 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 퀘스트 수와 활성화할 수 있는 아케인스톤 수를 입력받습니다.
        String[] parts = br.readLine().split(" ");
        int numOfQuest = Integer.parseInt(parts[0]);  // 퀘스트 수를 저장합니다.
        int numOfStone = Integer.parseInt(parts[1]);  // 활성화할 수 있는 아케인스톤 수를 저장합니다.

        // 각 퀘스트의 경험치를 저장할 배열을 생성합니다.
        // 중간연산인 sorted()를 활용하여 오름차순으로 정렬합니다.
        long[] exps = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        // 경험치의 합을 저장할 변수입니다.
        long answer = 0;

        // 스톤의 갯수까지는 경험치를 각 스톤에 고르게 나누어 담습니다.
        for (int i=0; i < numOfStone; i++) {
            answer += exps[i] * i;  // 작은 값부터 경험치를 분배합니다.
        }

        // 스톤의 갯수 이후부터는 모든 스톤에 동일하게 경험치를 나누어 담습니다.
        for (int i=numOfStone; i<numOfQuest; i++) {
            answer += exps[i] * numOfStone;  // 큰 값은 모두 numOfStone개의 스톤에 분배합니다.
        }

        // 결과를 출력합니다.
        System.out.println(answer);
        br.close();
    }

}