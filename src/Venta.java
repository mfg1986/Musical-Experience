
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
	public void setNombreEmpleadoVenta(String elnombreempleadoventa){//Método para establecer el nombre del empleado que atendió la venta
		this.nombre_empleado_venta=elnombreempleadoventa;
	}
	public String getNombreEmpleadoVenta(){//Método para obtener el nombre del empleado que atendió la venta
		return this.nombre_empleado_venta;
	}
	public void setApellidosEmpleadoVenta(String elapellidoempleadoventa){//Método para establecer los apellidos del empleado que atendió la venta
		this.apellidos_empleado_venta=elapellidoempleadoventa;
	}
	public String getApellidosEmpleadoVenta(){//Método para obtener los apellidos del empleado que atendió la venta
		return this.apellidos_empleado_venta;
	}
	public void setCodigoEmpleadoVenta(int elcodigoempleado){//Método para establecer el código del empleado que atendió la venta
		this.codigo_empleado_venta=elcodigoempleado;
	}
	public int getCodigoEmpleadoVenta(){//Método para obtener el código del empleado que atendió la venta
		return this.codigo_empleado_venta;
	}
	
	/***************METODOS RELACIONADOS CON EL CLIENTE*******************/
	/**********************************************************************/
	public void setNombreClienteVenta(String elnombreclienteventa){//Metodo para establecer el nombre del cliente que realizó la compra
		this.nombre_cliente_venta=elnombreclienteventa;
	}
	public String getNombreClienteVenta(){//Método para obtener el nombre del cliente que relizó la compra
		return this.nombre_cliente_venta;
	}
	public void setApellidosClienteVenta(String losapellidosclienteventa){//Método para establecer los apellidos del cliente que relizó la compra
		this.apellidos_cliente_venta=losapellidosclienteventa;
	}
	public String getApellidosClienteVenta(){//Método para obtener los apellidos del cliente que relizó la compra
		return this.apellidos_cliente_venta;
	}
	public void setCodigoClienteVenta(int elcodigocliente){//Método para establecer el código del cliente que realizó la compra
		this.codigo_cliente_venta=elcodigocliente;
	}
	public int getCodigoClienteVenta(){//Método para obtener el código del cliente que realizó la compra
		return this.codigo_cliente_venta;
	}

	/***************METODOS RELACIONADOS LA FECHA Y HORA*******************/
	/**********************************************************************/
	public void setFechayHora(){//Método para establecer la fecha y la hora en la que se realizó la venta
		
		Calendar calendario= GregorianCalendar.getInstance();
		int mes=calendario.get(Calendar.MONTH);
		this.fecha_venta=calendario.get(Calendar.DATE)+"/"+(mes+1)+"/"+calendario.get(Calendar.YEAR);
		this.hora_venta=calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+calendario.get(Calendar.SECOND); 
	}
	public String getFechaVenta(){//Método para obtener la fecha  en la que se realizó la venta
		return this.fecha_venta;
	}
	public String getHoraVenta(){//Método para obtener la hora en la que se realizó la venta
		return this.hora_venta;
	}
	public void setNumVenta(int elnumventa){
		this.num_venta=elnumventa;
	}
	public int getNumVenta(){
		return this.num_venta;
	}



}

