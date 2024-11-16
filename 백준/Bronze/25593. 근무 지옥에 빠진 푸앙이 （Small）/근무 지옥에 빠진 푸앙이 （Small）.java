import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 입력받을 주 수
        int size = Integer.parseInt(reader.readLine());

        // 3차원 배열 dp 선언
        String[][][] dp = new String[size][4][7];

        // 근무표 입력 받기
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 4; j++) {
                String[] days = reader.readLine().split(" ");
                for (int k = 0; k < 7; k++) {
                    dp[i][j][k] = days[k];
                }
            }
        }

        // 근무시간을 기록할 맵
        Map<String, Integer> timeTable = new HashMap<>();

        // 3차원 배열 dp 순회하여 근무시간 계산
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 7; k++) {
                    String name = dp[i][j][k];

                    if (!name.equals("-")) { // 근무자가 있을 경우
                        // 근무시간을 j에 따라 계산
                        int time = 0;
                        switch (j) {
                            case 0: time = 4; break; // 아침조
                            case 1: time = 6; break; // 점심조
                            case 2: time = 4; break; // 저녁조
                            case 3: time = 10; break; // 심야조
                        }

                        // 맵에 근무시간 추가
                        timeTable.put(name, timeTable.getOrDefault(name, 0) + time);
                    }
                }
            }
        }

        // 맵에서 근무시간 최댓값과 최솟값을 구하기
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int time : timeTable.values()) {
            max = Math.max(max, time);
            min = Math.min(min, time);
        }

        // 결과 출력
        String answer = (max - min <= 12) ? "Yes" : "No";
        System.out.println(answer);

        reader.close();
    }
}
