class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nStr=String.valueOf(n);
        int noOfDigits=digits.length;
        int lenNStr=nStr.length();

        int total=0;
        // 1. case jab no of digits less
        for(int i=1;i<lenNStr;i++){
            total+=Math.pow(noOfDigits,i);
        }
        
        // 2. jab equal hai
        for(int i=0;i<lenNStr;i++){
            boolean isSame=false;
            for(String d:digits){
                if(d.charAt(0)<nStr.charAt(i)){
                    total+=Math.pow(noOfDigits,lenNStr-i-1);
                }
                else if(d.charAt(0)==nStr.charAt(i)){
                    isSame=true;
                }
            }
            if(!isSame){ // equal digits exisits continue
                return total;
            }
        }
        return total+1;
    }
}