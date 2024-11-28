import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 입력이 간단하므로 스캐너도 입력받는다.
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        // 개행문자가 저장되었으므로 날립니다.
        sc.nextLine();
        // 각각의 테스트 케이스마다 문자열을 뒤집습니다.
        for (int i=0; i<size; i++) {
            String str = sc.nextLine();
            reverseAndPrint(str, i);
        }

        sc.close();
    }

    static void reverseAndPrint(String str, int idx) {
        Deque<String> dq = Arrays.stream(str.split(" ")) // stream<T[] t>를 이용하여 문자열 스트림을 생성
                // toCollection()으로 컬렉션을 생성하며 스트림을 모읍니다. 생성 방식은 ArrayDeque입니다.
                .collect(Collectors.toCollection(ArrayDeque::new));

        StringBuilder sb = new StringBuilder();
        sb.append("Case #").append(idx+1).append(": ");

        while (!dq.isEmpty()) {
            sb.append(dq.pollLast()).append(" ");
        }

        System.out.println(sb);
    }

}