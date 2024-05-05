import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 친구 - 인덱스 변환하여 해쉬테이블에 저장
        HashMap<String, Integer> friendMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }
        
        // 주고받은 선물 표로 표현
        int[][] giftMatrix = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];
        
        for (String pair : gifts) {
            String giver = pair.split(" ")[0];
            String given = pair.split(" ")[1];
            giftMatrix[friendMap.get(giver)][friendMap.get(given)]++;
            giftScore[friendMap.get(giver)]++;
            giftScore[friendMap.get(given)]--;
        }
        
        
        // 다음 달 선물 교환
        int[] nextMonth = new int[friends.length];
        for (int i = 1; i < friends.length; i++) {
            for (int j = 0; j < i; j++) {
                if (giftMatrix[i][j] > giftMatrix[j][i]) {
                    nextMonth[i]++;
                } else if (giftMatrix[i][j] < giftMatrix[j][i]) {
                    nextMonth[j]++;
                } else {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonth[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonth[j]++;
                    }
                }
            }
        }
        Arrays.sort(nextMonth);
        return nextMonth[friends.length - 1];
    }
}
