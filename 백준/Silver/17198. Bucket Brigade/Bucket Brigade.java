import java.util.*;

public class Main {
    // 상, 하, 좌, 우 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] farm = new char[10][10];
        int[] lake = new int[2]; // 호수(L)의 위치
        int[] barn = new int[2]; // 헛간(B)의 위치
        int[] rock = new int[2]; // 바위(R)의 위치

        // 입력 받기
        for (int i = 0; i < 10; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < 10; j++) {
                farm[i][j] = row.charAt(j);
                if (farm[i][j] == 'L') {
                    lake[0] = i;
                    lake[1] = j;
                } else if (farm[i][j] == 'B') {
                    barn[0] = i;
                    barn[1] = j;
                } else if (farm[i][j] == 'R') {
                    rock[0] = i;
                    rock[1] = j;
                }
            }
        }

        // BFS를 사용하여 최소 경로를 구합니다.
        int result = findMinimumCows(farm, lake, barn);
        System.out.println(result); // 최소 소의 수 출력
    }

    static int findMinimumCows(char[][] farm, int[] lake, int[] barn) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[10][10]; // 방문 여부 배열

        // 호수(L) 근처에서 시작합니다.
        for (int i = 0; i < 4; i++) {
            int nx = lake[0] + dx[i];
            int ny = lake[1] + dy[i];
            if (isValid(nx, ny, farm, visited)) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, 1}); // 물을 전달할 수 있는 첫 번째 칸은 1개의 소
            }
        }

        // BFS 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], cows = current[2];

            // 헛간(B) 근처에 도달했을 때
            if (isAdjacentToBarn(x, y, barn)) {
                return cows;
            }

            // 4방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isValid(nx, ny, farm, visited)) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cows + 1});
                }
            }
        }
        
        return -1; // 도달할 수 없으면 -1 반환
    }

    // 유효한 좌표인지 확인하는 함수
    static boolean isValid(int x, int y, char[][] farm, boolean[][] visited) {
        return x >= 0 && x < 10 && y >= 0 && y < 10 && farm[x][y] != 'R' && !visited[x][y];
    }

    // 헛간(B)와 인접한지 확인하는 함수
    static boolean isAdjacentToBarn(int x, int y, int[] barn) {
        return Math.abs(x - barn[0]) + Math.abs(y - barn[1]) == 1;
    }
}
