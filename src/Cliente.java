

public class Cliente extends Persona{
	private int codigocliente;
	private int numerocliente=0;
	
	public void setNumeroCliente(int elnumerocliente){//M�todo para establecer el n�mero de clientes
		this.numerocliente=elnumerocliente;
	}
	public int getNumeroCliente(){//M�todo para obtener el n�mero de clientes
		return this.numerocliente;
	}
    public void setCodigoCliente(int elcodigocliente){//M�todo para establecer el c�digo del cliente
		this.codigocliente=elcodigocliente;
		
	}
	public int getCodigoCliente(){//M�todo para obtener el c�digo del cliente
		return this.codigocliente;
	}
	
	
}
