import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputNum = scan.nextInt();

        // 규칙을 살펴봅시다.
        // n=1 일 때 => 1x1
        // n=2 일 때 => 5x5
        // n=3 일 때 => 9x9
        // n=4 일 때 => 13x13
        // 점화식을 세워보면 An = 1 + (n-1)4 = 4n-3
        int rectLength = 4*inputNum - 3;
        // 문자배열 2차원 배열을 선언합니다.
        char[][] twoDimArr = new char[rectLength][rectLength];
        // answer를 선언 후 drawStars()를 호출하여 반환값을 저장합니다.
        String answer = drawStars(inputNum, twoDimArr);

        // 정답을 출력합니다.
        System.out.println(answer);

    }

    static String drawStars(int num, char[][] twoDimArr) {
        int currentLength = 4*num-3;
        int startIdx = 1;
        int endIdx = currentLength;
//        StringBuilder sbStars = new StringBuilder();
//
//        for (int i=1; i<=rectLength; i++) {
//            for (int j=1; j<=rectLength; j++) {
//                if (i==1 || i==rectLength || j==1 || j==rectLength) {
//                    sbStars.append("*");
//                } else {
//                    sbStars.append(" ");
//                }
//            }
//
//            sbStars.append("\n");
//        }

        // 시행착오 끝에 String과 StringBuilder 등으로 하는 방식은 한계를 느꼈습니다.
        // 인덱스에 접근해서 그 값을 변경할 수 있는 문자배열로 접근을 해보겠습니다.
//        for (int i=1; i<=currentLength; i++) {
//            for (int j=1; j<=currentLength; j++) {
//                if (i==1 || i==currentLength || j==1 || j==currentLength) {
//                    twoDimArr[i-1][j-1] = '*';
//                } else {
//                    twoDimArr[i-1][j-1] = ' ';
//                }
//            }
//        }

        // 여기까지 했다면 큰 직사각형은 완성입니다.
        // 작은 사각형을 그려야하는데, 시작 지점을 (3,3)으로 지정해야할 필요가 있습니다.
        // while문을 써야할 것 같습니다.
        while (num >= 1) {
            // 각 테두리를 별로 채웁니다.
            for (int i=startIdx; i<=endIdx; i++) {
                for (int j=startIdx; j<=endIdx; j++) {
                    if (i==startIdx || i==endIdx || j==startIdx || j==endIdx) {
                        twoDimArr[i-1][j-1] = '*';
                    } else {
                        twoDimArr[i-1][j-1] = ' ';
                    }
                }
            }

            // 시작지점을 +2, 끝지점을-2, num을 -1 합니다.
            startIdx+=2; endIdx-=2; num--;
        }


        // char형 2차원 배열을 문자열로 변환하기 위해 우선 StringBuilder객체를 생성합니다.
        StringBuilder sbResult = new StringBuilder();
        // foreach문으로 char형 1차원 배열을 가져온 후, String객체로 변환 후 append합니다.
        // 줄바꿈을 하기 위해 개행문자도 append합니다.
        for (char[] charArr : twoDimArr) {
            sbResult.append(new String(charArr));
            sbResult.append("\n");
        }

        return sbResult.toString();
    }

}