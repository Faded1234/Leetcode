public class Solution_58 {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        if(s1.length == 0) return 0;
        int length = s1[s1.length-1].length();
        return length;
    }
}
