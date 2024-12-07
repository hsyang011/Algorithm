import java.util.*;

public class Main {
    static int[] visited;  // 각 정점의 방문 순서를 기록합니다.
    static List<Integer>[] adjList;  // 인접 리스트(그래프)를 저장합니다.
    static int order = 1;  // 방문 순서를 나타내는 변수입니다.

    // 깊이 우선 탐색을 수행합니다.
    public static void dfs(int node) {
        visited[node] = order++;  // 현재 노드를 방문 순서대로 표시하고, 순서를 증가시킵니다.
        // 인접한 정점들을 오름차순으로 탐색합니다.
        for (int next : adjList[node]) {
            if (visited[next] == 0) {  // 아직 방문하지 않았다면
                dfs(next);  // 재귀적으로 깊이 우선 탐색을 진행합니다.
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 정점의 수를 입력받습니다.
        int M = sc.nextInt();  // 간선의 수를 입력받습니다.
        int R = sc.nextInt();  // 시작 정점을 입력받습니다.

        adjList = new ArrayList[N + 1];  // 인접 리스트를 초기화합니다.
        visited = new int[N + 1];  // 방문 배열을 초기화합니다.

        // 각 정점에 대한 인접 리스트를 초기화합니다.
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 간선 정보를 입력받고, 양방향 그래프를 구성합니다.
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬합니다.
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        // DFS를 시작합니다.
        dfs(R);

        // 각 정점의 방문 순서를 출력합니다.
        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }
}
