import java.io.*;
import java.util.*;

public class Main {

    public static class Person {
        int rank1;
        int rank2;

        public Person(int rank1, int rank2) {
            this.rank1 = rank1;
            this.rank2 = rank2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person other = (Person) obj;
            // 현재 사람보다 순위가 더 좋은 사람이 존재하면 중복 처리
            return this.rank1 >= other.rank1 && this.rank2 >= other.rank2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rank1, rank2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 지원자 수
            List<Person> personList = new ArrayList<>();

            // 각 지원자의 순위 입력 받기
            for (int i = 0; i < n; i++) {
                String[] parts = br.readLine().split(" ");
                int rank1 = Integer.parseInt(parts[0]);
                int rank2 = Integer.parseInt(parts[1]);
                personList.add(new Person(rank1, rank2));
            }

            // 순위1을 기준으로 오름차순 정렬하고, rank2를 기준으로 내림차순 정렬
            Collections.sort(personList, (p1, p2) -> {
                if (p1.rank1 != p2.rank1) {
                    return Integer.compare(p1.rank1, p2.rank1); // rank1 기준 오름차순
                } else {
                    return Integer.compare(p2.rank2, p1.rank2); // rank2 기준 내림차순
                }
            });

            // rank2 값이 가장 작은 사람만 합격으로 처리
            int count = 0;
            int minRank2 = Integer.MAX_VALUE; // 가장 작은 rank2 값을 추적

            for (Person p : personList) {
                if (p.rank2 < minRank2) {
                    minRank2 = p.rank2;
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
