package ar.edu.unlam.pb2.segundoModeloDeSegundoParcial;

public abstract class Usuario {
	/* USUARIO: NOMBRE, NUMERO DE USUARIO */

	private static int contador = 0;
	private Integer nroUsuario = 0;
	private String nombre;

	public Usuario() {
		this.nroUsuario = ++this.contador;
	}

	public abstract Boolean devolverLibro() throws DevolucionDeLibroNoprestadoException;

	protected abstract void obtenerLibro(Libro libro) throws PrestamoExcedidoException;

	

	

}
