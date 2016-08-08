package br.com.devmedia.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "postagens")
public class Postagem extends AbstractPersistable<Long> {

	@Column(nullable = false, unique = true, length = 60)
	private String titulo;
	@Column(nullable = false, columnDefinition = "text")
	private String texto;
	@Column(nullable = false, unique = true, length = 60)
	private String permalink;
	@Column(name = "data_postagem", nullable = false)
	private LocalDateTime dataPostagem;
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public LocalDateTime getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDateTime dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
