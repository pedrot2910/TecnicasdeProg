package lista01;

public class Quest04 {
	public static void main(String arg[]) {
		
		int A = 2;
		int B = 2;
		
		if(A > 10 || A + B == 20) {
			System.out.println("numero valido");
		}else if(A == B) {
			System.out.println("A eh igual a B; A e B são diferentes de 10; A eh menor que 10");
		}else {
			System.out.println("Numero nao valido");
		}
	}


}
