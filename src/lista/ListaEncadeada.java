package lista;

public class ListaEncadeada {

	private NoDuplamenteEncadeado inicio;
	private NoDuplamenteEncadeado fim;

	protected int quantidade;

	public ListaEncadeada() {
		this.inicio = null;
		this.fim = inicio;
		this.quantidade = 0;
	}

	public NoDuplamenteEncadeado getInicio() {
		return inicio;
	}

	public void setInicio(NoDuplamenteEncadeado inicio) {
		this.inicio = inicio;
	}

	public NoDuplamenteEncadeado getFim() {
		return fim;
	}

	public void setFim(NoDuplamenteEncadeado fim) {

		this.fim = fim;
	}

	// retorna o tamanho do No
	public int getQuantidade() {
		return this.quantidade;
	}

	// metodo para criar uma lista
	public void criarLista(Integer elemento) {
		if (this.inicio == null) {
			inicio = new NoDuplamenteEncadeado();
			fim = inicio;
			NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
			novoNo.setElemento(elemento);
			novoNo.setProx(null);
			novoNo.setAnt(null);
			fim.setProx(novoNo);
			inicio = fim = novoNo;
			quantidade++;

		} else {
			// caso a lista ja exista ser� chamado o metodo
			inserirNoFim(elemento);
		}
	}

	public boolean inserirNoInicio(Integer elemento) {
		if (this.inicio == null) {
			criarLista(elemento);
			return true;
		}
		NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
		novoNo.setElemento(elemento);
		novoNo.setProx(inicio);
		novoNo.setAnt(null);
		inicio = novoNo;
		quantidade++;
		return true;
	}

	// metodo para inserir um elemento no final da lista
	public boolean inserirNoFim(Integer elemento) {
		if (quantidade != 0) {
			NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
			novoNo.setElemento(elemento);
			novoNo.setProx(null);
			novoNo.setAnt(fim);
			fim.setProx(novoNo);
			fim = novoNo;
			quantidade++;
			return true;
		} else {
			criarLista(elemento);
		}
		return false;
	}

	public boolean removerElemento(Integer elemento) {

		NoDuplamenteEncadeado aux = new NoDuplamenteEncadeado();
		aux = inicio;
		for (int i = quantidade; i > 0; i--) {
			if (elemento == aux.getElemento()) {
				// caso so tenha um elemento na lista
				if (aux.getAnt() == null && aux.getProx() == null) {
					inicio = fim = null;
					return true;
				}
				// caso o elemento seja o primeiro da lista
				else if (aux.getAnt() == null && aux.getProx() != null) {
					inicio = null;
					inicio = aux.getProx();
					quantidade--;
					return true;
				}
				// caso o elemento seja o ultimo da lista
				else if (aux.getAnt() != null && aux.getProx() == null) {
					fim = null;
					fim = aux.getAnt(); // pegando o endere�o de memeria anteria
					aux.getAnt().setProx(null); // apangando o endere�o de memoria do proximo
					quantidade--;
					return true;
				}
				// caso o elemento esteja no meio da lista
				else if (aux.getAnt() != null && aux.getProx() != null) {
					aux.getAnt().setProx(aux.getProx());
					aux.getProx().setAnt(aux.getAnt());
					quantidade--;
					return true;

				}

			}
			aux = aux.getProx();
		}
		return false;
	}

	// passe um referencia de localiza��o metodo n�o finalizado
	public boolean inserirNoMeio(Integer elemento) {
		if (this.inicio == null) {
			criarLista(elemento);
			return true;
		} else {
			NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
			novoNo.setElemento(elemento);

		}
		return false;
	}

	public boolean listarElementos() {
		if (this.inicio == null) {
			System.out.println("[]");
			return false;
		}
		NoDuplamenteEncadeado aux = this.inicio;

		while (aux != null) {
			System.out.print(aux.getElemento() + " ");
			aux = aux.getProx();
		}
		return true;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		NoDuplamenteEncadeado aux = this.inicio;
		while (aux != null) {
			sb.append(aux + " ");
			aux = aux.getProx();
		}
		return sb.toString();
	}
	
}
