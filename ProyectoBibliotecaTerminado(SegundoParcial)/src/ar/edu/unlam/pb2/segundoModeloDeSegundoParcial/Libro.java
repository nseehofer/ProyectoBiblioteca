package ar.edu.unlam.pb2.segundoModeloDeSegundoParcial;

public class Libro implements Comparable<Libro> {
	/* LIBRO: TITULO, AUTOR, ISBN, ESTADO */

	private String titulo;
	private String autor;
	private String isbn;
	private Boolean disponible = true;
	
	
	
	//POJO

	
	public String getIsbn() {
		return isbn;
	}


	public Boolean getDisponible() {
		return disponible;
	}


	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
	//SON IGUALES SI COMPARTEN ISBN
		@Override
		public int compareTo(Libro libro) {
			// TODO Auto-generated method stub
			return this.isbn.compareTo(libro.isbn);
		}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", disponible=" + disponible + "]";
	}
	
	

}
