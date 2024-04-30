import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        HashMap<String, Integer> termMap = new HashMap<>();
        // each term into termMap
        for (String term : terms) {
            String[] splittedTerm = term.split(" ");
            String alphabet = splittedTerm[0];
            int duration = Integer.parseInt(splittedTerm[1]);
            termMap.put(alphabet, duration);
        }
        
        // privacy 마다 삭제해야 하는지 판단
        int curr = 1;
        for (String privacy : privacies) {
            String[] splittedPrivacy = privacy.split(" ");
            String date = splittedPrivacy[0];
            String term = splittedPrivacy[1];
            int month = termMap.get(term);
            if (isSubjectToDeletion(today, date, month)) {
                answerList.add(curr);
            }
            curr++;
        }
        
        int[] result = new int[answerList.size()];
        for(int i = 0 ; i < answerList.size(); i++){
            result[i] = answerList.get(i);
        }
        return result;
        
    }
    
    private boolean isSubjectToDeletion(String today, String date, int duration) {
        String[] parseDate = date.split("\\.");
        int yearToAdd = Integer.parseInt(parseDate[0]);
        int monthToAdd = Integer.parseInt(parseDate[1]);
        int dayToAdd = Integer.parseInt(parseDate[2]);
        
        String[] parseToday = today.split("\\.");
        int yearToday = Integer.parseInt(parseToday[0]);
        int monthToday = Integer.parseInt(parseToday[1]);
        int dayToday = Integer.parseInt(parseToday[2]);
        
        int totalDays = yearToAdd * 12 * 28 + monthToAdd * 28 + dayToAdd + duration * 28;
        int todayDay = yearToday * 12 * 28 + monthToday * 28 + dayToday;
        
        if (totalDays <= todayDay) {
            return true;
        } else {
            return false;
        }
    }
}
