package com.igmingo.tienda.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igmingo.tienda.modelo.TiendaCategoria;

public class RepositorioCategorias extends Repositorio<TiendaCategoria> {

	//Creamos en el repositorio, un mapa con el idCategoria y el Nombre, para poder desplegar una lista de opciones.
	public Map<Integer, String> getMapaOptions(){
		//recupero la lista de categorias
		List<TiendaCategoria> l=get(TiendaCategoria.class);
		//creo un mapa
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		//rellenamos el mapa con un pares de valores
		for (TiendaCategoria cat : l) {
			mapa.put(cat.getIdCategoria(), cat.getNombre());
		}
		return mapa;	
	}
}