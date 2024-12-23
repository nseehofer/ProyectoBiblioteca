package ar.edu.unlam.pb2.segundoModeloDeSegundoParcial;

import static org.junit.Assert.*;


import org.junit.Test;

public class GestionDeBibliotecaTest {
	
	/*
	 * o Agregar un libro a la biblioteca: Verificar que un libro se 
		agrega correctamente a la biblioteca y no permite duplicados. 
	 * */
	
	@Test(expected = LibroDuplicadoException.class)
	public void agregarUnLibroALaBiblioteca() throws LibroDuplicadoException {
		Biblioteca biblioteca = new Biblioteca();
		Libro libro = new Libro();
		libro.setIsbn("ISBNDEPRUEBA");
		Libro libro2 = new Libro();
		libro2.setIsbn("ISBNDEPRUEBA");
		biblioteca.agregarLibro(libro);
		biblioteca.agregarLibro(libro2);
	}
	
	/*o Prestar un libro a un estudiante: Verificar que un libro se puede prestar a
	 * un estudiante y que el libro no está disponible después del préstamo.*/
	
	@Test
	public void prestarUnLibroAUnEstudiante() throws LibroNoDisponibleException, LibroDuplicadoException, PrestamoExcedidoException {
		Biblioteca biblioteca = new Biblioteca();
		Libro libro = new Libro();
		libro.setIsbn("ISBNDEPRUEBA");
		biblioteca.agregarLibro(libro);
		Usuario estudiante = new Estudiante();

		assertTrue(biblioteca.prestarLibro(libro, estudiante));
		
		assertFalse(libro.getDisponible());

	}
	
	/*o Devolver un libro prestado: Verificar que un libro prestado se puede
	 * devolver y que el libro está disponible nuevamente.*/
	
	@Test 
	public void devolverUnLibroPrestado () throws LibroDuplicadoException, LibroNoDisponibleException, DevolucionDeLibroNoprestadoException, PrestamoExcedidoException {
		Biblioteca biblioteca = new Biblioteca();
		Libro libro = new Libro();
		libro.setIsbn("ISBNDEPRUEBA");
		biblioteca.agregarLibro(libro);
		Usuario estudiante = new Estudiante();
		assertTrue(biblioteca.prestarLibro(libro, estudiante));
		assertFalse(libro.getDisponible());
		assertTrue(estudiante.devolverLibro());
		biblioteca.recibirLibroPrestado(libro);
		assertTrue(libro.getDisponible());
		
	}
	
	/*
	 * o Consultar historial de préstamos: Verificar que el historial de préstamos
	 * incluye la información correcta de los préstamos realizados.
	 * 
	 * */
	
	@Test 
	public void consultarHistorialDePrestamos () throws LibroDuplicadoException, LibroNoDisponibleException, PrestamoExcedidoException {
		Biblioteca biblioteca = new Biblioteca();
		Libro libro = new Libro();
		Libro libro2 = new Libro();
		Libro libro3 = new Libro();
		Libro libro4 = new Libro();
		
		libro.setIsbn("ISBNDEPRUEBA");
		libro2.setIsbn("ISBNDEPRUEBA2");
		libro3.setIsbn("ISBNDEPRUEBA3");
		libro4.setIsbn("ISBNDEPRUEBA4");
		
		biblioteca.agregarLibro(libro);
		biblioteca.agregarLibro(libro2);
		biblioteca.agregarLibro(libro3);
		biblioteca.agregarLibro(libro4);
		
		Usuario profesor = new Profesor();
		Usuario estudiante = new Estudiante();
		
		
		
		assertTrue(biblioteca.prestarLibro(libro, profesor));
		assertTrue(biblioteca.prestarLibro(libro2, profesor));
		assertTrue(biblioteca.prestarLibro(libro3, profesor));
		assertTrue(biblioteca.prestarLibro(libro4, estudiante));
		
		
		biblioteca.verPrestamosRealizados();
		
		
		}
		/*o Lanzar excepción por préstamo excedido: Verificar que se lanza una
		 * excepción cuando un estudiante o profesor intenta prestar más libros de los
		 * permitidos.
		 * */
		
	@Test (expected = PrestamoExcedidoException.class)
	public void lanzarExcepcionPorPrestamosExcedidos () throws LibroDuplicadoException, LibroNoDisponibleException, PrestamoExcedidoException {
		Biblioteca biblioteca = new Biblioteca();
		Libro libro = new Libro();
		Libro libro2 = new Libro();
		Libro libro3 = new Libro();
		Libro libro4 = new Libro();
		
		libro.setIsbn("ISBNDEPRUEBA");
		libro2.setIsbn("ISBNDEPRUEBA2");
		
		biblioteca.agregarLibro(libro);
		biblioteca.agregarLibro(libro2);
		
		
		Usuario estudiante = new Estudiante();
		
		
		assertTrue(biblioteca.prestarLibro(libro, estudiante));
		assertTrue(biblioteca.prestarLibro(libro2, estudiante));
		
		}
		
	

	/*
	 * o Préstamo de un libro no disponible: Verificar que se lanza una excepción
	 * cuando se intenta prestar un libro que ya ha sido prestado.
	 * 
	 * o Devolver un libro no prestado: Verificar que se lanza una excepción cuando
	 * se intenta devolver un libro que no ha sido prestado.
	 * 
	 */

}
