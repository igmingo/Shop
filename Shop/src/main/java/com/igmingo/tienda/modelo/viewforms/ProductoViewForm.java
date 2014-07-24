package com.igmingo.tienda.modelo.viewforms;

import com.igmingo.tienda.modelo.TiendaCategoria;
import com.igmingo.tienda.modelo.TiendaProducto;

public class ProductoViewForm {

	private Integer idProducto;
	private String nombre; 
    private String descripcion;
	private Double precio;
	private String foto; 
    private int existencias;
    private int idCategoria;
//    private Set<Etiqueta> etiquetas = new HashSet<Etiqueta>(0);
//    private Set<EnvioProducto> envioProductos = new HashSet<EnvioProducto>(0);

	public ProductoViewForm() {
	super();
}
	
	public ProductoViewForm(Integer idProducto, String nombre, String descripcion,
		Double precio, String foto, int existencias, int idCategoria) {
	super();
	this.idProducto = idProducto;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.precio = precio;
	this.foto = foto;
	this.existencias = existencias;
	this.idCategoria = idCategoria;
}

	public TiendaProducto getProducto() {
		TiendaProducto prod=new TiendaProducto();
		prod.setIdProducto(idProducto);
		prod.setNombre(nombre);
		prod.setDescripcion(descripcion);
		prod.setPrecio(precio);
		prod.setExistencias(existencias);
		TiendaCategoria cat=new TiendaCategoria();		
		cat.setIdCategoria(idCategoria);
		prod.setTiendaCategoria(cat);
		return prod;
	}

	//Le paso un TiendaProducto y lo coloca en un ProductoViewForm
	public void fromProducto(TiendaProducto prod) {
		//		idProducto=prod.getIdProducto(); es lo mismo
		setIdProducto(prod.getIdProducto());
		setNombre(prod.getNombre());
		setDescripcion(prod.getDescripcion());
		setPrecio(prod.getPrecio());
		setFoto(prod.getFoto());
		setExistencias(prod.getExistencias());
		setIdCategoria(prod.getTiendaCategoria().getIdCategoria());
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
