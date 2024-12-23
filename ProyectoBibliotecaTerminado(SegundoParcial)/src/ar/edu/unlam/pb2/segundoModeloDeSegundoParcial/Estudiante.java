package ar.edu.unlam.pb2.segundoModeloDeSegundoParcial;

public class Estudiante extends Usuario {

	private Libro libro;

	@Override
	public Boolean devolverLibro() throws DevolucionDeLibroNoprestadoException  {

		if (this.libro != null) {
			this.libro = null;
			return true;
		} throw new DevolucionDeLibroNoprestadoException ("El estudiante no pidio este libro prestado");

		
	}

	@Override
	protected void obtenerLibro(Libro libro) throws PrestamoExcedidoException {
		if (this.libro != null) {
			throw new PrestamoExcedidoException("El estudiante ya tiene un libro a prestamo");
		}
		this.libro = libro;
		
	}

}
