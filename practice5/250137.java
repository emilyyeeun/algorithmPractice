// 최초 시도 
import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        HashMap<Integer, Integer> attackMap = new HashMap<>();
        IntStream.range(0, attacks.length)
            .forEach(i -> attackMap.put(attacks[i][0], attacks[i][1]));
        
        int continued = 0;
        int totalHealth = health;
        
        for (int i = 0; i < attacks[attacks.length - 1][0] + 1; i++) {
            if (attackMap.containsKey(i)) {
                totalHealth = totalHealth - attackMap.get(i);
                continued = 0;
                if (totalHealth <= 0) {
                    return -1;
                }
            } else if (totalHealth < health) {
                totalHealth += bandage[1];             
                continued++;
                if (continued == bandage[0]) {
                    totalHealth += bandage[2];
                    continued = 0;
                    totalHealth = checkHealthBoundary(totalHealth, health);
                }
            } else {
                totalHealth = checkHealthBoundary(totalHealth, health);
            }
        }
        return totalHealth;
    }
    
    private int checkHealthBoundary(int totalHealth, int health) {
        return (totalHealth <= 0) ? -1 : (totalHealth >= health) ? health : totalHealth;
    }
}
