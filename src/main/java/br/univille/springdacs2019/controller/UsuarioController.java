package br.univille.springdacs2019.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.springdacs2019.model.Usuario;
import br.univille.springdacs2019.service.UsuarioService;
	
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping()
	public ModelAndView index() {
		return new ModelAndView("usuario/index","usuarios",service.getall());
		
	}	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Usuario usuario) {
		return new ModelAndView("usuario/form");
	}
	@PostMapping(params="form")
	public ModelAndView save(@Valid Usuario usuario) {
		service.save(usuario);
		return new ModelAndView("redirect:/usuario");
	}
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Usuario usuario) {
		return new ModelAndView("usuario/form","usuario",usuario);
		
	}
	
	@GetMapping(value="/remover/{id}")
	public ModelAndView remove(@PathVariable("id") Usuario usuario) {
		service.remove(usuario);
		return new ModelAndView("redirect:/usuario");
	}
 }
