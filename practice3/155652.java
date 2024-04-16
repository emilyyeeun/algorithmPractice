// 리팩토링 전
import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char start = s.charAt(i);
            for (int j = 0; j < index; j++) {
                start++;
                start = (start > 'z') ? 'a' : start;
                if (skip.contains(String.valueOf(start))) {
                    j--;
                }
            }
            sb.append(start);
        }    
        return sb.toString();
    }
}
