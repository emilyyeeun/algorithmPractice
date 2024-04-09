import java.util.*;
class Solution {
	public String[] solution(String[] quiz) {
		String[] result = new String[quiz.length];
		int i = 0;
		for (String s: quiz) {
			String[] splitted = s.split(" ");
			int firstNum = Integer.parseInt(splitted[0]);
			String op = splitted[1];
			int secondNum = Integer.parseInt(splitted[2]);
			int answer = Integer.parseInt(splitted[4]);
			        if (isAddition(op)) {
            if (firstNum + secondNum == answer) {
                result[i] = "O";
            } else {
                result[i] = "X";
            }
        } else {
            if (firstNum - secondNum == answer) {
                result[i] = "O";
            } else {
                result[i] = "X";
            }
        }
        i++;

    }
    return result;
}

	private boolean isAddition(String op) {
	    if (op.equals("-")) {
            return false;
        } else {
            return true;
        }
    }
}
