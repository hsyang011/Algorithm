import java.util.*;

public class Main {
    // 체스판 크기, 시작 위치, 도착 위치를 저장합니다.
    static int l;
    static int startX, startY, endX, endY;

    // 나이트의 이동 방향을 정의합니다.
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수를 입력받습니다.

        for (int tc = 0; tc < t; tc++) {
            l = sc.nextInt(); // 체스판의 크기를 입력받습니다.
            startX = sc.nextInt(); // 시작 위치의 X 좌표를 입력받습니다.
            startY = sc.nextInt(); // 시작 위치의 Y 좌표를 입력받습니다.
            endX = sc.nextInt(); // 도착 위치의 X 좌표를 입력받습니다.
            endY = sc.nextInt(); // 도착 위치의 Y 좌표를 입력받습니다.

            // BFS로 최단 이동 횟수를 계산하고 출력합니다.
            System.out.println(bfs());
        }
        sc.close();
    }

    // 최단 이동 횟수를 계산합니다.
    static int bfs() {
        boolean[][] visited = new boolean[l][l]; // 방문 여부를 저장합니다.
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); // 시작 위치와 이동 횟수를 큐에 추가합니다.
        visited[startX][startY] = true; // 시작 위치를 방문 처리합니다.

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치와 이동 횟수를 꺼냅니다.
            int x = current[0], y = current[1], moves = current[2];

            // 도착 위치에 도달했는지 확인합니다.
            if (x == endX && y == endY) {
                return moves; // 이동 횟수를 반환합니다.
            }

            // 나이트의 8가지 이동 방향을 확인합니다.
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 체스판 범위 내에 있고, 방문하지 않은 위치인지 확인합니다.
                if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, moves + 1}); // 새로운 위치와 이동 횟수를 큐에 추가합니다.
                    visited[nx][ny] = true; // 방문 처리합니다.
                }
            }
        }
        return -1; // 도달할 수 없는 경우를 처리합니다.
    }
}
