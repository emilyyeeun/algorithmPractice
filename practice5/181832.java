class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int i = 0;
        int j = 0;
        int curr = 1;
        int direction = 1;

        while (curr <= n * n) { // Corrected the condition here
            answer[i][j] = curr++;

            // Move right
            if (direction == 1) {
                if (j + 1 < n && answer[i][j + 1] == 0) {
                    j++;
                } else {
                    direction = 2;
                    i++;
                }
            }
            // Move down
            else if (direction == 2) {
                if (i + 1 < n && answer[i + 1][j] == 0) {
                    i++;
                } else {
                    direction = 3;
                    j--;
                }
            }
            // Move left
            else if (direction == 3) {
                if (j - 1 >= 0 && answer[i][j - 1] == 0) {
                    j--;
                } else {
                    direction = 4;
                    i--;
                }
            }
            // Move up
            else if (direction == 4) {
                if (i - 1 >= 0 && answer[i - 1][j] == 0) {
                    i--;
                } else {
                    direction = 1;
                    j++;
                }
            }
        }
        return answer;
    }
}
