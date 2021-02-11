package lista;

public class NoDuplamenteEncadeado {

	private NoDuplamenteEncadeado prox; // apontara para o proximo endere�o de memoria
	private NoDuplamenteEncadeado ant; //apontar� para o eneder�o anterio no endere�o de meroria
	private Integer elemento; //tipo de Objeto
	
	public NoDuplamenteEncadeado(){
	}
	
	public NoDuplamenteEncadeado getProx() {
		return prox;
	}
	public void setProx(NoDuplamenteEncadeado prox) {
		this.prox = prox;
	}
	
	public NoDuplamenteEncadeado getAnt() {
		return ant;
	}

	public void setAnt(NoDuplamenteEncadeado ant) {
		this.ant = ant;
	}

	public Integer getElemento() {
		return elemento;
	}
	public void setElemento(Integer elemento) {
		this.elemento = elemento;
	}
	
	
	@Override
	public String toString() {
		return ""+elemento;
	}
	
}
