<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de Producto</title>
</head>
<body>

Datos del Producto<br/>
<!-- es una etiqueta de Spring, en vez de un action es un commandName (un objeto que enviamos de vuelta) -->
	<form:form method="post" commandName="producto">
<!-- 	En vez de un name, se usa el path (la ruta de la propiedad de la Clase) (igual que en la clase) -->
	Nombre: <form:input path="nombre" /><br />
	Precio: <form:input path="precio" /><br />
	<form:errors path="precio"/>
	Existencia: <form:input path="existencias" /><br />
	<form:errors path="existencias"/>
	Categoría: <form:select path="idCategoria">
					<form:options items="${opciones_categorias}" />
			   </form:select><br />
	Descripción: <form:textarea path="descripcion" /><br />
	Foto: <form:input path="foto" /><br />
			<input type="submit" value="Guardar"/>		
	</form:form>
</body>
</html>