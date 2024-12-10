import java.io.*;
import java.util.*;

// Node 클래스는 x, y 좌표를 저장합니다.
class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;  // x 좌표를 초기화합니다.
        this.y = y;  // y 좌표를 초기화합니다.
    }
}

public class Main {
    static int testCases, width, height, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};  // 상하좌우 탐색을 위한 dx 배열입니다.
    static int[] dy = {-1, 1, 0, 0};  // 상하좌우 탐색을 위한 dy 배열입니다.
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCases = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수를 입력받습니다.
        
        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());  // 배추밭의 가로 길이를 입력받습니다.
            height = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이를 입력받습니다.
            K = Integer.parseInt(st.nextToken());      // 배추의 개수를 입력받습니다.
            
            // 문제에서 요구한 대로 배추밭 크기와 방문 여부 배열을 설정합니다.
            map = new int[height][width];  // 세로 크기, 가로 크기로 배열을 생성합니다.
            visited = new boolean[height][width];  // 방문 여부 배열을 생성합니다.
            
            // 배추의 위치를 입력받고 해당 위치에 1을 표시합니다.
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;  // 배추는 map[y][x] 위치에 있습니다. x, y 순서가 바뀌었음을 주의합니다.
            }
            
            int answer = 0;
            
            // 배추밭을 순회하며, 연결된 배추가 있으면 BFS를 시작합니다.
            for (int j = 0; j < height; j++) {  // 세로 방향으로 탐색합니다.
                for (int k = 0; k < width; k++) {  // 가로 방향으로 탐색합니다.
                    // 아직 방문하지 않은 배추가 있으면 BFS로 그 군집을 탐색합니다.
                    if (map[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k);  // BFS로 연결된 배추들을 모두 방문합니다.
                        answer++;    // 하나의 군집을 찾았으므로 배추흰지렁이 1마리가 필요합니다.
                    }
                }
            }
            
            // 각 테스트 케이스마다 결과를 출력합니다.
            System.out.println(answer);
        }
        
        br.close();  // BufferedReader를 닫습니다.
    }
    
    // BFS 탐색을 수행하는 함수입니다.
    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();  // 큐를 사용하여 BFS를 수행합니다.
        queue.add(new Node(x, y));  // 시작점을 큐에 넣고 방문 처리합니다.
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();  // 큐에서 현재 노드를 꺼냅니다.
            
            // 상하좌우 네 방향으로 탐색을 진행합니다.
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];  // 다음 x 좌표를 계산합니다.
                int ny = now.y + dy[i];  // 다음 y 좌표를 계산합니다.
                
                // 배추밭 범위를 벗어나지 않는지 체크합니다.
                if (nx >= 0 && ny >= 0 && nx < height && ny < width) {
                    // 아직 방문하지 않았고 배추가 있는 곳이라면
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new Node(nx, ny));  // 큐에 새로 발견한 배추를 넣습니다.
                        visited[nx][ny] = true;  // 방문 처리합니다.
                    }
                }
            }
        }
    }
}
