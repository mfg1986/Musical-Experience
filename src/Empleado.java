
public class Empleado extends Persona{
	
	private float sueldo;
	private String numero_seg_social;
	private int codigo_empleado;
	private int numero_ventas;
	private String puesto;
	private float total_ventas;
	
	
	public void setSueldo (float elsueldo){//Método para establecer el sueldo del empleado
		this.sueldo=elsueldo;
	}
	public float getSueldo(){//Método para obtener el sueldo del empleado
		return this.sueldo;
	}
	public void setNumeroSegSocial(String elnumerosegsocial){//Método para establecer el número de la seguridad social del empleado
		this.numero_seg_social=elnumerosegsocial;
		
	}
	public String getNumeroSegSocial(){//Método para obtener el número de la seguridad social del empleado
		return this.numero_seg_social;
	}
	public void setCodigoEmpleado(int elcodigoempleado){//Método para establecer el código del empleado
		this.codigo_empleado=elcodigoempleado;
	}
	public int getCodigoEmpleado(){//Método para obtener el código del empleado
		return this.codigo_empleado;
	}
	public void setNumeroVentasEmpleado(int elnumerodeventas){//Método para establecer el número de ventas que lleva realizadas el empleado
		this.numero_ventas=elnumerodeventas;
	}
	public int getNumeroVentasEmpleado(){//Método para obtener el número de ventas que ha realizado el empleado
		return this.numero_ventas;
	}
	public void setPuesto(String elpuesto){//Método para establecer el puesto que desempeñará el empleado
		this.puesto=elpuesto;
	}
	public String getPuesto(){//Método para obtener el puesto que desempeña el empleado
		return this.puesto;
	}
	public void setTotalPrecioVentas(float elpreciototalventas){//Método para establecer el precio total en ventas despachado por el empleado
		this.total_ventas+=elpreciototalventas;
	}
	public float getTotalPrecioVentas(){//Método para obtener  el precio total en ventas despachado por el empleado
		return this.total_ventas;
	}

}

