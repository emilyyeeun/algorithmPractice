import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] solution = new int[2];
        
        List<Integer> lottoList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        winList.retainAll(lottoList);
        int winListSize = winList.size();
        solution[1] = returnRanking(winListSize);
        
        long count = lottoList.stream().filter(i -> i == 0).count();
        if (count == 0) {
            solution[0] = solution[1];
        } else if (count == 6) {
            solution[0] = 1;
        } else {
            solution[0] = returnRanking((int)count + winListSize);
        }
        
        return solution;
    }
    
    private static int returnRanking(int sameNum) {
        switch (sameNum) {
            case 6:
                return 1;
            case 5: 
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
        }
        return 6;
    }
}
