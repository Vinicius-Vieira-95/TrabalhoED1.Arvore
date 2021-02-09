package aplication;

import java.io.File;

import arquivo.Arquivo;

public class Program {

	public static void main(String[] args) {
		
		String file = "C:\\TesteArq\\teste.txt";
		File file2 = new File(file);
		
		Arquivo arq = new Arquivo(file2);
		
		arq.pesquisarPalavras("Good easy by not but not");
		
	}
	
}
