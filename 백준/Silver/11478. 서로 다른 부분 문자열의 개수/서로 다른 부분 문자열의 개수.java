import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        // 문자열을 쪼갤 수 있는 모든 경우의 수를 다 세어본 다음 Set컬렉션에 넣어보겠습니다.
        // Set컬렉션을 생성합니다.
        Set<String> set = new HashSet<>();

        // 문자열을 substring으로 쪼갠 후 모두 Set컬렉션에 저장합니다.
        // 중첩 for문으로 구성했고 startIndex는 i (0~4) endIndex는 i+j로 구성합니다.
        for (int i=0; i<str.length(); i++) {
            for (int j=1; i+j<str.length()+1; j++) {
                String partOfStr = str.substring(i, i+j);
                // 이미 중복된 단어가 존재할 경우 add하지 않는 것을 이용합니다.
                set.add(partOfStr);
            }
        }

        // Set컬렉션의 사이즈를 출력합니다.
        System.out.println(set.size());
    }
}