package application.models;


public class Jogador {
	private int idJogador;
	private String nome;
	private int nivel;
	private int qtdMoedas;
	private int expNovoNivel;


	public Jogador(int idJogador, String nome, int nivel, int qtdMoedas, int expNovoNivel) {
		super();
		this.expNovoNivel = expNovoNivel;
		this.nivel = nivel;
		this.nome = nome;
		this.qtdMoedas = qtdMoedas;
		this.idJogador = idJogador;

	}

	public Jogador(String nome) {
		super();
		this.nome = nome;
		this.nivel = 0;
		this.qtdMoedas = 0;
		this.idJogador = 0;
		this.expNovoNivel = 0;

	}

	public Jogador() {
		super();
		this.nome = "";
		this.nivel = 0;
		this.qtdMoedas = 0;
		this.idJogador = 0;
		this.expNovoNivel = 0;

	}

	public int getExpNovoNivel() {
		return this.expNovoNivel;
	}

	public int getIdJogador() {
		return this.idJogador;
	}

	public int getNivel() {
		return this.nivel;
	}

	public String getNome() {
		return this.nome;
	}

	public int getQtdMoedas() {
		return this.qtdMoedas;
	}

	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setQtdMoedas(int qtdMoedas) {
		this.qtdMoedas = qtdMoedas;
	}

	public void setExpNovoNivel(int expNovoNivel) {
		this.expNovoNivel = expNovoNivel;
	}

	@Override
	public String toString() {
		return "ID: " + getIdJogador() + " nome:" + getNome() + " Experiencia:" + getExpNovoNivel() + " nivel:"
				+ getNivel() + " Moedas:" + getQtdMoedas() + "\n";
	}

}
