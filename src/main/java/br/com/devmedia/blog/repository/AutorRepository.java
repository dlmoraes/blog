package br.com.devmedia.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.devmedia.blog.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Autor findByNome(String nome);

	@Modifying
	@Query("update Autor a set a.nome = ?1, a.biografia = ?2 where a.id = ?3")
	void updateNomeAndBiografia(String nome, String biografia, Long id);
	
}
