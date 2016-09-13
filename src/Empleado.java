
public class Empleado extends Persona{
	
	private float sueldo;
	private String numero_seg_social;
	private int codigo_empleado;
	private int numero_ventas;
	private String puesto;
	private float total_ventas;
	
	
	public void setSueldo (float elsueldo){//M�todo para establecer el sueldo del empleado
		this.sueldo=elsueldo;
	}
	public float getSueldo(){//M�todo para obtener el sueldo del empleado
		return this.sueldo;
	}
	public void setNumeroSegSocial(String elnumerosegsocial){//M�todo para establecer el n�mero de la seguridad social del empleado
		this.numero_seg_social=elnumerosegsocial;
		
	}
	public String getNumeroSegSocial(){//M�todo para obtener el n�mero de la seguridad social del empleado
		return this.numero_seg_social;
	}
	public void setCodigoEmpleado(int elcodigoempleado){//M�todo para establecer el c�digo del empleado
		this.codigo_empleado=elcodigoempleado;
	}
	public int getCodigoEmpleado(){//M�todo para obtener el c�digo del empleado
		return this.codigo_empleado;
	}
	public void setNumeroVentasEmpleado(int elnumerodeventas){//M�todo para establecer el n�mero de ventas que lleva realizadas el empleado
		this.numero_ventas=elnumerodeventas;
	}
	public int getNumeroVentasEmpleado(){//M�todo para obtener el n�mero de ventas que ha realizado el empleado
		return this.numero_ventas;
	}
	public void setPuesto(String elpuesto){//M�todo para establecer el puesto que desempe�ar� el empleado
		this.puesto=elpuesto;
	}
	public String getPuesto(){//M�todo para obtener el puesto que desempe�a el empleado
		return this.puesto;
	}
	public void setTotalPrecioVentas(float elpreciototalventas){//M�todo para establecer el precio total en ventas despachado por el empleado
		this.total_ventas+=elpreciototalventas;
	}
	public float getTotalPrecioVentas(){//M�todo para obtener  el precio total en ventas despachado por el empleado
		return this.total_ventas;
	}

}

