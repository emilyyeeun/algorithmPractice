import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        if (truck_weights.length == 1 && truck_weights[0] <= weight) {
            return bridge_length + 1;
        }
        
        int time = 0;
        int totalWeight = 0;
      
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        
        for (int truck : truck_weights) {
            trucks.add(truck);
        }
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }
        
        int passed = 0;
        int currTruck = trucks.peek();
        
        while (passed < truck_weights.length) {
            time++;
            int w = totalWeight - queue.peek();
            if (w + currTruck <= weight) {
                int curr = queue.remove();
                totalWeight -= curr;
                if (curr != 0) {
                    passed++;
                }
                trucks.poll();
                queue.add(currTruck);
                totalWeight += currTruck;
            } else {
                int curr = queue.remove();
                totalWeight -= curr;
                if (curr != 0) {
                    passed++;
                }
                queue.add(0);
            }
            if (!trucks.isEmpty()) {
                currTruck = trucks.peek();
            }
            
        }
        return time;
    }
}
