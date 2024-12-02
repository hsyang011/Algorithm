import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static class Person {
        int solved;
        String name;

        public Person(int solved, String name) {
            this.solved = solved;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정답으로 출력할 문자열빌더 생성
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        // 우선순위큐를 생성합니다. 클래스 선언부에서 오버라이딩 혹은 익명클래스를 사용하여 오버라이딩 할 수도 있지만
        // 간편하게 람다식으로 작성합니다. 원래의 식은 다음과 같습니다.
//        Queue<Person> pqEx = new PriorityQueue<>(new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return Integer.compare(p2.solved, p1.solved);
//            }
//        });
        Queue<Person> pqPerson = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.solved, p1.solved));
        Queue<Integer> pqYear = new PriorityQueue<>();

        for (int i=0; i<3; i++) {
            String[] parts = br.readLine().split(" ");
            Person p = new Person(Integer.parseInt(parts[0]), parts[2]);
            pqPerson.offer(p);
            pqYear.offer(Integer.parseInt(parts[1]));
        }

        while (!pqPerson.isEmpty()) {
            Person p = pqPerson.poll();
            sb1.append(pqYear.poll() % 100);
            sb2.append(p.name.charAt(0));
        }

        System.out.println(sb1 + "\n" + sb2);

        br.close();
    }

}