import java.util.Comparator;

public class stringComparator implements Comparator<String> {
    int i;
    public stringComparator(int i){
        this.i = i;
    }
    @Override
    public int compare(String s1, String s2) {
        return s1.charAt(i) - s2.charAt(i);
    }
}
