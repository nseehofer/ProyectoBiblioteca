package ar.edu.unlam.pb2.segundoModeloDeSegundoParcial;

import java.util.Map;
import java.util.TreeMap;

public class Profesor extends Usuario {

	private Map<String,Libro> librosProfesor = new TreeMap <String,Libro>();;

	@Override
	public Boolean devolverLibro() throws DevolucionDeLibroNoprestadoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void obtenerLibro(Libro libro) {
		this.librosProfesor.put(libro.getIsbn(),libro); 

	}

}
