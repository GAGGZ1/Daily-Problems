import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] firstList = {
            {0, 2},
            {5, 10},
            {13, 23},
            {24, 25}
        };

        int[][] secondList = {
            {1, 5},
            {8, 12},
            {15, 24},
            {25, 26}
        };

        int n1 = firstList.length;
        int n2 = secondList.length;

        System.out.println("// Step 1: Creating pairfirst from firstList with +1 and -1");
        List<int[]> pairfirst = new ArrayList<>();
        for (int[] interval : firstList) {
            pairfirst.add(new int[]{interval[0], +1});
            pairfirst.add(new int[]{interval[1], -1});
            System.out.println("Added to pairfirst: [" + interval[0] + ", +1], [" + interval[1] + ", -1]");
        }

        System.out.println("\n// Step 2: Creating pairsecond from secondList with +1 and -1");
        List<int[]> pairsecond = new ArrayList<>();
        for (int[] interval : secondList) {
            pairsecond.add(new int[]{interval[0], +1});
            pairsecond.add(new int[]{interval[1], -1});
            System.out.println("Added to pairsecond: [" + interval[0] + ", +1], [" + interval[1] + ", -1]");
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;

        System.out.println("\n// Step 3: Traversing both lists using ptr1 and ptr2");
        while (ptr1 < pairfirst.size() && ptr2 < pairsecond.size()) {
            int[] l1 = pairfirst.get(ptr1);
            int[] l2 = pairsecond.get(ptr2);

            int u1 = l1[0];
            int v1 = l1[1];
            int u2 = l2[0];
            int v2 = l2[1];

            System.out.println("\nComparing:");
            System.out.println("  pairfirst[ptr1=" + ptr1 + "] = [" + u1 + ", " + v1 + "]");
            System.out.println("  pairsecond[ptr2=" + ptr2 + "] = [" + u2 + ", " + v2 + "]");

            if (u1 < u2) {
                System.out.println("  u1 < u2 -> Checking if v1 > 0 and v2 < 0");
                if (v1 > 0 && v2 < 0) {
                    System.out.println("    Found valid pair -> Adding [" + u1 + ", " + u2 + "]");
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(u1);
                    temp.add(u2);
                    result.add(temp);
                }
                ptr1++;
                System.out.println("  Moving ptr1 to " + ptr1);
            }
            else if(u1==u2){
              if(v1==-1 || v2==-1){
                ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(u1);
                    temp.add(u2);
                    result.add(temp);
              }
            }
            
            
            
            else {
                System.out.println("  u1 >= u2 -> Checking if v1 < 0 and v2 > 0");
                if (v1 < 0 && v2 > 0) {
                    System.out.println("    Found valid pair -> Adding [" + u2 + ", " + u1 + "]");
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(u2);
                    temp.add(u1);
                    result.add(temp);
                }
                ptr2++;
                System.out.println("  Moving ptr2 to " + ptr2);
            }
        }

        System.out.println("\n// Step 4: Final Result");
        for (ArrayList<Integer> a : result) {
            System.out.println("f: " + a.get(0) + " s: " + a.get(1));
        }
    }
}
