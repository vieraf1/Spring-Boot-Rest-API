package br.com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.forum.dto.TopicoDto;
import br.com.forum.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> listar(String nomeCurso) {
		if(nomeCurso != null) {
			return TopicoDto.convertFromTopico(
					topicoRepository.findByCursoNome(nomeCurso));
		}
		
		return TopicoDto.convertFromTopico(topicoRepository.findAll());
	}

}
