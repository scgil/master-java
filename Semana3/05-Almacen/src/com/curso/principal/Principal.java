package com.curso.principal;

import com.curso.dao.ProductoDAO;
import com.curso.modelo.Producto;
import com.curso.modelo.Producto.Categoria;

public class Principal {

	public static void main(String[] args) {
		
		ProductoDAO productoDAO = new ProductoDAO();
		
		//Recuperar un producto por ID
		Producto productoRecuperado = productoDAO.findBy(1);
		
		//Insertar un producto
		Producto productoCreado = new Producto("Chaqueta",Categoria.TEXTIL,41.60, 20);
		productoDAO.save(productoCreado);
		
		//Modificar un producto
		Producto productoModificado = productoDAO.findBy(5);
		productoModificado.setNombre("Chaqueta fea");
		productoModificado.setCategoria(Categoria.TEXTIL);
		productoModificado.setPrecio(31.60);
		productoModificado.setStock(10);
		productoDAO.update(productoModificado);
		
		//Eliminar producto
		Producto productoEliminado1 = productoDAO.findBy(5);
		Producto productoEliminado2 = productoDAO.findBy(6);
		Producto productoEliminado3 = productoDAO.findBy(7);
		
		productoDAO.remove(productoEliminado1);
		productoDAO.remove(productoEliminado2);
		productoDAO.remove(productoEliminado3);
		

	}

}
