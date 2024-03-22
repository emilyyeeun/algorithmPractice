// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// Hash
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        for (String per : participant) {
            if (hashmap.containsKey(per)) {
                hashmap.put(per, hashmap.get(per) + 1);
            } else {
                hashmap.put(per, 1);
            }
        }
        for (String comp: completion) {
            if (hashmap.containsKey(comp)) {
                if (hashmap.get(comp) - 1 == 0){
                    hashmap.remove(comp);
                } else {
                    hashmap.put(comp, hashmap.get(comp) - 1);
                }
            } else {
                hashmap.put(comp, 1);
            }
        }
        for (String key: hashmap.keySet()){
            answer = key;
        }
        return answer;
    }
}
