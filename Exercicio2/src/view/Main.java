package view;

import java.util.Scanner;

import controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		String os = controller.indentificaSO();
		int opcao = 0;
		
		while(opcao !=  9) {
			System.out.println("Opçoes: \n 1 - Listar Processos \n 2 - Matar por PID \n 3 - Matar por Nome \n 9 - Finalizar");
			opcao = sc.nextInt();
			System.out.println("================");
			switch (opcao) {
			case 1:
				controller.listarProcessos(os);
				break;
			case 2:
				System.out.println("Informe o PID");
				int pid = sc.nextInt();
				controller.matarProcessoPID(pid, os);
				break;
			case 3:
				System.out.println("Informe o Nome");
				String nome = sc.next();
				controller.matarProcessoNome(nome, os);
				break;
			case 9:
				System.out.println("Finalizado");
				break;
				
			default:
				break;
			}
		}
		
		sc.close();
	}

}
