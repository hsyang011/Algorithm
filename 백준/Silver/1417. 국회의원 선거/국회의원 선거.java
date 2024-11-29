import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // 기호 1번의 득표 기댓값
        int gihoOne = Integer.parseInt(br.readLine());
        int[] toopwo = new int[size-1];
        if (toopwo.length == 0) {
            System.out.println(0);
            return;
        }
        int idx = 0;
        while (size--> 1) {
            // 생각을 해봅시다.
            // 0번 인덱스를 제외한 나머지의 컬렉션을 만들어서
            // 그 컬렉션의 최댓값이 0번 인덱스의 값보다 작으면 된다.
            // 나머지의 컬렉션을 만들어봅시다.
            // 그 컬렉션은 배열로 만드는 게 좋아보인다.
            toopwo[idx++] = Integer.parseInt(br.readLine());
        }

        // 입력을 모두 받은 후, 다시 반복합니다.
        // 배열의 최댓값이 gihoOne보다 작을 때까지 반복을 합니다.
        int cnt = 0;
        Arrays.sort(toopwo);
        while (gihoOne <= toopwo[toopwo.length-1]) {
            gihoOne++;
            toopwo[toopwo.length-1]--;
            cnt++;
            Arrays.sort(toopwo);
        }

        System.out.println(cnt);

        br.close();
    }

}