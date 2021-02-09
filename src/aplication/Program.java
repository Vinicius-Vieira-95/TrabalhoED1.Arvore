package aplication;

import java.io.File;

import arquivo.Arquivo;
import arvoreBinaria.No;

public class Program {

	public static void main(String[] args) {
		
		String file = "C:\\TesteArq\\teste.txt";
		File file2 = new File(file);
		
		Arquivo arq = new Arquivo(file2);
		
		arq.lerArquivo();
		arq.pesquisarPalavras(" vini cecilia easy by not but good");
		
		System.out.println();
		System.out.println();
		arq.getArvore().printOrdem();
		System.out.println();
		
	}
	
}
