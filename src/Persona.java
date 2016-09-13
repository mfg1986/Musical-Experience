
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
	
	public void setNombre(String elnombre){//Método para establecer el nombre de la persona
		this.nombre=elnombre;
	}
	public String getNombre(){//Método para obtener el nombre de la persona
		return this.nombre;
	}
	public void setApellidos(String losapellidos){//Método para establecer los apellidos de la persona
		this.apellidos=losapellidos;
	}
	public String getApellidos(){//Método para obtener los apellidos de la persona
		return this.apellidos;
	}
	public void setDomicilio(String eldomicilio){//Método para establecer el domicilio de la persona
		this.domicilio=eldomicilio;
		
	}
	public String getDomicilio(){//Método para obtener el domicilio de la persona
		return this.domicilio;
	}
	public void setCp( int elcp){//Método para establecer el código postal de la persona
		this.cp=elcp;
		
	}
	public int getCp(){//Método para obtener el código postal de la persona
		return this.cp;
	}
	public void setLocalidad(String lalocalidad){//Método para establecer la localidad donde vive la persona
		this.localidad=lalocalidad;
	}
	public String getLocalidad(){//Método para obtener la localidad donde vive la persona
		return this.localidad;
		
	}
	public void setProvincia(String laprovincia){//Método para establecer la provincia donde vive la persona
		this.provincia=laprovincia;
	}
	public String getProvincia(){//Método para obtener la provincia donde vive la persona
		return this.provincia;	
	}
	public void setFechaNacimiento(String lafecha){//Método para establecer la fecha de nacimiento de la persona
		this.fecha_nacimiento=lafecha;
	}
	public String getFechaNacimiento(){//Método para obtener la fecha de nacimiento de la persona
		return this.fecha_nacimiento;
		
	}
	public void setDni(int eldni){//Método para establecer el dni de la persona
		this.dni=eldni;
	}
	public int getDni(){//Método para obtener el dni de la persona
		return this.dni;
	}
	public void setLetraDni(String laletra){//Método para establecer la letra del dni de la persona
		this.letra_dni=laletra;
	}
	public String getLetraDni(){//Método para obtener la letra del dni de la persona
		return this.letra_dni;
	}
	public void setTelefono(int eltelefono){//Método para establecer el teléfono de la persona
		this.telefono=eltelefono;
	}
	public int getTelefono(){//Método para obtener el teléfono de la persona
		return this.telefono;
	}
	public void setCorreo(String elcorreo){//Método para establecer el correo electrónico de la persona
		this.correo=elcorreo;
	}
	public String getCorreo(){//Método para obtener el correo electrónico de la persona
		return this.correo;
	}
	
}
