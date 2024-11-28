import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

//         만약 1개의 자연수로 나타낼 수 있다면 n
//         2개의 자연수는 n, n+1
//         3개의 자연수는 n, n+1, n+2
//         m개의 자연수는 n, n+1, n+2, ... , n+(m-1) 일 것이다.
//
//         그렇다면 m개의 자연수로 나타낼 때,  그 수 들을 모두 합한 값이 inputNum이 된다는 소리이다.
//         m은 범위값으로 주어야하는데, m은 절대로 inputNum을 넘을 수 없으므로 m < inputNum으로 세워보도록 해봅시다.

        // 앞에껀 시행착오였고, 다시 생각해봅시다.
        // 짝수개의 자연수로 나타낼 수 있다면 n-1, n, n+1, n+2 등으로,
        // 홀수개의 자연수로 나타낼 수 있다면 n-2, n-1, n, n+1, n+2 등으로 나타낼 수 있습니다.
        // 즉 짝수개의 자연수로 나타낼 경우 그 수들의 합은 m*n + m/2 이고,
        // 홀수개의 자연수로 나타낼 경우 그 수들의 합은 m*n이었습니다.
        // 이를 if 분기문으로 짜봅시다.
        int answer = 0;
//        for (int m=1; m<inputNum; m++) {
//            // 짝수라면 점화식 m*n + m/2 실행
//            if (m%2 == 0) {
//                answer += (inputNum-(m/2)) % m == 0 ? 1 : 0;
//            }
//            // 홀수라면 점화식 m*n 실행
//            if (m%2 != 0) {
//                answer += inputNum%m == 0 ? 1 : 0;
//            }
//        }


        // 다시 시행착오를 겪은 결과 처음 방식대로 하는 게 맞았습니다.
        // 점화식을 세우면 inputNum = m*n + m(m-1)/2
        // 다만 m의 값의 범위를 제대로 설정할 필요가 있었는데,

        for (int m=1; m*(m-1)/2<inputNum; m++) {
            answer += (inputNum-(m*(m-1)/2)) % m == 0 ? 1 : 0;
        }


        // 반례가 존재하는데, 1,2,3,4와 0,1,2,3,4가 존재하는 경우이다.
        // n>0이라는 조건을 달아줘야 한다.

        System.out.println(answer);
    }

}