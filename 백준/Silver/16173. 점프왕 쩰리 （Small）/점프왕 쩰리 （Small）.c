#include <stdio.h>
#include <stdbool.h>

#define MAX_N 3

int N;                     // 게임판 크기를 저장합니다.
int map[MAX_N][MAX_N];     // 게임판 정보를 저장합니다.
bool visited[MAX_N][MAX_N]; // 방문 여부를 기록합니다.

// DFS로 끝 지점 도달 여부를 확인합니다.
// 현재 위치에서 이동 가능한 칸을 탐색하며 끝 점에 도달하는지 확인합니다.
bool dfs(int x, int y) {
    if (map[x][y] == -1) return true; // 승리 지점(-1)에 도달하면 true를 반환합니다.

    int jump = map[x][y]; // 현재 칸에서 이동할 점프 크기를 가져옵니다.

    // 오른쪽으로 점프 가능한지 확인합니다.
    if (y + jump < N && !visited[x][y + jump]) {
        visited[x][y + jump] = true; // 방문 처리를 합니다.
        if (dfs(x, y + jump)) return true; // 오른쪽 방향으로 DFS를 재귀 호출합니다.
    }

    // 아래로 점프 가능한지 확인합니다.
    if (x + jump < N && !visited[x + jump][y]) {
        visited[x + jump][y] = true; // 방문 처리를 합니다.
        if (dfs(x + jump, y)) return true; // 아래 방향으로 DFS를 재귀 호출합니다.
    }

    return false; // 더 이상 이동할 곳이 없으면 false를 반환합니다.
}

int main() {
    scanf("%d", &N); // 게임판 크기를 입력받습니다.

    // 게임판 정보를 입력받습니다.
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &map[i][j]);
        }
    }

    // 방문 배열을 초기화합니다.
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            visited[i][j] = false;
        }
    }

    visited[0][0] = true; // 시작 위치를 방문 처리합니다.

    // DFS를 시작하여 끝 지점 도달 여부를 확인합니다.
    if (dfs(0, 0)) {
        printf("HaruHaru\n"); // 끝 지점에 도달 가능하면 HaruHaru를 출력합니다.
    } else {
        printf("Hing\n"); // 끝 지점에 도달 불가능하면 Hing을 출력합니다.
    }

    return 0;
}
