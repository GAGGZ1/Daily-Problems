class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        Stack<Integer>st=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            int g=st.isEmpty()?-1:st.peek();
            map.put(nums2[i],g);
            st.push(nums2[i]);
        }
        int res[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
}