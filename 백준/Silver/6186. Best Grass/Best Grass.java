import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 행(row)과 열(col)의 크기를 입력받습니다.
        String[] parts = br.readLine().split(" ");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);

        // 2차원 char 배열로 입력을 처리합니다.
        char[][] twoDimArr = br.lines()
                .limit(row) // 행의 개수 제한
                .map(String::toCharArray) // 문자열을 char[]로 변환
                .toArray(char[][]::new); // 2차원 배열로 변환

        // 방문 여부를 확인할 배열을 생성합니다.
        boolean[][] visited = new boolean[row][col];

        int cnt = 0; // 풀이 결과 값(풀이덩어리 개수)

        // 2차원 배열을 순회하면서 풀이덩어리를 찾습니다.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // '#'이고 방문하지 않은 위치라면 DFS를 수행합니다.
                if (twoDimArr[i][j] == '#' && !visited[i][j]) {
                    dfs(twoDimArr, visited, i, j, row, col);
                    cnt++; // 하나의 풀이덩어리를 찾았으므로 증가
                }
            }
        }

        // 결과를 출력합니다.
        System.out.println(cnt);
        br.close();
    }

    // DFS를 사용하여 연결된 모든 '#'을 방문 처리합니다.
    private static void dfs(char[][] map, boolean[][] visited, int x, int y, int row, int col) {
        // 방향 배열 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[x][y] = true; // 현재 위치를 방문 처리합니다.

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 배열 범위를 벗어나지 않고, '#'이며, 방문하지 않은 경우 재귀 호출합니다.
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] == '#' && !visited[nx][ny]) {
                dfs(map, visited, nx, ny, row, col);
            }
        }
    }
    
}