package br.com.forum.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.Assert;

import br.com.forum.modelo.Curso;

@DataJpaTest
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Test
	public void deveriaCarregarCursoPeloNome() {
		String nomeCurso = "HTML 5";	
		Curso curso = repository.findByNome(nomeCurso);
		
		Assert.assertNotNull(curso);
		Assert.assertEquals(curso.getNome(), nomeCurso);
	}
	
	@Test
	public void naoDeveriaEncontrarCursoPeloNome() {
		String nomeCurso = "JPA";	
		Curso curso = repository.findByNome(nomeCurso);
		
		Assert.assertNull(curso);
	}

}
