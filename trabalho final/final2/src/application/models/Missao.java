package application.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Missao {
	private int idMissao;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private boolean status;
	private String tipo;
	private int quantidade;
	


	public Missao() {
		super();
	}

	public int getIdMissao() {
		return idMissao;
	}

	public void setIdMissao(int idMissao) {
		this.idMissao = idMissao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}




	@Override
	public String toString() {
		String v ="ID Missao: "+idMissao+" Descricao: " + this.descricao + " Status: " + (this.status ? "Completou" : "Não completou") + " Tipo: "
				+ this.tipo+"\n";

		return v;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
