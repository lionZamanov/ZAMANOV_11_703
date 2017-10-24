import java.util.Scanner;

public class Task5{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int
			n = in.nextInt(),
			m = 1,
			p = 1;
		double S = 0;

		while(m <= n){
			S  += p*1.0/(2*m-1);
			p = -p;
			m++;
		}

		System.out.println(S);


	}
}