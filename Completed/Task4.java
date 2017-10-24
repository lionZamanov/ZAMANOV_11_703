import java.util.Scanner;

public class Task4{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int
			n = in.nextInt(),
			m = 1;
		double S = 0;

		while(m <= n){
			S  += 1.0/m;
			m++;
		}

		System.out.println(S);


	}
}