class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[26];
        for (char c : ransomNote.toCharArray()) {
            r[c - 'a']++;
        }
        int[] m = new int[26];
        for (char c : magazine.toCharArray()) {
            m[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (m[i] < r[i]) {
                return false;
            }
        }
        return true;
    }
}