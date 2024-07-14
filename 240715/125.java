class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s.equals(" ") || s == null) {
            return true;
        }
        String str = s.trim().replaceAll(
          "[^a-zA-Z0-9]", "").toLowerCase();
        int firstPointer = 0;
        int secondPointer = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(firstPointer) != str.charAt(secondPointer)) {
                return false;
            }
            firstPointer++;
            secondPointer--;
        }
        return true;
    }
}
