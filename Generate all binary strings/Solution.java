
class Solution {
  public static List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        printbnstr(n, 0, "", ans);
        return ans;
    }

    public static void printbnstr(int n, int lastplace, String str, List<String> ans) {
        if (n == 0) {
            ans.add(str);
            return;
        }
        printbnstr(n - 1, 0, str + "0", ans);
        if (lastplace == 0) {
            printbnstr(n - 1, 1, str + "1", ans);
        }
    }
}
     
     