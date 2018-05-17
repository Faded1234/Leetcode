package suanfa.String;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-14 22:02
 */
public class Solution_38_1 {
    public static void main(String[] args) {
        countAndSay(3);
    }
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String s = getString("1");
        for(int i = 0; i < n-2; ++i){
            s = getString(s);
        }
        return s;
    }
    private static String getString(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int num;
        for(int i = 0; i < chars.length;){
            num = 1;
            for(int j = i+1; j < chars.length; j++){
                if(chars[j] == chars[i])
                    ++num;
                else break;
            }
            sb.append(num).append(chars[i]);
            i+=num;
        }
        return sb.toString();
    }
}

/*
* String currentStr = "1";
        for (int i = 1; i < n; i++) {
            int countNumber = 0;
            int sayNumber = 0;
            StringBuilder builder = new StringBuilder();
            char[] chars = currentStr.toCharArray();
            for (char c : chars) {
                int num = c - '0';
                if (sayNumber != num) {
                    if (sayNumber != 0) {
                        builder.append(countNumber);
                        builder.append(sayNumber);
                    }
                    sayNumber = num;
                    countNumber = 1;
                } else {
                    countNumber++;
                }
            }
            builder.append(countNumber);
            builder.append(sayNumber);
            currentStr = builder.toString();
        }
        return currentStr;
* */