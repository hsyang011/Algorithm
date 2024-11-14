import java.util.*;

public class Main {

    // 넓은 스코프에 3차원배열을 생성합니다.
    static int size = 21;
    static int[][][] threeDimArr = new int[size][size][size];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            // -1 -1 -1 값이 들어오면 종료합니다.
            if (line.equals("-1 -1 -1")) {
                break;
            }

            list.add(line);
        }

        // 리스트에 담긴 문자열을 하나씩 꺼내옵니다.
        for (String str : list) {
            // 공백으로 구분해서 String[]배열로 반환합니다.
            String[] sArr = str.split(" ");
            // int 배열에 모두 담습니다.
            int[] arr = new int[sArr.length];

            for (int i=0; i<arr.length; i++) {
                arr[i] = Integer.parseInt(sArr[i]);
            }

            // 메소드를 실행합니다.
            int result = w(arr[0], arr[1], arr[2]);
            // printf를 이용하여 서식기호를 통해 문자열을 생성합니다.
            System.out.printf("w(%d, %d, %d) = %d\n", arr[0], arr[1], arr[2], result);
        }
    }

    static int w (int a, int b, int c) {
//        if (a<=0 || b<=0 || c<=0) {
//            return 1;
//        } else if (a>20 || b>20 || c>20) {
//            return w(20, 20, 20);
//        } else if (a<b && b<c) {
//            return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
//        } else {
//            return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
//        }

        if (a<=0 || b<=0 || c<=0) {
            return 1;
        }

        if (a>20 || b>20 || c>20) {
            return w(20, 20, 20);
        }

        // 이미 계산된 값이 있으면 그 값을 반환 (메모이제이션 활용)
        if (threeDimArr[a][b][c] != 0) {
            return threeDimArr[a][b][c];
        }

        if (a<b && b<c) {
            threeDimArr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return threeDimArr[a][b][c];
        } else {
            threeDimArr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
            return threeDimArr[a][b][c];
        }
    }

}