import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Set<Integer> set = new TreeSet<>();

        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int[] answer = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}