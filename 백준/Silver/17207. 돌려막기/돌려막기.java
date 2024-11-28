import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // 문자열 배열에 이름 저장
        String[] nameArr = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};

        // 1번 행렬
        int[][] arr1 = new int[5][5];
        // 2번 행렬
        int[][] arr2 = new int[5][5];

        // 각각의 입력 행렬을 2차원 배열에 저장합니다.
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                arr1[i][j] = scan.nextInt();
            }
        }

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                arr2[i][j] = scan.nextInt();
            }
        }

        // x번째 사람의 y번 예상 일량 구하기
        int[] sumArr = new int[5];
        for (int x=0; x<5; x++) {
            for (int y=0; y<5; y++) {
                // int n = expectedWorking(x, y, arr1, arr2);
                // System.out.println(nameArr[x] + " : " + nameArr[y] + " : " + n);
                sumArr[x] += expectedWorking(x, y, arr1, arr2);
            }
        }

//        for (int i=0; i<5; i++) {
//            System.out.println(nameArr[i] + " : " + sumArr[i]);
//        }

        // 최솟값과 인덱스 구하기
        int min = sumArr[0];
        int idx = 0;
        for (int i=1; i<5; i++) {
            if (min >= sumArr[i]) {
                min = sumArr[i];
                idx = i;
            }
        }

        System.out.println(nameArr[idx]);
//        System.out.println(min + " : " + idx);

    }

    static int expectedWorking(int x, int y, int[][] arr1, int[][] arr2) {
        int level, time;
        int sum = 0;
        for (int i=0; i<5; i++) {
            level = arr1[x][i];
            time = arr2[i][y];

            sum += level*time;
        }

        return sum;
    }

}