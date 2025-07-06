class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    
    public class Pair{
        int st;
        int en;
        
        Pair(int st,int en){
            this.st=st;
            this.en=en;
        }
        
        
    } 
    public int maxMeetings(int start[], int end[]) {
       
       ArrayList<Pair>ls=new ArrayList<>();
       for(int i=0;i<start.length;i++){
           ls.add(new Pair(start[i],end[i]));
       }
        ls.sort((a, b) -> {
        if (a.en == b.en) {
            return a.st - b.st; 
        }
        return a.en - b.en;
    });
       int prevSt=ls.get(0).st;
       int prevEn=ls.get(0).en;
       
       int count=1;
       for(int i=1;i<ls.size();i++){
          Pair p=ls.get(i);
          
          System.out.println(p.st+" "+p.en);
        
            int nextSt=p.st;
            int nextEn=p.en;
            
            if(prevEn<nextSt){
                count++;
                prevEn=nextEn;
                prevSt=nextSt;
                
            }
            
       }
       return count;
       
    }
}
