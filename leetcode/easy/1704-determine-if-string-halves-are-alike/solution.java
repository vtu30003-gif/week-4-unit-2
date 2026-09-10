class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int vowelsCount = 0;

        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                vowelsCount++;
            }
            if (isVowel(s.charAt(i + n / 2))) {
                vowelsCount--;
            }
        }

        return vowelsCount == 0;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}