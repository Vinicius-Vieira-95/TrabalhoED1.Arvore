package arvoreBinaria;

import lista.ListaEncadeada;

public class No{

	private No esquerdo;
	private No direito;

	private String elemento;
	private ListaEncadeada lista;
	

	public No() {
		lista = new ListaEncadeada();
	}
	
	public No(String elemento) {
		this.elemento = elemento;
	}

	public No(No esquerdo, No direito, String elemento) {
		super();
		this.esquerdo = esquerdo;
		this.direito = direito;
		this.elemento = elemento;
	}

	public ListaEncadeada getLista() {
		return lista;
	}

	public void setLista(ListaEncadeada lista) {
		this.lista = lista;
	}

	public String getelemento() {
		return elemento;
	}

	public void setelemento(String elemento) {
		this.elemento = elemento;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}
	
	public void add(Integer elemento) {
		lista.inserirNoFim(elemento);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String linha = lista.toString();
		sb.append(this.elemento+" - ");
		sb.append(linha+"\n");
		return sb.toString();
	}
	
}
