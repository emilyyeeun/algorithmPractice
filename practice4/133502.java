import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int ing : ingredient) {
            stack.push(ing);
            if (ing == 1 && isHamburger(stack)) {
                answer++;
            }
        }
        return answer;
    }
    private static boolean isHamburger(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        
        if (!stack.empty() && stack.size() >= 4) {
            IntStream.range(0, 4).forEach(i -> sb.append(stack.get(stack.size() - i - 1)));
            String output = sb.toString();
            if (output.equals("1321")) {
                IntStream.range(0, 4).forEach(i -> stack.pop());
                return true;
                
            }
        }
        return false;
    }
}
