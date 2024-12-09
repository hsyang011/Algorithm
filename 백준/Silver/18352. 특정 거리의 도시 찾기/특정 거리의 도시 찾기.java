import java.util.*;

public class Main {
    static int n, m, k, x; // 도시 수, 도로 수, 거리 정보, 출발 도시
    static List<List<Integer>> graph = new ArrayList<>(); // 그래프를 저장합니다.
    static int[] distances; // 거리 정보를 저장합니다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 도시 수, 도로 수, 거리 정보, 출발 도시를 입력받습니다.
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        // 그래프 초기화 및 거리 초기화를 수행합니다.
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        distances = new int[n + 1];
        Arrays.fill(distances, -1); // 초기 거리 값을 -1로 설정합니다.

        // 도로 정보를 입력받아 그래프를 구성합니다.
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }

        // BFS를 통해 거리 정보를 갱신합니다.
        bfs(x);

        // 거리 K인 도시를 출력합니다.
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (distances[i] == k) {
                result.add(i);
            }
        }

        // 결과를 출력합니다. 없으면 -1을 출력합니다.
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result); // 오름차순 정렬합니다.
            for (int city : result) {
                System.out.println(city);
            }
        }

        sc.close();
    }

    // BFS를 사용해 출발 도시에서 각 도시까지의 최단 거리를 계산합니다.
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 시작 도시를 큐에 추가합니다.
        distances[start] = 0; // 시작 도시의 거리를 0으로 설정합니다.

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 도시를 큐에서 꺼냅니다.

            // 인접 도시를 순회하며 거리를 갱신합니다.
            for (int next : graph.get(current)) {
                if (distances[next] == -1) { // 방문하지 않은 도시만 처리합니다.
                    distances[next] = distances[current] + 1; // 최단 거리를 계산합니다.
                    queue.add(next); // 다음 도시를 큐에 추가합니다.
                }
            }
        }
    }
}
