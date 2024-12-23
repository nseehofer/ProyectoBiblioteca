package ar.edu.unlam.pb2.segundoModeloDeSegundoParcial;

public class Prestamo {
	/* Gestionar historial de préstamos: Mantener un registro histórico 
		centralizado de todos los préstamos realizados en la biblioteca. Este 
		historial debe incluir información detallada como el usuario, el libro 
		prestado y las fechas de préstamo y devolución.  */ 
	
	private Usuario usuario;
	private Libro libro;
	private String fechaPrestamo;
	private String fechaDevolucion;

	public Prestamo (Usuario usuario, Libro libro, String fechaPrestamo, String fechaDevolucion ) {
	this.usuario = usuario;
	this.libro = libro;
	this.fechaPrestamo = fechaPrestamo;
	this.fechaDevolucion = fechaDevolucion;
	}

	@Override
	public String toString() {
		return "Prestamo [usuario=" + usuario + ", libro=" + libro + ", fechaPrestamo=" + fechaPrestamo
				+ ", fechaDevolucion=" + fechaDevolucion + "]";
	}
	
	
	
}
