import java.io.*;
import java.util.*;

public class Main {

    static class Problem {
        int p; // 문제번호
        int l; // 난이도

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 문제의 개수를 입력받습니다.

        // 문제의 난이도를 기준으로 문제를 관리하기 위한 TreeSet을 생성합니다.
        TreeSet<Problem> ts = new TreeSet<>((o1, o2) -> {
            if (o1.l == o2.l) { // 문제 난이도가 같다면
                return o1.p - o2.p; // 문제 번호가 작은 순서대로 정렬합니다.
            }
            return o1.l - o2.l; // 문제 난이도 오름차순으로 정렬합니다.
        });

        // 문제번호와 난이도의 쌍을 관리하기 위한 Map을 생성합니다.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" "); // 입력된 문제 번호와 난이도를 공백으로 구분하여 나눕니다.
            int p = Integer.parseInt(input[0]); // 문제 번호를 입력받습니다.
            int l = Integer.parseInt(input[1]); // 문제 난이도를 입력받습니다.
            Problem problem = new Problem(p, l);
            ts.add(problem); // 문제를 TreeSet에 추가합니다.
            map.put(p, l); // 문제번호와 난이도를 Map에 저장합니다.
        }

        int M = Integer.parseInt(br.readLine()); // 수행할 명령의 개수를 입력받습니다.
        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" "); // 명령을 공백으로 구분하여 나눕니다.
            switch (command[0]) {
            case "add":
                int p = Integer.parseInt(command[1]); // 추가할 문제 번호를 입력받습니다.
                int l = Integer.parseInt(command[2]); // 추가할 문제 난이도를 입력받습니다.
                Problem problem = new Problem(p, l);
                ts.add(problem); // 문제를 TreeSet에 추가합니다.
                map.put(p, l); // 문제번호와 난이도를 Map에 저장합니다.
                break;
            case "recommend":
                int num = Integer.parseInt(command[1]); // 추천할 문제의 난이도를 입력받습니다.
                if (num == 1) { // 가장 어려운 문제를 추천합니다.
                    System.out.println(ts.last().p); // TreeSet의 마지막 문제를 출력합니다.
                } else if (num == -1) { // 가장 쉬운 문제를 추천합니다.
                    System.out.println(ts.first().p); // TreeSet의 첫 번째 문제를 출력합니다.
                }
                break;
            case "solved":
                int s_p = Integer.parseInt(command[1]); // 해결한 문제의 번호를 입력받습니다.
                int s_l = map.get(s_p); // 문제의 난이도를 찾습니다.
                ts.remove(new Problem(s_p, s_l)); // 문제를 TreeSet에서 삭제합니다.
                break;
            default:
                break;
            }
        }
    }
}
