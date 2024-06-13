import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        
        long high = (long) times[times.length - 1] * (long) n;
        long low = 0;
        long mid = 0;
        long passed = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            long people = 0;            
            for (long time: times) {
                people += mid / time;
            }
            passed = people;
            
            if (people < n) {
                low = mid + 1;
            } else if (people > n) {
                high = mid - 1;
            } else { // people == n
                if (answer > mid) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                answer = mid;
            }
        }
        // 바로 나누어 떨어지지 않아 people == n 에 들어가지 않는 경우
        if (answer == Long.MAX_VALUE) {
            if (passed > n) {
                answer = mid;
            } else {
                answer = mid + 1;
            }
        }
        return (long) answer;
    }
}
