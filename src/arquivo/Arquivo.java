package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import arvoreBinaria.ArvoreBinaria;

public class Arquivo {

	private File file;
	private ArvoreBinaria Arvore;

	public Arquivo() {
	}

	public Arquivo(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public ArvoreBinaria getArvore() {
		return Arvore;
	}

	public void setArvore(ArvoreBinaria arvore) {
		Arvore = arvore;
	}

	public void lerArquivo() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linha = br.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void pesquisarPalavras(String palavras) {
		String[] vetor = palavras.split(" ");
		Arvore = new ArvoreBinaria();
		
		for (String s : vetor) {
			Arvore.inserir(s);
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linha = br.readLine();
			int j = 1;
			while (linha != null) {
				for (int i = 0; i < vetor.length; i++) {
					if (linha.contains(vetor[i])) {
						Arvore.addLinha(vetor[i], j);
					}
				}
				linha = br.readLine();
				j++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
