class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        for (String s: babbling) {
            if (canPronounce(s)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean canPronounce(String s) {
        String[] strArr = {"aya", "ye", "woo", "ma"};
        String original = s;
        for (String str: strArr) {
            s = s.replace(str, " ");
        }
        
        if (s.trim().length() == 0) {
            return true;
        } 
        
        return false;
    }
}
