import java.io.*;
import java.util.*;

public class Main {

    // 2차원 배열을 선언합니다.
    static char[][] map;
    static boolean[][] visitMap;
    static int row, col;
    // 늑대와 양의 갯수를 저장할 변수를 선언합니다.
    static int nkdae, yang;
    // 정답으로 출력할 늑대와 양의 갯수를 저장할 변수를 선언합니다.
    static int ansNkdae = 0, ansYang = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 행과 열 크기 입력을 받습니다.
        String[] parts = br.readLine().split(" ");
        row = Integer.parseInt(parts[0]); // 행 갯수
        col = Integer.parseInt(parts[1]); // 열 갯수

        // 지도와 방문 배열을 초기화합니다.
        map = new char[row][col];
        visitMap = new boolean[row][col];

        // 지도 데이터를 입력받고 2차원 char 배열에 저장합니다.
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 지도에서 모든 칸을 순회하며 탐색합니다.
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                // 아직 방문하지 않았고, 양('k') 또는 늑대('v')인 칸을 찾습니다.
                if (!visitMap[y][x] && (map[y][x] == 'v' || map[y][x] == 'k')) {
                    // 탐색 전 초기화합니다.
                    nkdae = 0;
                    yang = 0;

                    // 해당 칸에서 탐색을 시작합니다.
                    explore(x, y);

                    // 각 구역에서의 양과 늑대 수를 비교하여 결과를 갱신합니다.
                    if (nkdae >= yang) {
                        ansNkdae += nkdae; // 늑대가 더 많거나 같으면 늑대 수를 추가합니다.
                    } else {
                        ansYang += yang; // 양이 더 많으면 양 수를 추가합니다.
                    }
                }
            }
        }

        // 결과를 출력합니다.
        System.out.printf("%d %d\n", ansYang, ansNkdae);
        br.close();
    }

    // 탐색 함수입니다. (DFS 방식)
    static void explore(int x, int y) {
        // 동서남북으로 이동할 수 있는 방향을 정합니다.
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        // 현재 위치를 방문 처리합니다.
        visitMap[y][x] = true;

        // 현재 위치에서 양과 늑대 수를 갱신합니다.
        if (map[y][x] == 'v') nkdae++; // 늑대 발견 시 늑대 수 증가
        if (map[y][x] == 'k') yang++; // 양 발견 시 양 수 증가

        // 네 방향으로 탐색을 수행합니다.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 범위 내에 있고, 방문하지 않았으며, 울타리가 없는 경우에만 탐색합니다.
            if (nx >= 0 && nx < col && ny >= 0 && ny < row && !visitMap[ny][nx] && map[ny][nx] != '#') {
                explore(nx, ny); // 재귀적으로 탐색합니다.
            }
        }
    }
}
