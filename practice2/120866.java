https://school.programmers.co.kr/learn/courses/30/lessons/120866

// 1st try: brute force로 풀이 (fail)
class Solution {
    public int solution(int[][] board) {
        int[][] copy = board;
        int num = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    copy[i][j] = 1;
                    if (i != 0 && j != 0 && i < board.length - 1 && j < board[0].length - 1) {
                        
                        copy[i-1][j-1] = 1;
                        copy[i-1][j] = 1;
                        copy[i-1][j+1] = 1;
                        copy[i+1][j+1] = 1;
                        copy[i+1][j-1] = 1;
                        copy[i+1][j] = 1;    
                        copy[i][j+1] = 1;
                        copy[i][j-1] = 1;
                        
                    } else if (i == 0) { 
                        if (j == 0) {
                            copy[i+1][j+1] = 1;
                            copy[i+1][j] = 1;                           
                            copy[i][j+1] = 1;
                        } else if (j == board.length - 1) {
                            copy[i+1][j-1] = 1;
                            copy[i+1][j] = 1;                           
                            copy[i][j-1] = 1;
                        } else {
                            copy[i+1][j+1] = 1;
                            copy[i+1][j-1] = 1;
                            copy[i+1][j] = 1;                           
                            copy[i][j+1] = 1;
                            copy[i][j-1] = 1;
                        }

                    } else if (i == board.length - 1) {
                        if (j == board.length - 1) {
                            copy[i-1][j-1] = 1;
                            copy[i-1][j] = 1;
                            copy[i][j-1] = 1;
                        } else if (j == 0) {
                            copy[i-1][j] = 1;
                            copy[i-1][j+1] = 1;                            
                            copy[i][j+1] = 1;
                        } else {
                            copy[i-1][j-1] = 1;
                            copy[i-1][j] = 1;
                            copy[i-1][j+1] = 1;
                            copy[i][j+1] = 1;
                            copy[i][j-1] = 1;
                        }
                    } else if (j == 0) { 
                        copy[i-1][j] = 1;
                        copy[i-1][j+1] = 1;                        
                        copy[i+1][j+1] = 1;
                        copy[i+1][j] = 1;                           
                        copy[i][j+1] = 1;
                   } else if (j == board[0].length - 1) {
                        copy[i-1][j-1] = 1;
                        copy[i-1][j] = 1;
                        copy[i+1][j-1] = 1;
                        copy[i+1][j] = 1;
                        copy[i][j-1] = 1;
                }   
                                    
                }
            }
        }
        
    
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(copy[i][j]);
                
                if (copy[i][j] == 0) {
                    num++;
                }
            }
        }
        
        return num;
    }
}
