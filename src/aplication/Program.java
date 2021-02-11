package aplication;

import java.io.File;
import java.util.Scanner;

import arquivo.Arquivo;
import arvoreBinaria.No;

public class Program {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		String arquivo = "C:\\TesteArq\\teste.txt";
		File file2 = new File(arquivo);
		Arquivo arq = new Arquivo(file2);
		
		
		arq.lerArquivo();
		System.out.println();
		System.out.println("Selecione as palavras para gerar o indice remissivo");
		System.out.println("Ex: gato cachorro passaro rato.");
		String palavras = sc.nextLine();
		arq.pesquisarPalavras(palavras);
		
		System.out.println("Resultado da pesquisa");
		arq.getArvore().printOrdem();
		System.out.println();
		sc.close();
		
		
	}
	
}
