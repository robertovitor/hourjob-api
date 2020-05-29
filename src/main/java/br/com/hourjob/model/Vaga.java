package br.com.hourjob.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Vaga {

	public Vaga() {}

	public Vaga( Empregador empregador, boolean perfilDaVaga, int periodo,
			BigDecimal remuneracao, StatusVagaEnum status, Date data) {

		this.data = data;
		this.empregador = empregador;
		this.perfilDaVaga = perfilDaVaga;
		this.periodo= periodo;
		this.remuneracao = remuneracao;
		this.status = status;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Candidato candidato;
	@ManyToOne
	private Empregador empregador;
	private boolean perfilDaVaga;
	private int periodo;
	private BigDecimal remuneracao;
	@Enumerated(EnumType.STRING)
	private StatusVagaEnum status;
	private Date data;

  public long getId() {
    return this.id;
  }

  public int getPeriodo() {
    return this.periodo;
  }

  public BigDecimal getRemuneracao() {
    return this.remuneracao;
  }

  public StatusVagaEnum getStatus() {
    return this.status;
  }
}
