package ar.edu.unlam.pb2.segundoModeloDeSegundoParcial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Biblioteca {

	private Set<Libro> coleccionDeLibros = new TreeSet<Libro>();
	private List<Prestamo> prestamos = new ArrayList <Prestamo>();
	private List<Usuario> usuarios = new ArrayList <Usuario>();

	public void agregarLibro(Libro libro) throws LibroDuplicadoException {

		Iterator<Libro> iterador = this.coleccionDeLibros.iterator();
		while (iterador.hasNext()) {
			if (iterador.next().getIsbn().compareTo(libro.getIsbn()) == 0) {
				throw new LibroDuplicadoException("No se pueden agregar libros con mismo ISBN");
			}
		}
		this.coleccionDeLibros.add(libro);

	}

	public Boolean prestarLibro(Libro libro, Usuario usuario) throws LibroNoDisponibleException, PrestamoExcedidoException {
		Iterator<Libro> iterador = this.coleccionDeLibros.iterator();
		while (iterador.hasNext()) {
			Libro libroActual = iterador.next();
			if (libroActual.getIsbn().equals(libro.getIsbn())) {
				
				libroActual.setDisponible(false);
				usuario.obtenerLibro(libro);
				Prestamo prestamoRealizado = new Prestamo(usuario,libro,"una fecha","otra fecha");
				this.prestamos.add(prestamoRealizado);
				return true;
			}
		}
		throw new LibroNoDisponibleException("No contamos con el libro solicitado");

	}
	
	public void recibirLibroPrestado (Libro libro) {
		libro.setDisponible(true);
	}

	public List<Prestamo> verPrestamosRealizados() {
		return this.prestamos;
	}

	
	
	

}
