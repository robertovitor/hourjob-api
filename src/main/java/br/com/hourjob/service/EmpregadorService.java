package br.com.hourjob.service;

import java.util.Optional;

import javax.validation.Valid;

import br.com.hourjob.dto.CandidatoDto;
import br.com.hourjob.model.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.hourjob.controller.form.EmpregadorForm;
import br.com.hourjob.dto.EmpregadorDto;
import br.com.hourjob.model.Empregador;
import br.com.hourjob.repository.EmpregadorRepository;

@Service
public class EmpregadorService {

	@Autowired
	private EmpregadorRepository empregadorRepository;

	public Empregador salvar(@Valid EmpregadorForm form) {

		return empregadorRepository.save(form.toEmpregador());
	}

	public ResponseEntity<EmpregadorDto> avaliar(Long id, int nota) {
		Optional<Empregador> optional = empregadorRepository.findById(id);
		if (optional.isPresent()) {
			Empregador empregador = empregadorRepository.getOne(id);
			empregador.setPontuacao(nota);
			return ResponseEntity.ok(new EmpregadorDto(empregador));
		}

		return ResponseEntity.notFound().build();
	}

  public Page<EmpregadorDto> listar(Long id, Pageable paginacao) {
    if (id == null) {
      Page<Empregador> empregador = empregadorRepository.findAll(paginacao);
      return EmpregadorDto.converter(empregador);
    }
    else {
      return null;
    }
  }


}
