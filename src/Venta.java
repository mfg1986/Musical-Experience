
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Venta extends Musica {
	
	
	private String fecha_venta;
	private String hora_venta;
	private String nombre_empleado_venta, apellidos_empleado_venta; 
	private String nombre_cliente_venta, apellidos_cliente_venta;
	private int codigo_cliente_venta, codigo_empleado_venta;
	private int num_venta;
	
	
	/***************METODOS RELACIONADOS CON EL EMPLEADO*******************/
	/**********************************************************************/
	public void setNombreEmpleadoVenta(String elnombreempleadoventa){//M�todo para establecer el nombre del empleado que atendi� la venta
		this.nombre_empleado_venta=elnombreempleadoventa;
	}
	public String getNombreEmpleadoVenta(){//M�todo para obtener el nombre del empleado que atendi� la venta
		return this.nombre_empleado_venta;
	}
	public void setApellidosEmpleadoVenta(String elapellidoempleadoventa){//M�todo para establecer los apellidos del empleado que atendi� la venta
		this.apellidos_empleado_venta=elapellidoempleadoventa;
	}
	public String getApellidosEmpleadoVenta(){//M�todo para obtener los apellidos del empleado que atendi� la venta
		return this.apellidos_empleado_venta;
	}
	public void setCodigoEmpleadoVenta(int elcodigoempleado){//M�todo para establecer el c�digo del empleado que atendi� la venta
		this.codigo_empleado_venta=elcodigoempleado;
	}
	public int getCodigoEmpleadoVenta(){//M�todo para obtener el c�digo del empleado que atendi� la venta
		return this.codigo_empleado_venta;
	}
	
	/***************METODOS RELACIONADOS CON EL CLIENTE*******************/
	/**********************************************************************/
	public void setNombreClienteVenta(String elnombreclienteventa){//Metodo para establecer el nombre del cliente que realiz� la compra
		this.nombre_cliente_venta=elnombreclienteventa;
	}
	public String getNombreClienteVenta(){//M�todo para obtener el nombre del cliente que reliz� la compra
		return this.nombre_cliente_venta;
	}
	public void setApellidosClienteVenta(String losapellidosclienteventa){//M�todo para establecer los apellidos del cliente que reliz� la compra
		this.apellidos_cliente_venta=losapellidosclienteventa;
	}
	public String getApellidosClienteVenta(){//M�todo para obtener los apellidos del cliente que reliz� la compra
		return this.apellidos_cliente_venta;
	}
	public void setCodigoClienteVenta(int elcodigocliente){//M�todo para establecer el c�digo del cliente que realiz� la compra
		this.codigo_cliente_venta=elcodigocliente;
	}
	public int getCodigoClienteVenta(){//M�todo para obtener el c�digo del cliente que realiz� la compra
		return this.codigo_cliente_venta;
	}

	/***************METODOS RELACIONADOS LA FECHA Y HORA*******************/
	/**********************************************************************/
	public void setFechayHora(){//M�todo para establecer la fecha y la hora en la que se realiz� la venta
		
		Calendar calendario= GregorianCalendar.getInstance();
		int mes=calendario.get(Calendar.MONTH);
		this.fecha_venta=calendario.get(Calendar.DATE)+"/"+(mes+1)+"/"+calendario.get(Calendar.YEAR);
		this.hora_venta=calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+calendario.get(Calendar.SECOND); 
	}
	public String getFechaVenta(){//M�todo para obtener la fecha  en la que se realiz� la venta
		return this.fecha_venta;
	}
	public String getHoraVenta(){//M�todo para obtener la hora en la que se realiz� la venta
		return this.hora_venta;
	}
	public void setNumVenta(int elnumventa){
		this.num_venta=elnumventa;
	}
	public int getNumVenta(){
		return this.num_venta;
	}



}

