class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>res=new ArrayList<>();
        int left=0;
        int right=0;
        int count=p.length();
        int freq[]=new int[26];
        for(char c: p.toCharArray()){
            freq[c-'a']++;
        }
        while(right<s.length()){
            // 1. right ko add kro
            char r=s.charAt(right);
            if(freq[r-'a']>0){
                count--;
            }
            freq[r-'a']--;
            right++;

            if(count==0){
                res.add(left);
            }

            //2. window move kro
            if (right - left == p.length()) {
                if (freq[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                freq[s.charAt(left) - 'a']++;
                left++;
            }


        }
        return res;
    }
}