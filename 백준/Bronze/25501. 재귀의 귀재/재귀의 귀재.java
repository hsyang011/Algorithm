import java.util.*;

public class Main {

    // 넓은 스코프에서 호출한 횟수를 저장하기 위한 변수를 선언합니다.
    static int callCnt = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 테스트의 갯수를 저장할 변수를 선언하고 저장합니다.
        int numOfTest = scan.nextInt();
        // 다음번에 nextLine()으로 문자열을 저장할 것이므로,
        // 입력버퍼에 남아있는 개행문자를 날립니다.
        scan.nextLine();

        // 입력으로 들어올 문자열을 저장 후 팰린드롬 여부를 검증합니다.
        for (int i=0; i<numOfTest; i++) {
            String str = scan.nextLine();
            int result = isPalindrome(str);

            System.out.println(result + " " + callCnt);

        }
        
        scan.close();

    }

    static int recursion(String s, int l, int r) {
        if (l >= r) {
            callCnt++;
            return 1;
        // C언어에서는 char포인터 타입이기에 문자열을 인덱스로 접근할 수 있으나,
        // Java에서는 문자배열의 개념이 아닌 String객체이므로 charAt()메소드로 인덱스의 문자를 읽어옵니다.
        } else if (s.charAt(l) != s.charAt(r)) {
            callCnt++;
            return 0;
        } else {
            callCnt++;
            return recursion(s, l+1, r-1);
        }

    }

    static int isPalindrome(String s) {
        // 테스트 케이스만큼 호출할 예정이므로 callCnt를 0으로 초기화 합니다.
        callCnt = 0;
        return recursion(s, 0, s.length()-1);
    }

}