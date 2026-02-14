class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(String s:strs){
            char[]c=s.toCharArray();
            Arrays.sort(c);
            String chars=new String(c);
            map.putIfAbsent(chars,new ArrayList<>());
            map.get(chars).add(s);
        }
        List<List<String>>ls=new ArrayList<>();
        for(List<String>l:map.values()){
            ls.add(l);
        }
        return ls;
    }
}