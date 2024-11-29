import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // 테스트 케이스 갯수만큼 반복합니다.
        while (size--> 0) {
            // 옷의 갯수를 담습니다.
            int numOfCloth = Integer.parseInt(br.readLine());

            // 맵리스트를 생성합니다.
            Map<String, Integer> clothsMap = new HashMap<>();
            while (numOfCloth--> 0) {
                String[] parts = br.readLine().split(" ");
                String name = parts[0];
                String clothType = parts[1];

                // 이전에 해당 타입으로 추가한 적이 있다면 값을 꺼내서 증가시킨 후 다시 맵에 반영합니다.
                if (clothsMap.containsKey(clothType)) {
                    int cnt = clothsMap.get(clothType);
                    clothsMap.put(clothType, ++cnt);
                } else {
                    clothsMap.put(clothType, 1);
                }
            }

            // 여기까지 완료하면 모든 입력을 받아 맵리스트에 값을 넣었습니다.
            // 이제 조합할 수 있는 경우의 수만 구하면 됩니다.
            // a, b, c, d 가 있을 때
            // a+b+c+d + ab+ac+ad+bc+bd+cd + abc+abd+bcd + abcd 입니다.
            // 맵을 순회하며 각 의상의 갯수를 리스트에 담습니다.
            List<Integer> list = new ArrayList<>();
            for (String clothType : clothsMap.keySet()) {
                list.add(clothsMap.get(clothType));
            }

            int sum = 1;

            for (int num : list) {
                sum *= (num+1);
            }

            System.out.println(sum-1);
        }

        br.close();
    }

}