package view;

import java.util.Scanner;
import controller.ProcessController;


public class Principal {

	public static void main(String[] args){
		menu();
}
	
	public static void menu() {
		 @SuppressWarnings("resource")
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Digite 1 para ver a lista de processos \nDigite 2 para eliminar processo por PID "
		 		+ "\nDigite 3 para eliminar processo por nome \nDigite 0 para encerrar o programa.");
		 int select = scan.nextInt();
		 ProcessController pcs = new ProcessController();
		 String os = pcs.os();
		 
		 switch (select) {
		 case 0:
			 System.out.println("Sistema encerrado. Stay safe!");
			 System.exit(0);
			 break;
		 case 1:
			 @SuppressWarnings("unused") Scanner scan2 = new Scanner(System.in);
			 System.out.println("Aqui está: \n");
			 pcs.taskList(os);
			 System.out.println("\n");
			 menu();
			 break;
		 case 2:
			 @SuppressWarnings("unused") Scanner scan3 = new Scanner(System.in);
			 System.out.println("Digite o número do PID: ");
			 int pid = scan.nextInt();
			 pcs.processKillerPid(os, pid);
			 System.out.println("\n");
			 menu();
			 break;
		 case 3:
			 @SuppressWarnings("unused") Scanner scan4 = new Scanner(System.in);
			 System.out.println("Digite o nome do processo: ");
			 String name = scan.next();
			 pcs.processKillerName(os, name);
			 System.out.println("\n");
			 menu();
			 break;
		default:
			 System.out.println("Opção inválida! Digite de 0 a 3. \n");
			 System.out.println("\n");
			 menu();
		 }
	}
}

