public class Musica {
	
	private String titulo;
	private String autor;
	private int a�o;
	private float precio;
	private int duracion;
	private String codigomusica;
	private String formato;
	private int num_copias;
	
	
	public void setTitulo(String eltitulo){//M�todo para establecer el t�tulo del producto
		this.titulo=eltitulo;
	}
	public String getTitulo(){//M�todo para obtener el t�tulo del producto
		return this.titulo;
	}
	public void setAutor(String elautor){//M�todo para establecer el autor del producto
		this.autor=elautor;
	}
	public String getAutor(){//M�todo para obtener el autor del producto
		return this.autor;
	}
	public void setA�o(int ela�o){//M�todo para establecer el a�o de publicaci�n del producto
		this.a�o=ela�o;
	}
	public int getA�o(){//M�todo para obtener el a�o de publicaci�n del producto
		return this.a�o;
	}
	public void setPrecio(float elprecio){//M�todo para establecer el precio del producto
		this.precio=elprecio;
	}
	public float getPrecio(){//M�todo para obtener el precio del producto
		return this.precio;
	}
	public void setDuracion(int laduracion){//M�todo para establecer la duraci�n del producto
		this.duracion=laduracion;
	}
	public int getDuracion(){//M�todo para obtener la duraci�n del producto
		return this.duracion;
	}
	public void setCodigoMusica(String elcodigomusica){//M�todo para establecer el c�digo del producto
		this.codigomusica=elcodigomusica;
		
	}
	public String getCodigoMusica(){//M�todo para obtener el c�digo del producto
		return this.codigomusica;
	}
	public void setFormato(String elformato){//M�todo para establecer el formato del producto:vinilo, casette o cd
		this.formato=elformato;
		
	}
	public String getFormato(){//M�todo para obtener el formato del producto
		return this.formato;
	}
	public void setNumeroCopias(int elnumerodecopias){//M�todo para establecer el n�mero de copias del producto
		this.num_copias=elnumerodecopias;
	}
	public int getNumeroCopias(){//M�todo para obtener el n�mero de copias del producto
		return this.num_copias;
	}

}
