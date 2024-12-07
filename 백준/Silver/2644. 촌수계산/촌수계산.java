import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 사람 수 n, 촌수 계산할 두 사람의 번호 a, b
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // 관계의 개수 m
        int m = sc.nextInt();
        
        // 그래프 초기화 (각 사람에 대해 부모와 자식 관계)
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 부모-자식 관계 입력
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x); // 양방향 관계
        }
        
        // BFS로 촌수 계산
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1); // -1로 초기화 (방문하지 않음)
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = 0; // 시작 노드는 촌수 0 (자기 자신)
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // 인접 노드 탐색
            for (int next : graph[current]) {
                if (visited[next] == -1) { // 아직 방문하지 않은 노드
                    visited[next] = visited[current] + 1; // 촌수 증가
                    queue.add(next);
                    
                    // b를 찾으면 바로 종료
                    if (next == b) {
                        System.out.println(visited[next]);
                        return;
                    }
                }
            }
        }
        
        // b에 도달할 수 없으면 -1 출력
        System.out.println(-1);
    }
}
