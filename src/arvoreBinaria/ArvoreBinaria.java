package arvoreBinaria;

public class ArvoreBinaria {

	private No node;

	public ArvoreBinaria() {
		node = null;
	}

	public No getNo() {
		return node;
	}

	public void setNo(No no) {
		this.node = no;
	}

	public void inserir(String elemento) {
		No novo = new No(); // cria um novo N�
		novo.setelemento(elemento); // atribui o valor recebido ao item de dados do N�
		novo.setDireito(null);
		novo.setEsquerdo(null);

		if (node == null) { // se Raiz � igual a null
			node = novo;
		} else { // se nao for a raiz
			No atual = node;
			No anterior;
			while (true) {
				anterior = atual;
				int esquerdo = elemento.compareTo(atual.getelemento());
				if (esquerdo <= 0) { // ir para esquerda
					atual = atual.getEsquerdo();
					if (atual == null) {
						anterior.setEsquerdo(novo);
						return;
					}
				} // fim da condi��o ir a esquerda
				else { // ir para direita
					atual = atual.getDireito();
					if (atual == null) {
						anterior.setDireito(novo);
						return;
					}
				} // fim da condi��o ir a direita
			} // fim do la�o while
		} // fim do else n�o raiz

	}

	public No buscar(String chave) {
		if (node == null)
			return null; // se arvore vazia
		No atual = node; // come�a a procurar desde raiz
		while (atual.getelemento() != chave) { // enquanto nao encontrou
			if ( 0 >= chave.compareTo(atual.getelemento()))
				atual = atual.getEsquerdo(); // caminha para esquerda
			else
				atual = atual.getDireito(); // caminha para direita
			if (atual == null)
				return null; // encontrou uma folha -> sai
		} // fim la�o while
		return atual; // terminou o la�o while e chegou aqui � pq encontrou item
	}
	
	public boolean addLinha(String elemento, int i) {
		if(node == null) {
			return false;
		}
		No atual = node;
		boolean flag = false;
		while(flag != true) {
			if(atual.getelemento().equals(elemento)) {
				atual.add(i);
				 flag = true;
			}
			if( 0 >= elemento.compareTo(atual.getelemento())) {
				atual = atual.getEsquerdo();
			}
			else {
				atual = atual.getDireito();
			}
			
		}
		
		return flag;
	}

	public No removeValorMinimoDaArvore(No node) {
		if (node == null) {
			System.out.println(" ERROR! ");
		} else if (node.getEsquerdo() != null) {
			node.setEsquerdo(removeValorMinimoDaArvore(node.getEsquerdo()));
			return node;
		} else {
			// Se n�o tiver elemento esquerdo s� nos resta o da direita
			return node.getDireito();
		}
		return null;
	}

	public boolean remover_ArvoreBinaria(String elemento) {
		if (node == null) {// caso node for null retorna falso
			return false;
		}
		No atual = node;
		No ant = null;
		while (atual != null) {// enquato atual diferente de null
			if (elemento.equals(atual.getelemento())) { // se valor for igual a valor de atual
				if (atual == node) {
					node = removerElemento(atual);
				} else {
					if (ant.getDireito() == atual) {
						ant.setDireito(removerElemento(atual)); // anterior-direito recebe valor do endere�o do novo no
					} else {
						ant.setEsquerdo(removerElemento(atual)); // anterior-esquerdo recebe valor do endere�o do novo
																	// no
					}
				}
				return true; // retorna verdadeiro se valor for removido
			}
			ant = atual;
			if (0 <= elemento.compareTo(atual.getelemento())) {
				atual = atual.getDireito();
			} else {
				atual = atual.getEsquerdo();
			}
		}

		return false; // falso para valores n�o encontrado
	}

	private No removerElemento(No no) {
		No no1 = null;
		No no2 = null;

		if (no.getEsquerdo() == null) {
			no2 = no.getDireito();
			return no2;
		}
		no1 = no;
		no2 = no.getEsquerdo();
		while (no2.getDireito() != null) {
			no1 = no2;
			no2 = no2.getDireito();
		}
		if (no1 != no) {
			no1.setDireito(no2.getEsquerdo());
			no2.setEsquerdo(no.getEsquerdo());
		}
		no2.setDireito(no.getDireito());
		return no2;
	}

	public void caminhar() {
		System.out.print("\n Exibindo em ordem: ");
		inOrder(node);
		System.out.print("\n Exibindo em pos-ordem: ");
		posOrder(node);
		System.out.print("\n Exibindo em pre-ordem: ");
		preOrder(node);
		System.out.print("\n Altura da arvore: " + altura(node));
		System.out.print("\n Quantidade de folhas: " + folhas(node));
		System.out.print("\n Quantidade de N�s: " + contarNos(node));
		if (node != null) { // se arvore nao esta vazia
			System.out.print("\n Valor minimo: " + min().getelemento());
			System.out.println("\n Valor maximo: " + max().getelemento());
		}
	}

	public void inOrder(No atual) {
		if (atual != null) {
			inOrder(atual.getEsquerdo());
			System.out.print(atual.getelemento() + " ");
			inOrder(atual.getDireito());
		}
	}

	public void preOrder(No atual) {
		if (atual != null) {
			System.out.print(atual.getelemento() + " ");
			preOrder(atual.getEsquerdo());
			preOrder(atual.getDireito());
		}
	}

	public void posOrder(No atual) {
		if (atual != null) {
			posOrder(atual.getEsquerdo());
			posOrder(atual.getDireito());
			System.out.print(atual.getelemento() + " ");
		}
	}

	public int altura(No atual) {
		if (atual == null || (atual.getEsquerdo() == null && atual.getDireito() == null))
			return 0;
		else {
			if (altura(atual.getEsquerdo()) > altura(atual.getDireito()))
				return (1 + altura(atual.getEsquerdo()));
			else
				return (1 + altura(atual.getDireito()));
		}
	}

	public int folhas(No atual) {
		if (atual == null)
			return 0;
		if (atual.getEsquerdo() == null && atual.getDireito() == null)
			return 1;
		return folhas(atual.getEsquerdo()) + folhas(atual.getDireito());
	}

	public int contarNos(No atual) {
		if (atual == null)
			return 0;
		else
			return (1 + contarNos(atual.getEsquerdo()) + contarNos(atual.getDireito()));
	}

	public No min() {
		No atual = node;
		No anterior = null;
		while (atual != null) {
			anterior = atual;
			atual = atual.getEsquerdo();
		}
		return anterior;
	}

	public No max() {
		No atual = node;
		No anterior = null;
		while (atual != null) {
			anterior = atual;
			atual = atual.getDireito();
		}
		return anterior;
	}

}
