package br.univille.springdacs2019.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.univille.springdacs2019.model.Usuario;

@Service
public interface UsuarioService {
	
	List<Usuario> getall();

	void save(Usuario usuario);
	
	void remove(Usuario usuario);
	
	Usuario findById(long id);

}

