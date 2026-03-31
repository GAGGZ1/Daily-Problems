class Solution {
    public int longestKSubstr(String s, int k) {
        HashMap<Character,Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        int maxlen=-1;
        while(right<s.length()){
            // 1. add kro right
            char r=s.charAt(right);
            map.put(r,map.getOrDefault(r,0)+1);
            right++;
            // 2. move window
            if(map.size()>k){
                char l=s.charAt(left);
                map.put(l,map.get(l)-1);
                if(map.get(l)==0){
                    map.remove(l);
                    
                }
                left++;
            }
            
            // 3. if equal return kro
            if(map.size()==k){
                maxlen=Math.max(maxlen,right-left);
            }
        }
        return maxlen;
        
    }
}