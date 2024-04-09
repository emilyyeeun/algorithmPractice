
import java.util.*;
class Solution {
    public int solution(int[] array) {
        if (array.length == 1) {
            return 1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        
        return getAnswer(map);
    }
    private int getAnswer(HashMap<Integer, Integer> map) {
        int max = Integer.MIN_VALUE;
        int k = -1;
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val > max) {
                max = val;
                k = key;
            }
        }
        
        int temp = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val == max) {
                temp++;
            } 
            if (temp > 1) {
                return -1;
            }
        }
        
        return k;
    }
}
