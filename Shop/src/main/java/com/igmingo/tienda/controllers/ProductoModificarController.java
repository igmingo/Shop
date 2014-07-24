package com.igmingo.tienda.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igmingo.tienda.modelo.TiendaProducto;
import com.igmingo.tienda.modelo.viewforms.ProductoViewForm;
import com.igmingo.tienda.repositorios.RepositorioCategorias;
import com.igmingo.tienda.repositorios.RepositorioProductos;

@Controller
// @RequestMapping(value = "modificarProducto.html")
public class ProductoModificarController {

	@Autowired
	RepositorioProductos daoProductos;
	@Autowired
	RepositorioCategorias daoCategorias;

	@RequestMapping(value = "/modificarProducto_{id}.html",
			method = RequestMethod.GET)
	public String modificar(ModelMap modelo, @PathVariable int id) {

		TiendaProducto prod = daoProductos.get(TiendaProducto.class, id);
		ProductoViewForm vp = new ProductoViewForm();
		vp.fromProducto(prod);

		modelo.addAttribute("producto", vp);
		Map<Integer, String> lcat = daoCategorias.getMapaOptions();
		modelo.addAttribute("opciones_categorias", lcat);

		return "modificarproducto";
	}

	@RequestMapping(value = "/modificarProducto_{id}.html",
			method = RequestMethod.POST)
	public String doModificar(
			@ModelAttribute("producto") ProductoViewForm producto,
			BindingResult resultado, HttpServletRequest request) {
		if (resultado.hasErrors()) {
			Map<Integer, String> lc = daoCategorias.getMapaOptions();
			request.setAttribute("opciones_categorias", lc);
			return "modificarproducto";
		}
		daoProductos.update(producto.getProducto());
		return "redirect:/lista.html";
	}

}
