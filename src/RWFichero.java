
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class RWFichero{
	
	private FileWriter escribir;
	private FileReader leer;
	private String nombreArchivo;
	private BufferedReader bufferReader;
	private BufferedWriter bufferWriter;
	private PrintWriter salida;
	private int num_venta_fichero;
	private ArrayList<Venta> ventas_recibo=new ArrayList<Venta>();
    private float total_precio;
    
    public void setTotalPrecio(float elpreciototal){
    	this.total_precio=elpreciototal;
    }
    public float getTotalPrecio(){
    	return this.total_precio;
    }
	public int getNumVentaFichero(){
		return this.num_venta_fichero;
	}
	public void setNombreArchivo(String elnombreArchivo){
		this.nombreArchivo=elnombreArchivo;
	}
	public String getNombreArchivo(){
		return this.nombreArchivo;
	}
	public void escribirArchivoVenta(Venta venta, boolean cabecera, boolean fin)throws IOException{//Método para escribir en el fichero  el recibo de la venta
		
		
		if(cabecera==true){
			escribir=new FileWriter(this.nombreArchivo,false);
		}else{
			escribir=new FileWriter(this.nombreArchivo, true);
		}
		
		bufferWriter =new BufferedWriter(escribir);
		salida= new PrintWriter(bufferWriter);
		if(cabecera==true){
			this.num_venta_fichero=venta.getNumVenta();
			salida.println();
			salida.println("Numero de venta: "+venta.getNumVenta());
			salida.println("******************************************************");
			salida.println("******************************************************");
			salida.println("-----------------RECIBO DE COMPRA---------------------");
			salida.println(venta.getFechaVenta()+" "+venta.getHoraVenta()+"    www.musicalexperience.com");
			salida.println("------------------------------------------------------");
			salida.println("*****************MUSICAL EXPERIENCE*******************");
			salida.println("------------------------------------------------------");
			salida.println("Cliente: "+venta.getNombreClienteVenta()+" "+venta.getApellidosClienteVenta()+"   Código Cliente: "+venta.getCodigoClienteVenta());
			salida.println();
			salida.println("Empleado que le atendio: "+venta.getNombreEmpleadoVenta()+" "+venta.getApellidosEmpleadoVenta());
			salida.println("Código Empleado: "+venta.getCodigoEmpleadoVenta());
			salida.println();
		}else if(fin==false && cabecera==false){

			ventas_recibo.add(venta);
			salida.println();
			
			salida.println("-------------Producto vendido-------------------------");
			salida.println("Codigo del producto :" +venta.getCodigoMusica()+"         Precio:" +venta.getPrecio()+" €");
			salida.println("Formato:" +venta.getFormato());
			salida.println("Título:" +venta.getTitulo());
			salida.println("Autor:" +venta.getAutor());
			salida.println("Año:" +venta.getAño());
			salida.println("Duración:" +venta.getDuracion()+" min");
			
		}else if(fin==true){
			float total=0;
			for(int i=0; i<ventas_recibo.size();i++){
				total=total+ventas_recibo.get(i).getPrecio();
			}
			setTotalPrecio(total);
			salida.println("                                  TOTAL:" +total+" €");
			salida.println("------------------------------------------------------");
			salida.println("Hasta pronto!");
			salida.println();
	
			
		}
		salida.close();
		bufferWriter.close();
		escribir.close();
		
	}
	public void leerArchivoVenta(String nombrearchivo)throws FileNotFoundException, IOException{//Método para leer y mostrar por consola el recibo de la venta escrito en el fichero de texto 
		leer=new FileReader(nombreArchivo);
		bufferReader=new BufferedReader(leer);
		String cadena="";
		cadena=bufferReader.readLine();
		while(cadena!=null){
			System.out.println(cadena);
			cadena=bufferReader.readLine();
		}
		bufferReader.close();
		leer.close();
	}

	
	
	
}
