//1st try. 단순무식 방법으로 o(n^2) 타임아웃
import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> playerList = Arrays.asList(players);
        
        for (String horse: callings) {
            List<String> newList = new ArrayList<String>();
            int index = (playerList.indexOf(horse) - 1) < 0 ? 0 : playerList.indexOf(horse) - 1;
            for (int i = 0; i < index; i++) {
                newList.add(playerList.get(i));
            }
            newList.add(horse);
            for (int i = index; i < playerList.size(); i++) {
                if (i != playerList.indexOf(horse)){
                    newList.add(playerList.get(i));
                }
            }      
            playerList = newList;
        }
        
        String[] result = new String[players.length];
        int i = 0;
        for (String player: playerList) {
            result[i] = player;
            i++;
        }
        return result;             
    }  
}

//2nd try. 해시맵 사용
