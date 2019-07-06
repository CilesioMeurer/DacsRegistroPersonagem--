package br.univille.springdacs2019.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.springdacs2019.model.Usuario;
import br.univille.springdacs2019.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControllerAPI {
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuario(){
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			lista = service.getall();
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return new ResponseEntity<List<Usuario>>(lista,HttpStatus.OK);
		
	}
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Usuario usuario){
		service.save(usuario);
		return ResponseEntity.ok().build();
	}
	@PutMapping(path="/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Usuario usuario){
		Usuario usuarioAtual = service.findById(id);
		if(usuarioAtual != null) {
			usuarioAtual.setNomepersonagem(usuario.getNomepersonagem());
			usuarioAtual.setNomeobra(usuario.getNomeobra());
			usuarioAtual.setEstilo(usuario.getEstilo());
			service.save(usuarioAtual);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		Usuario usuarioAtual = service.findById(id);
		if(usuarioAtual != null) {
			service.remove(usuarioAtual);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	

}