package br.com.hourjob.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.hourjob.dto.CandidatoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hourjob.controller.form.EmpregadorForm;
import br.com.hourjob.dto.EmpregadorDto;
import br.com.hourjob.model.Empregador;
import br.com.hourjob.service.EmpregadorService;
import lombok.Data;

@RestController
@RequestMapping("/empregador")
@Data
public class EmpregadorController {

	@Autowired
	private EmpregadorService empregadorService;

	@PostMapping
	@Transactional
	public ResponseEntity<EmpregadorDto> cadastrar(@RequestBody @Valid EmpregadorForm form, UriComponentsBuilder uriBuilder) {

		Empregador empregador = empregadorService.salvar(form);

		URI uri = uriBuilder.path("/empregador/{id}").buildAndExpand(empregador.getId()).toUri();
		return ResponseEntity.created(uri).body(new EmpregadorDto(empregador));
	}

	@PutMapping("/avaliacao/{id}/{nota}")
	@Transactional
	public ResponseEntity<EmpregadorDto> atualizar(@PathVariable Long id, int nota) {
		return empregadorService.avaliar(id,nota);
	}

  @GetMapping
  public Page<EmpregadorDto> lista(@RequestParam(required = false) Long idQuali,
                                  @PageableDefault(direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {

    return empregadorService.listar(idQuali,paginacao);
  }

}
