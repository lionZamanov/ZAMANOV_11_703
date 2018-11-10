public class Main {
    public static final int A = (int)Math.pow(2,5);
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < Math.pow(2,30); i++) {
            if(compare(nullBuilder(Integer.toBinaryString(i)))){
                count++;
            }
        }
        System.out.println(count);
    }
    public static String binary(int i){
        String n = "";
        while(i > 0){
            n += Integer.toString(i % 2) ;
            i /= 2;
        }
        n = reverse(n);
        return nullBuilder(n);
    }
    public static String reverse(String n){
        String str = "";
        for (int i = n.length(); i > 0; i--) {
            str += n.charAt(i - 1);
        }
        return str;
    }
    public static String nullBuilder(String n){
        String str = "";
        for (int i = 0; i < A - n.length(); i++) {
            str += "0";
        }
        for (int i = 0; i < n.length(); i++) {
            str += n.charAt(i);
        }
        return str;
    }
    public static boolean compare(String binary){
        int c = binary.length();
        String left = binary.substring(0, c/2);
        String right = binary.substring(c/2, c);
        if(c/2 == 1) {
            return left.charAt(0) <= right.charAt(0);
        } else{
            for (int e = 0; e < c/2; e++) {
                if (left.charAt(e) > right.charAt(e)) return false;
            }
            return compare(left) && compare(right);
        }
    }
/*    public static String newString(String a, int flag){
        int c = a.length/2;
        int[] newStr = new int[c];
        if(flag == 0){
            for (int i = 0; i < c; i++) {
                newStr[i] = a[i];
            }
        }else{
            for (int i = 0; i < c; i++) {
                newStr[i] = a[c+i];
            }
        }
        return newStr;
    }*/

}
