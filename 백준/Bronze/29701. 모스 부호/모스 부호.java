import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());
        String[] inputMosArr = reader.readLine().split(" ");

        // 모스부호와 대응되는 문자를 저장하기 위해 맵 컬렉션을 생성합니다.
        Map<String, String> mosMap = new HashMap<>();
        
        mosMap.put(".-", "A");
        mosMap.put("-...", "B");
        mosMap.put("-.-.", "C");
        mosMap.put("-..", "D");
        mosMap.put(".", "E");
        mosMap.put("..-.", "F");
        mosMap.put("--.", "G");
        mosMap.put("....", "H");
        mosMap.put("..", "I");
        mosMap.put(".---", "J");
        mosMap.put("-.-", "K");
        mosMap.put(".-..", "L");
        mosMap.put("--", "M");
        mosMap.put("-.", "N");
        mosMap.put("---", "O");
        mosMap.put(".--.", "P");
        mosMap.put("--.-", "Q");
        mosMap.put(".-.", "R");
        mosMap.put("...", "S");
        mosMap.put("-", "T");
        mosMap.put("..-", "U");
        mosMap.put("...-", "V");
        mosMap.put(".--", "W");
        mosMap.put("-..-", "X");
        mosMap.put("-.--", "Y");
        mosMap.put("--..", "Z");
        mosMap.put(".----", "1");
        mosMap.put("..---", "2");
        mosMap.put("...--", "3");
        mosMap.put("....-", "4");
        mosMap.put(".....", "5");
        mosMap.put("-....", "6");
        mosMap.put("--...", "7");
        mosMap.put("---..", "8");
        mosMap.put("----.", "9");
        mosMap.put("-----", "0");
        mosMap.put("--..--", ",");
        mosMap.put(".-.-.-", ".");
        mosMap.put("..--..", "?");
        mosMap.put("---...", ":");
        mosMap.put("-....-", "-");
        mosMap.put(".--.-.", "@");

        for (String mos : inputMosArr) {
            // 모스맵에 해당 key값을 보유하고 있다면 value값을 가져옵니다.
            if (mosMap.containsKey(mos)) {
                writer.write(mosMap.get(mos));
            }
        }

        writer.flush();
        reader.close();
        writer.close();
    }

}
