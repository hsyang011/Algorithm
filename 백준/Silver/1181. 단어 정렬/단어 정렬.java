import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 중복되는 단어를 제거하기 위해 Set컬렉션을 이용합니다. 그 중에서도 정렬이 제공되는 TreeSet을 사용합니다.
        // 정렬의 조건을 람다식으로 정의합니다.
        // Comparator를 익명클래스를 생성하여 compare메소드를 오버라이딩합니다.
        Set<String> wordSet = new TreeSet<>((word1, word2) -> {
            // 길이가 다를 때는 길이를 비교하여 작은 순으로 정렬합니다.
            if (word1.length() != word2.length()) {
                return Integer.compare(word1.length(), word2.length());
            // 길이가 같을 때는 단어의 사전순으로 정렬합니다.
            } else {
                return word1.compareTo(word2);
            }
        });

        // 단어의 갯수만큼 반복하여 Set컬렉션에 담습니다.
        int size = Integer.parseInt(br.readLine());
        while (size--> 0) {
            wordSet.add(br.readLine());
        }

        // TreeSet으로 정렬된 Set컬렉션을 차례로 출력합니다.
        for (String word : wordSet) {
            System.out.println(word);
        }

        br.close();
    }

}