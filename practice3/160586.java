// 리팩토링 전
import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> inputMap = new HashMap<>();
        for (String keys: keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char curr = keys.charAt(i);
                inputMap.put(curr, Math.min(inputMap.getOrDefault(curr, i + 1), i + 1));
            }
        }
        
        int[] result = new int[targets.length];
        int index = 0;
        for (String target: targets) {
            int count = 0;
            for (char letter: target.toCharArray()) {
                count += inputMap.getOrDefault(letter, -1);
                if (count == -1) break;
            }
            result[index++] = count;
        }
        return result;
    }
}
