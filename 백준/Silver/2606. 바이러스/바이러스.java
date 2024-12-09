import java.util.*;

public class Main {
    static int n, m; // 컴퓨터 수와 네트워크 연결 수를 저장합니다.
    static List<List<Integer>> graph = new ArrayList<>(); // 그래프를 저장합니다.
    static boolean[] visited; // 방문 여부를 저장합니다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 컴퓨터 수와 네트워크 연결 수를 입력받습니다.
        n = sc.nextInt();
        m = sc.nextInt();

        // 그래프 초기화 및 방문 배열 초기화를 수행합니다.
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        // 네트워크 연결 정보를 입력받아 그래프를 구성합니다.
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a); // 양방향 연결입니다.
        }

        // DFS를 통해 감염된 컴퓨터 수를 계산합니다.
        int infectedCount = dfs(1) - 1; // 자기 자신을 제외합니다.
        System.out.println(infectedCount);

        sc.close();
    }

    // DFS를 사용해 감염된 컴퓨터 수를 계산합니다.
    static int dfs(int node) {
        visited[node] = true; // 현재 노드를 방문 처리합니다.
        int count = 1; // 현재 노드도 감염된 수에 포함합니다.

        // 인접 노드를 순회하며 DFS를 수행합니다.
        for (int next : graph.get(node)) {
            if (!visited[next]) { // 방문하지 않은 노드만 처리합니다.
                count += dfs(next); // 감염된 컴퓨터 수를 누적합니다.
            }
        }

        return count; // 감염된 컴퓨터 수를 반환합니다.
    }
}
