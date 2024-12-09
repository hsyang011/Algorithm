#include <stdio.h>
#include <stdbool.h>

// 방 크기를 정의합니다.
#define MAX 50

char floor[MAX][MAX]; // 바닥 배열
bool visited[MAX][MAX]; // 방문 여부 배열
int N, M; // 방의 크기

// DFS를 수행하여 연결된 판자들을 방문합니다.
void dfs(int x, int y, char type) {
    // 현재 위치 방문 처리
    visited[x][y] = true;

    // 이동 방향 설정: '-'는 좌우, '|'는 상하로만 이동 가능
    if (type == '-') {
        // 좌우로 이동
        if (y - 1 >= 0 && floor[x][y - 1] == '-' && !visited[x][y - 1]) {
            dfs(x, y - 1, '-'); // 왼쪽으로 이동
        }
        if (y + 1 < M && floor[x][y + 1] == '-' && !visited[x][y + 1]) {
            dfs(x, y + 1, '-'); // 오른쪽으로 이동
        }
    } else if (type == '|') {
        // 상하로 이동
        if (x - 1 >= 0 && floor[x - 1][y] == '|' && !visited[x - 1][y]) {
            dfs(x - 1, y, '|'); // 위로 이동
        }
        if (x + 1 < N && floor[x + 1][y] == '|' && !visited[x + 1][y]) {
            dfs(x + 1, y, '|'); // 아래로 이동
        }
    }
}

int main() {
    // 입력값을 읽습니다.
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++) {
        scanf("%s", floor[i]);
    }

    // 방문 여부 초기화
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            visited[i][j] = false;
        }
    }

    int count = 0; // 나무 판자 수를 셉니다.

    // 방의 각 위치를 확인합니다.
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (!visited[i][j]) { // 방문하지 않은 위치라면
                count++; // 새로운 판자를 발견
                dfs(i, j, floor[i][j]); // 연결된 판자 방문
            }
        }
    }

    // 결과 출력
    printf("%d\n", count);

    return 0;
}
