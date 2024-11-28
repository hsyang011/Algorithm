import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 입력이 간단하므로 스캐너도 입력받는다.
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        // size만큼의 크기로 배열을 생성하고 입력값을 저장한다.
        int[] barArr = new int[size];
        for (int i=0; i<barArr.length; i++) {
            barArr[i] = sc.nextInt();
        }

        // 마지막 요소는 무조건 포함되므로 1로 초기화
        int answer = 1;

        // 마지막 요소의 값을 현재 최대 높이로 설정
        int currentMaxHeight = barArr[size-1];
        // 역순회
        for (int i=size-2; i>=0; i--) {
            if (currentMaxHeight < barArr[i]) {
                currentMaxHeight = barArr[i];
                answer++;
            }
        }

        System.out.println(answer);

        sc.close();
    }

}