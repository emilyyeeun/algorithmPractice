// 1차 시도 (fail) 
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> percent = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            int curr = i;
            int total = (int) Arrays.stream(stages).filter(k -> k >= curr).count();
            int fail = (int) Arrays.stream(stages).filter(k -> k == curr).count();
            double value = (total == 0) ? 0.0 : ((double)fail / total);
            percent.put(curr, value);
        }
        
        List<Integer> keySet = new ArrayList<>(percent.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (percent.get(o1) > percent.get(o2)) {
                    return -1;
                } else if (percent.get(o1) == percent.get(o2)) {
                    return o1 - o2;
                } else {
                    return 1;
                }
            }
        });
        
        int[] result = new int[N];
        int i = 0;
        for (Integer key : keySet) {
            result[i] = key;
            i++;
        }
        return result;
    }
}
