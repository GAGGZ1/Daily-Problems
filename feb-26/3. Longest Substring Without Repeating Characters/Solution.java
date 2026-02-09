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