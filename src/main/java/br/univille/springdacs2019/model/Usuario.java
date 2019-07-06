package br.univille.springdacs2019.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=1000)
	private String nomepersonagem;
	@Column(length=1000)
	private String nomeobra;
	@Column(length=1000)
	private String estilo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomepersonagem() {
		return nomepersonagem;
	}
	public void setNomepersonagem(String nomepersonagem) {
		this.nomepersonagem = nomepersonagem;
	}
	public String getNomeobra() {
		return nomeobra;
	}
	public void setNomeobra(String nomeobra) {
		this.nomeobra = nomeobra;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	
}
