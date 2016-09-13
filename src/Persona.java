
public class Persona {
	private String nombre;
	private String apellidos;
	private String domicilio;
	private int cp;
	private String localidad;
	private String provincia;
	private String fecha_nacimiento;
	private int dni;
    private String letra_dni;
	private int telefono;
	private String correo;
	
	public void setNombre(String elnombre){//M�todo para establecer el nombre de la persona
		this.nombre=elnombre;
	}
	public String getNombre(){//M�todo para obtener el nombre de la persona
		return this.nombre;
	}
	public void setApellidos(String losapellidos){//M�todo para establecer los apellidos de la persona
		this.apellidos=losapellidos;
	}
	public String getApellidos(){//M�todo para obtener los apellidos de la persona
		return this.apellidos;
	}
	public void setDomicilio(String eldomicilio){//M�todo para establecer el domicilio de la persona
		this.domicilio=eldomicilio;
		
	}
	public String getDomicilio(){//M�todo para obtener el domicilio de la persona
		return this.domicilio;
	}
	public void setCp( int elcp){//M�todo para establecer el c�digo postal de la persona
		this.cp=elcp;
		
	}
	public int getCp(){//M�todo para obtener el c�digo postal de la persona
		return this.cp;
	}
	public void setLocalidad(String lalocalidad){//M�todo para establecer la localidad donde vive la persona
		this.localidad=lalocalidad;
	}
	public String getLocalidad(){//M�todo para obtener la localidad donde vive la persona
		return this.localidad;
		
	}
	public void setProvincia(String laprovincia){//M�todo para establecer la provincia donde vive la persona
		this.provincia=laprovincia;
	}
	public String getProvincia(){//M�todo para obtener la provincia donde vive la persona
		return this.provincia;	
	}
	public void setFechaNacimiento(String lafecha){//M�todo para establecer la fecha de nacimiento de la persona
		this.fecha_nacimiento=lafecha;
	}
	public String getFechaNacimiento(){//M�todo para obtener la fecha de nacimiento de la persona
		return this.fecha_nacimiento;
		
	}
	public void setDni(int eldni){//M�todo para establecer el dni de la persona
		this.dni=eldni;
	}
	public int getDni(){//M�todo para obtener el dni de la persona
		return this.dni;
	}
	public void setLetraDni(String laletra){//M�todo para establecer la letra del dni de la persona
		this.letra_dni=laletra;
	}
	public String getLetraDni(){//M�todo para obtener la letra del dni de la persona
		return this.letra_dni;
	}
	public void setTelefono(int eltelefono){//M�todo para establecer el tel�fono de la persona
		this.telefono=eltelefono;
	}
	public int getTelefono(){//M�todo para obtener el tel�fono de la persona
		return this.telefono;
	}
	public void setCorreo(String elcorreo){//M�todo para establecer el correo electr�nico de la persona
		this.correo=elcorreo;
	}
	public String getCorreo(){//M�todo para obtener el correo electr�nico de la persona
		return this.correo;
	}
	
}
