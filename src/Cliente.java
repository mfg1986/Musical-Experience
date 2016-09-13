

public class Cliente extends Persona{
	private int codigocliente;
	private int numerocliente=0;
	
	public void setNumeroCliente(int elnumerocliente){//Método para establecer el número de clientes
		this.numerocliente=elnumerocliente;
	}
	public int getNumeroCliente(){//Método para obtener el número de clientes
		return this.numerocliente;
	}
    public void setCodigoCliente(int elcodigocliente){//Método para establecer el código del cliente
		this.codigocliente=elcodigocliente;
		
	}
	public int getCodigoCliente(){//Método para obtener el código del cliente
		return this.codigocliente;
	}
	
	
}
