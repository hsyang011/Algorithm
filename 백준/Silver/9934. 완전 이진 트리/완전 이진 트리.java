import java.io.*;
import java.util.*;
import java.util.stream.*;

// 레벨을 나타내는 클래스를 정의합니다.
class Level {

    private final List<Integer> nodes = new ArrayList<>(); // 해당 레벨의 노드 리스트입니다.

    // 노드 리스트에 노드를 추가합니다.
    public void addNode(int data) {
        nodes.add(data);
    }

    // 노드 리스트를 문자열로 변환하는데, 공백이 추가된 리스트로 변환합니다.
    public String getNodesAsString() {
        return nodes.stream() // 노드 리스트를 문자열로 변환합니다.
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

}

public class Main {
    
    // 이 문제는 완전이진트리로 입력이 주어지므로, 레벨에 따른 노드의 갯수가 고정되어 있습니다.
    // 1일 때 노드의 갯수는 1, 2일 때 3, 3일 때 7, 4일 때 15입니다.
    // 즉 n일 때 노드의 갯수 = 시그마 i는 0부터 n-1까지 2^n 입니다.
    // 또한 왼쪽, 부모, 오른쪽 순으로 순회하는 것으로 보아, 중위 순회를 하고 있습니다.
    // 우선 트리를 구성해 본 후, 레벨 순으로 출력해 봅니다.
    
    static List<Level> levels; // 각 레벨을 관리할 리스트입니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfLevel = Integer.parseInt(br.readLine()); // 트리의 레벨 수를 입력받습니다.
        int[] arr = Arrays.stream(br.readLine().split(" ")) // 입력 데이터를 정수 배열로 변환합니다.
                .mapToInt(Integer::parseInt)
                .toArray();

        // 레벨의 갯수만큼 Level객체를 생성합니다.
        levels = IntStream.range(0, numOfLevel)
                .mapToObj(i -> new Level())
                .collect(Collectors.toList());

        // 트리를 구성합니다. 재귀 호출이 포함되어 있습니다.
        buildTree(arr, 0, arr.length - 1, 0);

        // 각 레벨의 데이터를 출력합니다.
        levels.forEach(level -> System.out.println(level.getNodesAsString()));
    }

    // 중위 순회를 이용해 데이터를 트리에 추가합니다.
    private static void buildTree(int[] arr, int start, int end, int level) {
        if (start > end) return; // 종료 조건입니다.

        int mid = (start + end) / 2; // 중간값을 선택합니다.
        levels.get(level).addNode(arr[mid]); // 선택된 중간값을 해당 레벨에 추가합니다.

        buildTree(arr, start, mid - 1, level + 1); // 왼쪽 서브트리를 구성합니다.
        buildTree(arr, mid + 1, end, level + 1);   // 오른쪽 서브트리를 구성합니다.
    }

}