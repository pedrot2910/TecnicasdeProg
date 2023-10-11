package sistemajavalar;

import java.util.ArrayList;


public class MenuJava {

	private int opcao;
	private boolean operador = true;

	public MenuJava() {

		Planeta python = new Python();
		Planeta javaScript = new JavaScript();
		Planeta Ruby = new Ruby();
		Planeta php = new PhP();
		Planeta csharp = new Csharp();
		Planeta cplus = new Cplus();
		Planeta c = new C();

		ArrayList<Bug> bugs = new ArrayList<>();
		ArrayList<Desenvolvedor> dev = new ArrayList<>();
		ArrayList<Planeta> planetas = new ArrayList<>();
		ArrayList<PlanetasExplodidos> caixao = new ArrayList<>();

		planetas.add(python);
		planetas.add(javaScript);
		planetas.add(Ruby);
		planetas.add(php);
		planetas.add(csharp);
		planetas.add(cplus);
		planetas.add(c);

		Utilidade utilidades = new Utilidade();

		do {
			Mensagens.bemVindo();
			opcao = utilidades.retornoOpcao();

			if (opcao == 1) {

				new Simulacao(planetas, utilidades, bugs, dev, caixao);
				operador = false;
			
			} else if (opcao == 2) {

				new Mensagens(utilidades);

			} else if (opcao == 3) {

				System.out.println("Tchauzinho! Até a próxima!");
				operador = false;
			}

		} while (operador == true);

	}
}
