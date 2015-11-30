package com.kleber.webapp.generic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kleber.webapp.generic.service.basicService;

public abstract class basicController<E> {
	
	@Autowired
	protected basicService<E> serv;

	protected Class<E> clazz;
	
	public basicController(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	@RequestMapping("cadastra")
	public ModelAndView insert() {
		return new ModelAndView("form_cadastra", "command", null);
	}
	
	@RequestMapping("atualiza/{id}")
	public ModelAndView update(@PathVariable("id") String id) {
		return new ModelAndView("form_atualiza", "command", serv.select(id));
	}
	
	@RequestMapping("remove/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		return new ModelAndView("form_remove", "command", serv.select(id));
	}
	
	@RequestMapping("listagem")
	public ModelAndView select() {
		return new ModelAndView("listagem");
	}
	
	@RequestMapping(value="cadastra", method=RequestMethod.POST)
	@ResponseBody
	public void insert(@ModelAttribute("object") E object, BindingResult result) {
		serv.insert(object);
	}
	
	@RequestMapping(value="atualiza", method=RequestMethod.POST)
	@ResponseBody
	public void update(@ModelAttribute("object") E object, BindingResult result) {
		serv.update(object);
	}
	
	@RequestMapping(value="remove", method=RequestMethod.POST)
	@ResponseBody
	public void delete(@ModelAttribute("object") E object, BindingResult result) {
		serv.delete(object);
	}
	
	@RequestMapping("listagem.json")
	@ResponseBody
	public String select2() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(serv.select());
	}
	
	  @InitBinder
	  public void initBinder(WebDataBinder binder) {
	    //binder.registerCustomEditor(Pagina.class, new PaginaEditor());
	  }
	
}
