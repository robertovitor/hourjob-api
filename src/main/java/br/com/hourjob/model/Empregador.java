package br.com.hourjob.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Empregador {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String cpfResponsavel;
	private String cep;
	private String funcResponsavel;
	private String porteEmpresa;
	private String atividade;
	private double pontuacao;


  public long getId() {
    return this.id;
  }

  public String getCep() {
    return this.cep;
  }

  public String getNome() {
    return this.nome;
  }

  public String getEmail() {
    return this.email;
  }

  public void setPontuacao(int nota) {
  }

  public void setAtividade(String atividade) {
  }

  public void setCep(String cep) {
  }

  public void setCnpj(String cnpj) {
  }

  public void setCpfResponsavel(String cpfResponsavel) {
  }

  public void setEmail(String email) {
  }

  public void setFuncResponsavel(String funcResponsavel) {
  }

  public void setPorteEmpresa(String porteEmpresa) {
  }

  public void setNome(String nome) {
  }

  public void setTelefone(String telefone) {
  }
}
