public class Musica {
	
	private String titulo;
	private String autor;
	private int año;
	private float precio;
	private int duracion;
	private String codigomusica;
	private String formato;
	private int num_copias;
	
	
	public void setTitulo(String eltitulo){//Método para establecer el título del producto
		this.titulo=eltitulo;
	}
	public String getTitulo(){//Método para obtener el título del producto
		return this.titulo;
	}
	public void setAutor(String elautor){//Método para establecer el autor del producto
		this.autor=elautor;
	}
	public String getAutor(){//Método para obtener el autor del producto
		return this.autor;
	}
	public void setAño(int elaño){//Método para establecer el año de publicación del producto
		this.año=elaño;
	}
	public int getAño(){//Método para obtener el año de publicación del producto
		return this.año;
	}
	public void setPrecio(float elprecio){//Método para establecer el precio del producto
		this.precio=elprecio;
	}
	public float getPrecio(){//Método para obtener el precio del producto
		return this.precio;
	}
	public void setDuracion(int laduracion){//Método para establecer la duración del producto
		this.duracion=laduracion;
	}
	public int getDuracion(){//Método para obtener la duración del producto
		return this.duracion;
	}
	public void setCodigoMusica(String elcodigomusica){//Método para establecer el código del producto
		this.codigomusica=elcodigomusica;
		
	}
	public String getCodigoMusica(){//Método para obtener el código del producto
		return this.codigomusica;
	}
	public void setFormato(String elformato){//Método para establecer el formato del producto:vinilo, casette o cd
		this.formato=elformato;
		
	}
	public String getFormato(){//Método para obtener el formato del producto
		return this.formato;
	}
	public void setNumeroCopias(int elnumerodecopias){//Método para establecer el número de copias del producto
		this.num_copias=elnumerodecopias;
	}
	public int getNumeroCopias(){//Método para obtener el número de copias del producto
		return this.num_copias;
	}

}
