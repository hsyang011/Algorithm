import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        // 책의 제목을 key, 팔린 횟수를 value로 저장하기 위해 Map 컬렉션을 생성합니다.
        // 정렬을 하기 위해 HashMap 대신 TreeMap을 이용합니다.
        Map<String, Integer> books = new TreeMap<>();

        // 입력받은 문자열을 가져와 Map 컬렉션에 저장합니다.
        for (int i=0; i<num; i++) {
            String bookTitle = reader.readLine();

            // 이미 책이 컬렉션에 저장되었다면 value의 값을 1 증가시킵니다.
            if (books.containsKey(bookTitle)) {
                int cnt = books.get(bookTitle);
                books.put(bookTitle, ++cnt);
            } else {
                // 처음 저장되었다면 value값을 1로 저장힙니다.
                books.put(bookTitle, 1);
            }
        }

        // 가장 많이 팔린 횟수를 먼저 구합니다.
        int maxSellCnt  = 0;
        String maxSellBookTitle = "";
        for (String bookTitle : books.keySet()) {
            int sellCnt = books.get(bookTitle);
            if (sellCnt > maxSellCnt) {
                maxSellCnt = sellCnt;
                maxSellBookTitle = bookTitle;
            }
        }

        System.out.println(maxSellBookTitle);

    }
}