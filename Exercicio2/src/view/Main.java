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
			System.out.println("Opçoes: \n 1 - Listar Processos \n 2 - Matar por PID \n 3 - Matar por Nome");
			opcao = sc.nextInt();
			System.out.println("================");
			switch (opcao) {
			case 1:
				controller.listarProcessos(os);
				break;

			default:
				break;
			}
		}
		
		sc.close();
	}

}
