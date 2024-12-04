import java.io.*;
import java.util.*;

class Bosuk {
    int weight; // 무게
    int value;  // 가격

    // Bosuk 생성자입니다.
    Bosuk(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보석 개수와 가방 개수 입력받습니다.
        String[] parts = br.readLine().split(" ");
        int bosukLen = Integer.parseInt(parts[0]);
        int bagLen = Integer.parseInt(parts[1]);

        // 보석 객체를 담을 배열을 생성합니다.
        Bosuk[] bosuks = new Bosuk[bosukLen];

        // 보석 객체를 생성하여 배열에 저장합니다.
        for (int i = 0; i < bosukLen; i++) {
            String[] bosukInfo = br.readLine().split(" ");
            int weight = Integer.parseInt(bosukInfo[0]);
            int value = Integer.parseInt(bosukInfo[1]);

            bosuks[i] = new Bosuk(weight, value);
        }

        // 보석 배열을 무게 오름차순, 무게가 같으면 가격 내림차순으로 정렬합니다.
        Arrays.sort(bosuks, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.value - o1.value;  // 가격 내림차순입니다.
            }
            return o1.weight - o2.weight;  // 무게 오름차순입니다.
        });

        // 가방 무게 배열을 입력받습니다.
        int[] bags = new int[bagLen];
        for (int i = 0; i < bagLen; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방 무게를 오름차순으로 정렬합니다.
        Arrays.sort(bags);

        // 우선순위 큐를 이용해 보석의 가격을 내림차순으로 관리합니다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;

        // 가방의 개수만큼 반복하여 가방에 보석을 채웁니다.
        for (int i = 0, j = 0; i < bagLen; i++) {
            // 현재 가방 무게보다 작은 보석들을 우선순위 큐에 넣습니다.
            while (j < bosukLen && bosuks[j].weight <= bags[i]) {
                pq.offer(bosuks[j++].value);  // 보석의 가치를 큐에 넣습니다.
            }

            // 우선순위 큐에서 가장 큰 가치를 가진 보석을 꺼내 가방에 넣습니다.
            if (!pq.isEmpty()) {
                ans += pq.poll();  // 가장 큰 가치의 보석을 가방에 담습니다.
            }
        }

        // 최종적으로 얻을 수 있는 가방에 담긴 보석들의 총 가치를 출력합니다.
        System.out.println(ans);

        br.close();
    }
    
}