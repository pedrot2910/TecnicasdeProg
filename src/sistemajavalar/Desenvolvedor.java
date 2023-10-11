package sistemajavalar;

import java.util.ArrayList;
import java.util.Random;

public class Desenvolvedor extends Personagem implements InterfaceD{

	public Desenvolvedor(int x, int y) {
		super(x, y);
		
	}

	public static void criarDesenvolvedores(int quantdev,ArrayList<Desenvolvedor> desenvs, ArrayList<Bug> bugs) {
		Random random = new Random();
		
		boolean [][] posiOcupadas = new boolean [16][16];
		
		
		int x = 0;
		int y = 0;
		
		for(Bug bug : bugs) {
			x = bug.getX();
			y = bug.getY();
			
			posiOcupadas[x][y] = true;
		}
		
		for (int i = 0; i < quantdev; i++) {
			
			do {
				x = random.nextInt(15) + 1;
				y = random.nextInt(15) + 1;
			} while (posiOcupadas[x][y] == true);
			
			Desenvolvedor desenvolvedor = new Desenvolvedor(x, y);
			desenvs.add(desenvolvedor);
			posiOcupadas[x][y] = true;
		}
	}
	
	public static void EncontrocomDesenvolvedores(ArrayList<Planeta> planetas, ArrayList<Desenvolvedor> desenvolvedor) {
		ArrayList<Desenvolvedor> remoDev = new ArrayList<>();
		
		System.out.println("\n");
		for(Planeta planeta : planetas) {
			int velotrans = planeta.getVeloTrans();
			int devQuant = planeta.getDevQuant();
			for(Desenvolvedor desenvs : desenvolvedor) {
				if(planeta.getPosicaox() == desenvs.getX() && planeta.getPosicaoy() == desenvs.getY()) {
					System.out.println("Houve uma colisão do planeta " + planeta.getNome() + " com um Desenvolvedor na posicao ("
							+ planeta.getPosicaox() + "," + planeta.getPosicaoy() + ")");
					planeta.setDevQuant(devQuant + 1);
					planeta.setVeloTrans(velotrans - 1);
					remoDev.add(desenvs);
				}
			}
		}
		
		desenvolvedor.removeAll(remoDev);
		
	}

}
