import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());


        // 3차원 배열로 선언합니다.
        // 한 주가 4x7에 해당되므로 size 주는 sizex4x7입니다.
        String[][][] dp = new String[size][4][7];
        for (int i=0; i<size; i++) {
            for (int j=0; j<4; j++) {
                // 한 줄을 입력 받아 공백으로 구분하여 배열로 변환합니다.
                String[] days = reader.readLine().split(" ");
                for (int k=0; k<7; k++) {
                    dp[i][j][k] = days[k];
                }
            }
        }

        // 각 근무자의 근무시간을 기록하기 위해 Map 컬렉션을 생성합니다.
        Map<String, Integer> timeTable = new HashMap<>();

        // 3차원 배열을 순회합니다.
        for (int i=0; i<size; i++) {
            for (int j=0; j<4; j++) {
                for (int k=0; k<7; k++) {
                    // 근무자 명을 저장합니다.
                    String name = dp[i][j][k];
                    // 근무자가 존재할 경우에만 다음 로직을 수행합니다.
                    if (!name.equals("-")) {
                        // 몇 시간 근무했는지 알아내기 위해 j값을 가져옵니다.
                        int time = 0;
                        // j값을 이용하여 switch-case문으로 분기합니다.
                        switch (j) {
                            // 아침 조에 해당되면 4시간 근무입니다.
                            case 0: time = 4; break;
                            // 점심 조에 해당되면 6시간 근무입니다.
                            case 1: time = 6; break;
                            // 저녁 조에 해당되면 4시간 근무입니다.
                            case 2: time = 4; break;
                            // 심야 조에 해당되면 10시간 근무입니다.
                            case 3: time = 10; break;
                        }

                        // 이제 근무기록을 작성합니다.
                        // timeTable에 작성된 이력이 없다면 새로이 작성합니다.
                        // 또는 기존의 근무시간에 오늘의 근무시간을 추가합니다.
                        timeTable.put(name, timeTable.getOrDefault(name, 0) + time);
                    }
                }
            }
        }

        // 여기까지 완료했다면 dp테이블을 이용하여 Map 컬렉션인 timeTable의 작성이 완료되었습니다.
        // 이제 근무표가 공평한지 여부를 검증할 때 입니다.
        // 최대 근무자와 최소 근무자가 12시간 이하로 차이나면 Yes, 그렇지 않은 경우 No 입니다.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // timeTable에 담긴 모든 값을 가져와 대소 비교를 수행합니다.
        for (int time : timeTable.values()) {
            max = Math.max(max, time);
            min = Math.min(min, time);
        }

        // 삼항연산자를 이용해서 answer에 값을 할당합니다.
        String answer = max-min <= 12 ? "Yes" : "No";
        System.out.println(answer);

        reader.close();
    }

}