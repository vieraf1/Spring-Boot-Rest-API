package br.com.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum.controller.form.TopicoForm;
import br.com.forum.dto.TopicoDto;
import br.com.forum.modelo.Topico;
import br.com.forum.repository.CursoRepository;
import br.com.forum.repository.TopicoRepository;

@RestController
@RequestMapping(value="/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> listar(String nomeCurso) {
		if(nomeCurso != null) {
			return TopicoDto.convertFromTopico(
					topicoRepository.findByCursoNome(nomeCurso));
		}
		
		return TopicoDto.convertFromTopico(topicoRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoForm.convertToTopico(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}

}
