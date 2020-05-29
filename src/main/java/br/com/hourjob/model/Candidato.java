package br.com.hourjob.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Candidato {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private String nomeDaMae;
	private Date dataDeNascimento;
	private String cep;
	@Lob
	private String selfie;
	@Lob
	private String fotoDoDocumento;
	private int pontuacao;
	@OneToMany(mappedBy = "candidato")
	private List<Qualificacao> qualificacao;
	@OneToMany
	private List<ServicosPrestados> servicosPrestados;

  public Long getId() {
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

  public void setCpf(String cpf) {
  }

  public void setNome(String nome) {
  }

  public void setCep(String cep) {
  }

  public void setNomeDaMae(String nomeMae) {
  }

  public void setEmail(String email) {
  }

  public void setDataDeNascimento(Date dataNascimento) {
  }

  public void setTelefone(String telefone) {
  }
}
