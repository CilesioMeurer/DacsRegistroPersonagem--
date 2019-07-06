package br.univille.springdacs2019.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.springdacs2019.model.Usuario;
import br.univille.springdacs2019.repository.UsuarioRepository;
import br.univille.springdacs2019.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> getall() {
		return usuarioRepository.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}
	
	@Override
	public void remove(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	@Override
	public Usuario findById(long id) {
		Optional<Usuario> retorno = usuarioRepository.findById(id);
		if(retorno.isPresent())
			return retorno.get();
		return null;
	}

}
