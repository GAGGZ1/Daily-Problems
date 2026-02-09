class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>map=new HashSet();
        int i=0;
        int j=0;
        int max=0;
        int n=s.length();
        while(j<n){
            if(map.contains(s.charAt(j))){
               map.remove(s.charAt(i));
               i++; 
            }else{
                map.add(s.charAt(j));
                max=Math.max(j-i+1,max);
                j++;
            }
        }
        return max;
    }
}

// more optimised by, moving directly 
// Instead of removing characters step-by-step:

// left++


// We directly move:

// left = lastIndex + 1


// No repeated deletions.
// Fewer operations.
// Cleaner invariant.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {

            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);

            }

            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}