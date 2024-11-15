import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        // 확장자를 저장할 배열을 선언합니다.
        // 배열의 정확한 크기를 모르기 때문에 컬렉션을 이용합니다.
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<num; i++) {
            // 파일 이름과 확장자를 분리하여 저장합니다.
            String[] strArr = reader.readLine().split("\\.");

            // strArr의 길이가 2일 때만 아래 코드를 수행합니다.
            if (strArr.length == 2) {
                // 확장자를 Map컬렉션의 키값으로 지정합니다.
                String key = strArr[1];
                // map컬렉션에 해당 확장자가 이미 존재하면
                if (map.containsKey(key)) {
                    // value 값을 1 증가시킵니다.
                    int value = map.get(key);
                    map.put(key, ++value);
                } else {
                    // map컬렉션에 확장자가 존재하지 않으면 value를 1로 초기화합니다.
                    map.put(key, 1);
                }
            }
        }

        // map의 키셋메소드를 이용하여 key값을 Set컬렉션으로 반환한 후, 배열로 다시 변환합니다.
        // 이때 toArray()는 반환타입이 Object[] 이므로 String[]으로 캐스팅합니다.
        // 했는데 ClassCastException이 발생합니다.
//        String[] keyArr = (String[]) map.keySet().toArray();
        // 이렇게 toArray()를 사용할 때는 인자로 해당 타입의 배열을 넣어주면 된다고 합니다.
        String[] keyArr = map.keySet().toArray(new String[map.size()]);
        // Arrays.sort()를 이용하여 오름차순 정렬합니다.
        Arrays.sort(keyArr);

        // 오름차순 정렬된 키 배열을 순회하여 출력합니다.
        for (String key : keyArr) {
            System.out.println(key + " " + map.get(key));
        }

    }
}