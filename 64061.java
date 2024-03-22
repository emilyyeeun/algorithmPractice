https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack[] stacks = new Stack[board.length];
        // 인형이 들어있는 stack 생성
        for (int i = 0; i < board.length; i++) {            
            for (int j = board[0].length - 1; j >= 0; j--) {
                stacks[i].push(board[j][i]);
            }
        }
        
        // 인형 갯수 카운트
        int counter = 0;
        
        // 인형 바구니
        Stack<Integer> basket = new Stack();
        for (int i = 0; i < moves.length; i++) {
            // 위치
            int curr = moves[i];
            // 해당 위치 스택이 비어있지 않다면
            if (!stacks[curr-1].isEmpty()) {
                // 스택에서 꺼내온다
                int popped = (Integer) stacks[curr-1].pop();
                // 바구니가 비어있지 않다면, 맨 위와 비교
                if (!basket.isEmpty()) {
                    if (basket.peek() == popped) {
                        basket.pop();
                        counter = counter + 2;
                    } else {
                        // 터트릴 수 없다면 추가
                        basket.push(popped);
                    }

                } else { // 바구니가 비어있다면 추가
                    basket.push(popped);
                }
            }
        
        }
        return counter;
    }
}
