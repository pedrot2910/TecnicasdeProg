package lista01;

public class Quest17 {
	public static void main(String arg[]) {
		int A = 20;
		int B = 2;
		
		if(A > 10 || A + B == 20) {
			System.out.println("numero valido");
		}else if (A == B) {
			System.out.println("A eh igual a B");
		}else if (A != 10 && B != 10 && A < 10) {
			System.out.println("A eh menor que 10");
		}else {
			System.out.println("numero nao valido");
		}
	}
}
