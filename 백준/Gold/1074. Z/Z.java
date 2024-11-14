import java.util.*;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputNum = scan.nextInt();
        int row = scan.nextInt();
        int col = scan.nextInt();

        int len = (int)Math.pow(2, inputNum);

        int answer = find(row, col, len);

        System.out.println(answer);

        // 자 생각을 해봅시다.
        // 결국엔 4개의 원소가 묶음 단위로 움직입니다.
        // n=1 일 때 startIndex만 살펴보면,
        // 0,0 => 0,1 => 1,0 => 1,1 순서이다.
        // 즉 0, 1, 2, 3이다.
        // n=2 일 때 startIndex만 살펴보면,
        // 0,0 => 0,2 => 2,0 => 2,2 순서이다.
        // 즉 0, 4, 8, 12이다.
        // n=3 일 때 startIndex만 살펴보면,
        // 0,0 => 0,4 => 4,0 => 4,4 순서이다.
        // 즉 0, 16, 32, 48이다.
        // n=4 일 때
        // 0,0 => 0,8 => 8,0 => 8,8

        // 즉 핵심 행은 0행, 2행, 4행, 8행 등등이다.

    }

    // 찾으려는 행렬의 값과 사각형의 길이를 보내줍니다.
    static int find(int row, int col, int len) {
        if (len == 1) {
            return cnt;
        }

        len /= 2;
        // 찾으려는 값의 위치가 0,0이라면
        if (row<len && col<len) {
            find(row, col, len);
        } else if (row<len && col>=len) {
            cnt += len*len;
            find(row, col-len, len);
        } else if (row>=len && col<len) {
            cnt += len*len*2;
            find(row-len, col, len);
        } else if (row>=len && col>=len) {
            cnt += len*len*3;
            find(row-len, col-len, len);
        }

        return cnt;
    }

}