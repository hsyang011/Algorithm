import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력을 받습니다.
        int startPos = scanner.nextInt(); // 수빈이의 위치를 입력받습니다.
        int targetPos = scanner.nextInt(); // 동생의 위치를 입력받습니다.

        // 결과를 출력합니다.
        System.out.println(findMinimumTime(startPos, targetPos));
    }

    // 수빈이가 동생을 찾는 데 걸리는 최소 시간을 계산합니다.
    private static int findMinimumTime(int startPos, int targetPos) {
        // 문제 접근: 처음엔 DFS로 시도했지만, 순간이동으로 인해 경로가 길어질 가능성이 큽니다.
        // 따라서 최단 시간을 보장하는 BFS로 접근하는 것이 적합하다고 판단했습니다.
        final int MAX_POSITION = 100000; // 이동 가능한 최대 범위를 정의합니다.
        boolean[] visited = new boolean[MAX_POSITION + 1]; // 방문 여부를 확인하기 위한 배열을 초기화합니다.

        // 큐를 선언합니다.
        Queue<int[]> queue = new LinkedList<>(); // 큐에는 {현재 위치, 경과 시간}이 저장됩니다.
        queue.offer(new int[]{startPos, 0}); // 시작 위치를 큐에 추가합니다.
        visited[startPos] = true; // 시작 위치를 방문 처리합니다.

        // BFS 탐색을 시작합니다.
        while (!queue.isEmpty()) {
            int[] currArr = queue.poll(); // 큐에서 현재 위치와 경과 시간을 꺼냅니다.
            int currPos = currArr[0];
            int currTime = currArr[1];

            // 동생의 위치에 도달하면 경과 시간을 반환합니다.
            if (currPos == targetPos) {
                return currTime;
            }

            // 다음 이동 가능한 위치를 계산합니다.
            int[] nextPosArr = {currPos-1, currPos+1, currPos*2};

            for (int nextPos : nextPosArr) {
                // 처음엔 여기서 중복된 위치를 큐에 넣어 성능 문제가 있었습니다.
                // 이를 해결하기 위해 방문 체크를 먼저 수행했습니다.
                if (nextPos>=0 && nextPos<=MAX_POSITION&&!visited[nextPos]) {
                    visited[nextPos] = true; // 방문 처리를 합니다.
                    queue.offer(new int[]{nextPos, currTime+1}); // 큐에 다음 위치와 시간을 추가합니다.
                }
            }
        }

        // 도달하지 못할 경우 -1을 반환합니다.
        return -1;
    }

}