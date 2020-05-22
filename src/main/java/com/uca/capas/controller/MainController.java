package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;

import com.uca.capas.domain.Importancia;


@Controller
public class MainController {
	
	
	@Autowired
	private ImportanciaDAO importanciaDAO;
	
	@Autowired
	private ContribuyenteDAO contribuyenteDAO;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain2() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente =new Contribuyente();
		mav.addObject("contribuyente",  contribuyente);
		List<Importancia> importancias = null;
		importancias = importanciaDAO.findAll();
		mav.addObject("importancia", contribuyente.getImportancia());
		mav.addObject("importancias", importancias);
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/exito")
	public ModelAndView exito(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		contribuyenteDAO.insert(contribuyente);
		mav.setViewName("exito");
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = contribuyenteDAO.findAll(); 
		
		try {
			mav.addObject("contribuyentes", contribuyentes);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mav.setViewName("listado");
		return mav;
	}
}
