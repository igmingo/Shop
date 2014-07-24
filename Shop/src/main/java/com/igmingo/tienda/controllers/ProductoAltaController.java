package com.igmingo.tienda.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igmingo.tienda.modelo.TiendaProducto;
import com.igmingo.tienda.modelo.viewforms.ProductoViewForm;
import com.igmingo.tienda.repositorios.RepositorioCategorias;
import com.igmingo.tienda.repositorios.RepositorioProductos;

@Controller
@RequestMapping(value = "/altaProducto.html")
public class ProductoAltaController {

	@Autowired
	RepositorioProductos daoProductos;
	@Autowired
	RepositorioCategorias daoCategorias;

	@RequestMapping(method = RequestMethod.GET)
	public String alta(ModelMap modelo) {
		ProductoViewForm vistaproducto = new ProductoViewForm();
		modelo.addAttribute("producto", vistaproducto);
		Map<Integer, String> lcat = daoCategorias.getMapaOptions();

		modelo.addAttribute("opciones_categorias", lcat);
		return "altaproducto";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doAlta(
			@ModelAttribute("producto") ProductoViewForm producto,
			BindingResult resultado, HttpServletRequest request) {
		if (resultado.hasErrors()) {
			Map<Integer, String> lc = daoCategorias.getMapaOptions();
			request.setAttribute("opciones_categorias", lc);
			return "alta";
		}
		TiendaProducto prod = producto.getProducto();
		daoProductos.add(prod);
		return "redirect:/lista.html";
	}

}