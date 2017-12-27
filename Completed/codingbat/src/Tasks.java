/*
public class Tasks {
    public static void main(String[] args) {
//        System.out.println(sameEnds("javaXYZjava"));
//        System.out.println(sumNumbers("abc123xyz"));
//        System.out.println(sameEnds("abXYab"));
//        System.out.println(mirrorEnds("abXYZba"));
//        System.out.println(maxBlock("xyz"));
//        System.out.println(notReplace("This is right"));
//          System.out.println(withoutString("This is a FISH", "IS"));
        System.out.println(sameEnds("abXYab"));
        System.out.println(Math.log(2 ));
    }
    public static String sameEnds(String string) {
        String result = "";
        String result1 = "";
        int j = 0;
        boolean flag = false;
        for (int i = string.length()/2 - 1; i >= 0; i--) {
            if(string.charAt(i) == string.charAt(string.length() - j - 1)){
                j++;
                result += Character.toString(string.charAt(i));
                flag = true;
            }else if(flag){
                return "";
            }
        }
        for (int i = result.length() - 1; i >= 0; i--) {
            result1 += result.charAt(i);
        }
        return result1;
    }
    public boolean equalIsNot(String str) {
        if(str == "") return true;
        int countNOT = 0,
            countIS = 0;
        if(str.charAt(str.length() - 2) == 'i' && str.charAt(str.length() - 1) == 's') countIS++;
        for (int i = 0; i < str.length() - 2; i++) {
            if(str.charAt(i) == 'i' && str.charAt(i + 1) == 's'){
                countIS++;
            }
            if(str.charAt(i) == 'n' && str.charAt(i + 1) == 'o' && str.charAt(i + 2) == 't'){
                countNOT++;
            }
        }
        return countIS == countNOT;
    }
    public static String withoutString(String base, String remove) {
        String result = "";
        boolean flag;
        for (int i = 0; i < base.length() - remove.length(); i++) {
            flag = true;
            for (int j = 0; j < remove.length(); j++) {
                if(Character.toLowerCase(base.charAt(i+j)) != Character.toLowerCase(remove.charAt(j))){
                    flag = false;
                }
            }
            if(flag){
                i += remove.length();
            }
            result += base.charAt(i);
        }

        return result;
    }
    //stri
    //ri
    public static int countYZ(String str) {
        String s = "";
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))){
                s += str.charAt(i);
            }
            if((!Character.isLetter(str.charAt(i)) || i == str.length() - 1) && !s.equals("")){
                if(Character.toLowerCase(s.charAt(s.length() - 1)) == 'z' || Character.toLowerCase(s.charAt(s.length() - 1)) == 'y'){
                    counter++;
                    s = "";
                }
            }
        }
        return counter;
    }

*/
/*
    public static String notReplace(String str) {
        String result = "";
        result += str.charAt(0);
        for (int i = 2; i < str.length(); i++) {
            if(str.charAt(i) == 's' && str.charAt(i-1) == 'i') {
                if (!Character.isLetter(str.charAt(i + 1)) && !Character.isLetter(str.charAt(i - 2))) {
                    result += "s not";
                }
                if (i == str.length() - 1 && !Character.isLetter(str.charAt(i - 2))) {
                    result += "s not";
                }
                if(){
                    result += str.charAt(i);
                }
            }else {
                result += str.charAt(i);
            }
        }
        return result;
    }
*//*


    public static String mirrorEnds(String string) {
        String result= "";
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == string.charAt(string.length() - i - 1)){
                result += Character.toString(string.charAt(i));
            }else{
                return result;
            }
        }
        return result;
    }
    public static int maxBlock(String str) {
        if(str == "") return 0;
        int max = 0,
            counter = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)){
                counter++;
            }else{
                counter = 1;
            }

            if(i == str.length() - 1 && str.charAt(i) == str.charAt(i - 1)) counter++;
            if(counter > max){
                max = counter;
            }

        }
        return max;
    }

    public boolean gHappy(String str) {
        if(str.equals("")) return true;
        if(str.equals("g")) return false;
        if(str.equals("gg")) return true;
        if((int)str.charAt(0) == (int)'g' && (int)str.charAt(1) != (int)'g'){
            return false;
        }
        if((int)str.charAt(str.length() - 1) == (int)'g' && (int)str.charAt(str.length() - 2) != (int)'g'){
            return false;
        }
        boolean flag = false;
        for (int i = 1; i < str.length() - 1; i++) {
            if((int)str.charAt(i) == (int)'g'){
                flag = true;
                if(!((int)str.charAt(i - 1) == (int)'g' || (int)str.charAt(i+1) == (int)'g')){
                    return false;
                }
            }
        }
        return flag;
    }
*/
/*    public static String sameEnds(String string) {
        String result = "";

        for (int i = string.length() / 2; i < 0; i++) {
            if(string.charAt(i) == string.charAt(string.length() - i - 1)){
                result += string.charAt(i);
            }
        }
        boolean flag = false;
        for (int i = 0; i <= s2.length() - s1.length() && !flag; i++) {
            flag = true;
            for (int j = 0; j < s1.length(); j++) {
                if(s1.charAt(j) != s2.charAt(j+i)){
                    flag = false;
                }
            }
        }
        return result;
    }
    public int sumNumbers(String str) {
        int sum = 0;
        if(str == "") return 0;
        String number = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if(Character.isDigit(str.charAt(i))){
                number += str.charAt(i);
                if (!Character.isDigit(str.charAt(i+1))){
                    sum += Integer.parseInt(number);
                    number = "";
                }
            }
        }
        if(Character.isDigit(str.charAt(str.length() - 1))) {
            number += str.charAt(str.length() - 1);
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    public String withoutString(String base, String remove) {
        for (int i = 0; i < ; i++) {
            if()
        }
    }
*//*

    public int countTriple(String str) {
    int counter = 0;
        for (int i = 1; i < str.length() - 1; i++) {
            if((int)str.charAt(i - 1) == (int)str.charAt(i) && (int)str.charAt(i) == (int)str.charAt(i + 1)){
                counter++;
            }
        }
    return counter;
    }
    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                sum += Character.digit(str.charAt(i), 10);
            }
        }
        return sum;
    }
*/
/*
    public static String sameEnds(String string) {
        boolean flag;
        String result = "";
        int length;
        for (int i = string.length()/2 - 1; i > 0; i--) {
            length = 0;
            flag = true;
            for (int j = string.length() - 1; j > string.length()/2 && flag; j--) {
                if(string.charAt(i) != string.charAt(j)){
                    flag = false;
                }
                length++;
            }
            if(flag){
                for (int j = 0; j < length; j++) {
                    result += string.charAt(i);
                }
                return result;
            }
        }
        return result;
    }
*//*




}
*/
