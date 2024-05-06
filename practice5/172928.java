class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[][] map = new int[park.length][park[0].length()];
        
        int startX = 0;
        int startY = 0;
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    // find start point
                    startX = i;
                    startY = j;
                    map[i][j] = 1;
                } else if (park[i].charAt(j) == 'O') {
                    // moveable
                    map[i][j] = 1;
                } else if (park[i].charAt(j) == 'X') {
                    // blocked
                    map[i][j] = 0;
                }
            }
        }
        
        int currX = startX;
        int currY = startY;
        for (String route : routes) {
            
            String direction = route.split(" ")[0];
            int move = Integer.parseInt(route.split(" ")[1]);
            
            currX = checkBlocked(map, currX, currY, direction, move)[0];
            currY = checkBlocked(map, currX, currY, direction, move)[1];
        }
        
        int[] answer = {currX, currY};
        return answer;
    }
    
    private boolean outOfBound(int[][] map, int x, int y) {
        return (x < 0 || y < 0 || x > map.length - 1 || y > map[0].length - 1 || map[x][y] == 0);
    }
    
    private int[] checkBlocked(int[][] map, int x, int y, String direction, int move) {
        int[] answer = new int[2];
        
        int currX = x;
        int currY = y;
        
        for (int i = 1; i < move + 1; i++) {
            if (direction.equals("S")) {
                if (outOfBound(map, currX + 1, currY)) {
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                } else {
                    currX += 1;
                }
            } else if (direction.equals("N")) {
                if (outOfBound(map, currX - 1, currY)) {
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                } else {
                    currX -= 1;
                }
            } else if (direction.equals("W")) {
                if (outOfBound(map, currX, currY - 1)) {
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                } else {
                    currY -= 1;
                }
            } else if (direction.equals("E")) {
                if (outOfBound(map, currX, currY + 1)) {
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                } else {
                    currY += 1;
                }
            }
        }
        answer[0] = currX;
        answer[1] = currY;
        return answer;     
    }
}
