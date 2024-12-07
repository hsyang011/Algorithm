import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 첫 번째 줄: 나무의 수 N과 필요한 나무의 길이 M
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        // 두 번째 줄: 나무들의 높이
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }
        
        // 이진 탐색을 위한 범위 설정
        int low = 0;  // 최소 높이
        int high = 0; // 최대 높이
        for (int i = 0; i < N; i++) {
            high = Math.max(high, trees[i]);  // 나무 중 가장 큰 높이를 최대 높이로 설정
        }
        
        int result = 0;  // 결과값 (최대 높이)
        
        // 이진 탐색
        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;  // 자른 나무의 길이를 저장할 변수
            
            // 나무를 자르고 얻은 나무의 길이를 계산
            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }
            
            // 자른 나무의 길이가 M 이상이면 높이를 더 높여본다
            if (sum >= M) {
                result = mid;  // 현재 mid가 가능하므로, 결과를 갱신
                low = mid + 1; // 더 높은 높이를 찾기 위해 low를 갱신
            } else {
                high = mid - 1; // 자른 나무의 길이가 부족하면 높이를 낮춘다
            }
        }
        
        // 최댓값으로 가능한 절단기 높이를 출력
        System.out.println(result);
    }
}
