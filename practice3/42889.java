import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> percent = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            int curr = i;
            int total = (int) Arrays.stream(stages).filter(k -> k >= curr).count();
            int fail = (int) Arrays.stream(stages).filter(k -> k == curr).count();
            double value = (total == 0 || fail == 0) ? 0.0 : ((double) fail / total);
            percent.put(curr, value);
        }
        
        List<Integer> keySet = new ArrayList<>(percent.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // double의 compare 문제
                // 내림차순
                if (Double.compare(percent.get(o1), percent.get(o2)) > 0) {
                    return -1;
                // 실패율이 같다면 작은 번호의 스테이지가 먼저 오도록 한다. 
                } else if (Double.compare(percent.get(o1), percent.get(o2)) == 0) {
                    return o1.compareTo(o2);
                } else {
                    return 1;
                }
            }
        });
        
        int[] result = new int[N];
        int i = 0;
        for (Integer key : keySet) {
            result[i] = (int)key;
            i++;
        }
        return result;
    }
}
