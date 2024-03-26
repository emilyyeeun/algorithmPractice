import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {    
        Arrays.sort(lost);
        Arrays.sort(reserve);
        Set <Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int i : reserve) {
            reserveSet.add(i);
        }
        
        for (int j : lost) {
            if (reserveSet.contains(j)) {
                reserveSet.remove(j);
            } else {
                lostSet.add(j);
            }
        }        
        
        for (int k : reserveSet) {
            // 여분이 있는 사람 앞뒤로 도난 여부 확인
            int back = k + 1;
            int front = k - 1;
           
            if (lostSet.contains(front)) {
                lostSet.remove(front);
            } else if (lostSet.contains(back)) {
                lostSet.remove(back);
            }
        }
        return n - lostSet.size();
    }

}
