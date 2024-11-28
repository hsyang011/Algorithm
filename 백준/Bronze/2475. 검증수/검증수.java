import java.util.*;

class Main {
    public static void main(String[] args) {
        // 스캐너 객체 생성
        Scanner scan = new Scanner(System.in);
        
        // 입력받을 고유번호의 갯수
        int size = 5;
        
        // 입력받은 변수를 제곱 연산하여 합을 누적시킵니다.
        int sum = 0;
        for (int i=0; i<size; i++) {
            int num = scan.nextInt();
            
            // java.lang패키지의 Math클래스를 이용하여 제곱연산을 수행
            // pow(a,b)의 반환타입은 double이므로 캐스팅변환 수행
            sum += (int)Math.pow(num, 2);
        }
        
        // sum을 이용해서 answer를 도출
        int answer = sum % 10;
        System.out.println(answer);
    }
}