import java.util.*;

public class Main {

    // 넓은 스코프(al.전역변수)에서 카운트할 변수를 선언합니다.
    static int cnt1=1, cnt2=0;

    public static void main(String[] args) {
        // 문제에 주어진 조건대로 그대로 해봅시다.
        Scanner scan = new Scanner(System.in);

        int inputNum = scan.nextInt();

        // 재귀호출 함수를 실행합니다.
        fib(inputNum);
        // 컬렉션을 이용한 피보나치 함수를 실행합니다.
        fibonacci(inputNum);

        // cnt1과 cnt2를 출력합니다.
        System.out.println(cnt1 + " " + cnt2);

        
    }

    // 재귀호출 함수
    static int fib(int n) {
        if (n==1 || n==2) {
            return 1;
        } else {
            cnt1++;
            return fib(n-1) + fib(n-2);
        }
    }

    // 리스트 컬렉션을 이용한 함수
    static int fibonacci(int n) {
        List<Integer> list = new ArrayList<>();
        // 0번과 1번 인덱스에 값을 채웁니다. 코드 가독성을 위해 인덱스도 직접 지정해 줍니다.
        list.add(0, 1); list.add(1, 1);
        for (int i=3; i<=n; i++) {
            // nextValue는 이전 노드의 값 2개를 더한 값으로 저장합니다.
            int nextValue = list.get(i-3) + list.get(i-2);
            // 다음 인덱스에 nextValue값을 추가합니다.
            list.add(i-1, nextValue);
            // add() 작업이 수행되었으므로 cnt2를 카운트합니다.
            cnt2++;
        }

        // 여기서 반환값은 의미는 없으나 return type이 int이므로 마지막 노드의 값을 반환합니다.
        return list.get(n-1);
    }

}