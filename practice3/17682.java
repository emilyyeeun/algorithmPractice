import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
class Solution {
    public int solution(String dartResult) {
        // matcher에 주어진 Input 문자열을 패턴에 맞는지 확인하거나 패턴에 일치하는 문자열을 반복해 추출
        String regex = "([0-9]0?)([SDT])([*#]?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dartResult);
        
        int score = 0;
        int prev = 0;
        while (matcher.find()) {
            String curr = matcher.group();
            int[] scores = decode(curr, prev);
            int currScore = scores[0];
            score += currScore;
            prev = scores[1];
        }
        return score;
    }
    
    private static int[] decode(String str, int previous) {
        String intVal = str.replaceAll("[\\D]", "");
        int num = Integer.parseInt(intVal);
        int answer = 0;
        int prev = previous;
        
        if (str.contains("S")) {
            num = (int) Math.pow(num, 1);    
        } else if (str.contains("D")) {
            num = (int) Math.pow(num, 2);    
        } else if (str.contains("T")) {
            num = (int) Math.pow(num, 3);    
        }
        
        if (str.contains("*")) {
            answer = num * 2 + previous;
            prev = num * 2;
        } else if (str.contains("#")) {
            answer = (-1) * num;
            prev = num * (-1);
        } else {
            answer = num;
            prev = num;
        }
        int[] result = new int[2];
        result[0] = answer;
        result[1] = prev;
        return result;     
    }
}
