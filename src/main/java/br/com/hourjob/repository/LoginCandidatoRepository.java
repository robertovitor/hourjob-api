package br.com.hourjob.repository;

import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.LoginCandidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface LoginCandidatoRepository  extends JpaRepository<LoginCandidato, Long> {

	Optional<LoginCandidato> findByCandidato(Candidato candidato);
	
}
