import java.io.*;
import java.util.*;

public class Main {

    // 넓은 스코프에서 파싱할 문자열 변수를 선언합니다.
    static String code;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        code = reader.readLine();

        // 문자열을 앞에서부터 차근차근 제거하면서 출력을 할 예정입니다.

        // 입력의 끝을 마주하기 전까지 무한 반복합니다.
        while (code.length() > 0) {
            // 공백으로 시작한다면 공백을 출력한 다음 제거합니다.
            if (code.startsWith(" ")) {
                System.out.print(" ");
                code = code.trim();
            }
            // 꺽쇠로 시작하는 경우 태그를 먼저 추출하고 출력합니다.
            if (code.startsWith("<")) {
                String tag = extractTag();
                System.out.print(tag);
            }
            // 일반 단어로 시작하는 경우 단어를 뒤바꾼 후 출력합니다.
            else {
                String reversedWord = reverseWord();
                System.out.print(reversedWord);
            }
        }

    }

    static String extractTag() {
        // 닫는 꺽쇠를 찾습니다.
        int endIdx = code.indexOf(">");

        String tag = code.substring(0, endIdx+1);
        code = code.substring(endIdx+1);

//            System.out.println(tag);
//            System.out.println(inputStr);
        return tag;
    }

    static String reverseWord() {
        // 인덱스를 찾을 수 없으면 -1을 반환하므로 추가적인 코드 보완이 필요합니다.
        int tagIdx = code.indexOf("<");
        int spaceIdx = code.indexOf(" ");
        int endIdx;

        if (tagIdx==-1 && spaceIdx==-1) {
            endIdx = code.length();
        } else if (tagIdx!=-1 && spaceIdx==-1) {
            endIdx = tagIdx;
        } else if (tagIdx==-1 && spaceIdx!=-1) {
            endIdx = spaceIdx;
        } else {
            endIdx = tagIdx < spaceIdx ? tagIdx : spaceIdx;
        }

        String partOfWord = code.substring(0, endIdx);
        String reversedWord = (new StringBuilder(partOfWord)).reverse().toString();

        code = code.substring(endIdx);

        return reversedWord;
    }
}