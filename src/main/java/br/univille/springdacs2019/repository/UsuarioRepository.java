package br.univille.springdacs2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.springdacs2019.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	Usuario findByNomepersonagem(String nomepersonagem);
}
