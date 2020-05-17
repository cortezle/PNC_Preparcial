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
		mav.addObject("contribuyente", new Contribuyente() );
		List<Importancia> importancias = null;
		importancias = importanciaDAO.findAll();
		mav.addObject("importancia", new Importancia());
		mav.addObject("importancias", importancias);
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/exito")
	public ModelAndView exito(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		System.out.println(contribuyente.getF_fecha_ingreso());
		
		contribuyenteDAO.insert(contribuyente);
		mav.setViewName("exito");
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importanciass =importanciaDAO.findAll(); 
		Importancia importancias = importanciaDAO.findOne(2);
		try {
			mav.addObject("importanciass", importanciass);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mav.setViewName("listado");
		return mav;
	}
}
