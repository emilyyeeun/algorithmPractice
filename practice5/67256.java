class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] keypad = new int[4][3];
        int leftX = 3;
        int leftY = 0;
        
        int rightX = 3;
        int rightY = 2;
        
        for (int number : numbers) {
            switch (number) {
                case 1:
                    leftX = 0;
                    leftY = 0;
                    sb.append("L");
                    break;
                case 2: 
                    if (isRightHand(0, 1, leftX, leftY, rightX, rightY, hand)) {
                        sb.append("R");
                        rightX = 0;
                        rightY = 1;
                    } else {
                        sb.append("L");
                        leftX = 0;
                        leftY = 1;
                    }
                    break;
                case 3:
                    rightX = 0; 
                    rightY = 2;
                    sb.append("R");
                    break;
                case 4:
                    leftX = 1;
                    leftY = 0;
                    sb.append("L");
                    break;
                case 5:
                    if (isRightHand(1, 1, leftX, leftY, rightX, rightY, hand)) {
                        sb.append("R");
                        rightX = 1;
                        rightY = 1;
                    } else {
                        sb.append("L");
                        leftX = 1;
                        leftY = 1;
                    }
                    break;
                case 6:
                    rightX = 1; 
                    rightY = 2;
                    sb.append("R");
                    break;
                case 7:
                    leftX = 2;
                    leftY = 0;
                    sb.append("L");
                    break;
                case 8:
                    if (isRightHand(2, 1, leftX, leftY, rightX, rightY, hand)) {
                        sb.append("R");
                        rightX = 2;
                        rightY = 1;
                    } else {
                        sb.append("L");
                        leftX = 2;
                        leftY = 1;
                    }
                    break;
                case 9:
                    rightX = 2; 
                    rightY = 2;
                    sb.append("R");
                    break;
                case 0:
                    if (isRightHand(3, 1, leftX, leftY, rightX, rightY, hand)) {
                        sb.append("R");
                        rightX = 3;
                        rightY = 1;
                    } else {
                        sb.append("L");
                        leftX = 3;
                        leftY = 1;
                    }
                    break;
            }
        }
        return sb.toString();
    }
    
    private static boolean isRightHand(int currX, int currY, int leftX, int leftY, int rightX, int rightY, String hand) {
        int leftDistance = Math.abs(currX - leftX) + Math.abs(currY - leftY);
        int rightDistance = Math.abs(currX - rightX) + Math.abs(currY - rightY);
        
        if (rightDistance == leftDistance) {
            return (hand.equals("right")) ? true : false;
        } else {
            return (rightDistance > leftDistance) ? false : true;
        }
    
    }



    
    
}
