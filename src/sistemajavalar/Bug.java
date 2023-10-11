package sistemajavalar;

import java.util.Random;
import java.util.ArrayList;

public class Bug extends Personagem implements InterfaceB{

	public Bug(int x, int y) {
		super(x, y);
		
	}
	
	public static void criarBug(int quantBug, ArrayList<Bug> bugs, ArrayList<Desenvolvedor> desenvs) {
		Random random = new Random();
		boolean[][] posiOcupadas = new boolean [16][16];
		int x = 0;
		int y = 0;
		
		for (Desenvolvedor desenvolvedor : desenvs) {
			x = desenvolvedor.getX();
			y = desenvolvedor.getY();
			
			posiOcupadas[x][y] = true;
			
		}
		
		for(int i = 0; i < quantBug; i++) {
			
			do {
				x = random.nextInt(15) + 1;
				y = random.nextInt(15) + 1;
			} while(posiOcupadas[x][y] == true || (x == 8 && y == 8));
			
			Bug bug = new Bug(x, y);
			bugs.add(bug);
			posiOcupadas[x][y] = true;
			
		}
			
			
		}
	public static void EncontrocomBugs(ArrayList<Planeta> planetas, ArrayList<Bug> bugs,
			ArrayList<PlanetasExplodidos> caixao) {
		
		ArrayList<Bug> remoBug = new ArrayList<>();
		ArrayList<Planeta> remoPlaneta = new ArrayList<>();
		
		for (Planeta planeta : planetas) {
			int velotrans = planeta.getVeloTrans();		
			int bugQuant = planeta.getBugQuant();
			
			for(Bug bug : bugs) {
				if(planeta.getPosicaox() == bug.getX() && planeta.getPosicaoy() == bug.getY()) {
					System.out.println("Houve uma colisão do planeta " + planeta.getNome() + " com um bug na posicao ("
							+ planeta.getPosicaox() + "," + planeta.getPosicaoy() + ")");
					planeta.setBugQuant(bugQuant + 1);
					planeta.setVeloTrans(velotrans - 1);
					remoBug.add(bug);
				}
			}
			
			if(planeta.getVeloTrans() == 0) {
				remoPlaneta.add(planeta);
				
				PlanetasExplodidos planetaExplodido = new PlanetasExplodidos();
				
				planetaExplodido.setNome(planeta.getNome());
				caixao.add(planetaExplodido);
				
			}
		}
		System.out.println("\n");
		for(Planeta planeta : remoPlaneta) {
			System.out.println("--> O planeta " + planeta.getNome() + " explodiu.");
		}
		
		planetas.removeAll(remoPlaneta);
		bugs.removeAll(remoBug);
	}
	

}
