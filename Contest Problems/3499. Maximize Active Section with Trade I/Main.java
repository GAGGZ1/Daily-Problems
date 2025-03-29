class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        
        Result result = maxValidBinarySubstring(s);
        System.out.println("Max Substring: " + result.substring);
        System.out.println("Max Length: " + result.length);
        System.out.println("Start Index: " + result.startIndex);
        System.out.println("End Index: " + result.endIndex);
        char[] arr=s.toCharArray();
        int n=arr.length;
        for(int i=result.startIndex;i<=result.endIndex;i++){
           arr[i]='1';
        }int count=0;
        for(int i=0;i<n;i++){
        if(arr[i]=='1'){
            count++;
        }
        }return count;
    }
   
    public static Result maxValidBinarySubstring(String s) {
        int n = s.length();
        String maxSubstring = "";
        int maxLen = 0;
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {  // Start with '0'
                int j = i;
                boolean foundOne = false;
                int countOne = 0;

                while (j < n) {
                    if (s.charAt(j) == '1') {
                        if (!foundOne) {
                            foundOne = true;  // First sequence of '1's starts
                        }
                        countOne++;
                    } else if (foundOne) {  // First '0' after the sequence of '1's
                        int k = j;  // Find the last '0' before another '1'
                        while (k < n && s.charAt(k) == '0') {
                            k++;
                        }
                        if (k == n || s.charAt(k) == '1') {  // If another '1' appears, stop
                            String substring = s.substring(i, k);
                            int length = k - i;
                            if (length > maxLen) {
                                maxLen = length;
                                maxSubstring = substring;
                                startIndex = i;
                                endIndex = k - 1;
                            }
                            break;
                        }
                    }
                    j++;
                }
            }
        }
        return new Result(maxSubstring, maxLen, startIndex, endIndex);
    }

   
}

// Helper class to store the result
class Result {
    String substring;
    int length;
    int startIndex;
    int endIndex;

    public Result(String substring, int length, int startIndex, int endIndex) {
        this.substring = substring;
        this.length = length;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}

