package br.com.devmedia.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devmedia.blog.entity.Postagem;
import br.com.devmedia.blog.service.PostagemService;

@Controller
@RequestMapping("postagem")
public class PostagemController {

	@Autowired
	private PostagemService postagemService;
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		
		Postagem postagem = postagemService.findById(id);
		
		model.addAttribute("postagem", postagem);
		
		return new ModelAndView("postagem/cadastro", model);
		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		postagemService.delete(id);
		
		return "redirect:/postagem/list";
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listPostagem(ModelMap model) {
		
		model.addAttribute("postagens", postagemService.findAll());
		
		return new ModelAndView("postagem/list", model);
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("postagem") Postagem postagem) {
		postagemService.saveOrUpdate(postagem);
		
		return "redirect:/postagem/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView cadastro(@ModelAttribute("postagem") Postagem postagem) {
		
		return new ModelAndView("postagem/cadastro");
		
	}
	
}
