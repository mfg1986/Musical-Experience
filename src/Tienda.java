import java.util.ArrayList;


public class Tienda {
	private ArrayList<Musica> catalogo=new ArrayList<Musica>();
	private ArrayList<Cliente> listaclientes= new ArrayList<Cliente>();
	private ArrayList<Empleado> listaempleados= new ArrayList<Empleado>();
	private int numclientes=0, numempleados=0,numproductos=0, numventas=0, numficheros=0;
	

	public int getNumClientes(){//Metodo para obtener el numero de clientes de la tienda
		return this.numclientes;
	}

	public int getNumEmpleados(){//Metodo para obtener el numero de empleados de la tienda
		return this.numempleados;
	}

	public int getNumProductos(){//Metodo para obtener el numero de productos de la tienda
		return this.numproductos;
	}
	
    public int getNumVentas(){//Metodo para obtener el numero de ventas de la tienda
		return this.numventas;
	}
    
    public int getNumFicheros(){//Metodo para obtener el numero de ficheros de la tienda
		return this.numficheros;
	}
    
/********************METODOS PARA GESTIONAR LA LISTA DE CLIENTES*****************************/
/*******************************************************************************************/
	public void setListaClientes(Cliente cliente){//M�todo para a�adir un cliente a la lista de clientes y aumentar el contador de clientes
		this.listaclientes.add(cliente);
		this.numclientes++;
	}
	public void modificarListaClientes(int posicion, Cliente cliente){//M�todo para modificar un determinado cliente dentro de la lista de clientes
		this.listaclientes.set(posicion, cliente);
		
	}
	public ArrayList<Cliente> getListaClientes(){//M�todo para obtener la lista de clientes
		return this.listaclientes;
	}
	public void EliminarCliente(int posicion){//M�todo para eliminar un cliente de la lista de clientes y decrementar el contador de clientes
		this.listaclientes.remove(posicion);
		this.numclientes--;
		
	}
	
/**********************METODOS PARA GESTIONAR LA LISTA DE EMPLEADOS***********************/
/****************************************************************************************/
	public void setListaEmpleados(Empleado empleado){//M�todo para a�adir un empleado a la lista de empleados y aumentar el contador de empleados
		this.listaempleados.add(empleado);
		this.numempleados++;
	}
	public ArrayList<Empleado> getListaEmpleados(){//M�todo para obtener la lista de empleados
		return this.listaempleados;
	}
	public void modificarListaEmpleados(int posicion, Empleado empleado){//M�todo para modificar un determinado cliente dentro de la lista de empleados
	
		this.listaempleados.set(posicion,empleado);
		
	}
	public void EliminarEmpleado(int posicion){//M�todo para eliminar un empleado de la lista de empleados y decrementar el contador de empleados
		this.listaempleados.remove(posicion);
		this.numempleados--;
		
	}
	
/*****************METODO PARA GESTIONAR LA LISTA DE PRODUCTOS****************************/
/***************************************************************************************/
	public void setCatalogo(Musica musica){//M�todo para a�adir un producto a la lista de productos y aumentar el contador de productos
		this.catalogo.add(musica);
		this.numproductos++;
	}
	public ArrayList<Musica> getCatalogo(){//M�todo para obtener la lista de productos
		return this.catalogo;
	}
	public void EliminarProductoCatalogo(int posicion){//M�todo para eliminar un producto de la lista de productos y decrementar el contador de productos
		this.catalogo.remove(posicion);
		this.numproductos--;
		
	}
	public void modificarCatalogo(int posicion, Musica musica){//M�todo para modificar un determinado producto dentro del cat�logo de la tienda
		this.catalogo.set(posicion, musica);
	}
	
	
	
}
