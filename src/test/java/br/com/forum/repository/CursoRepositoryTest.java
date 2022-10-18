package br.com.forum.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.forum.modelo.Curso;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaCarregarCursoPeloNome() {
		String nomeCurso = "HTML 5";	
		
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		
		em.persist(html5);
		
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
