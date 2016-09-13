
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

public class Principal {
	private static Scanner teclado;
	private static Tienda tienda;


/***********************************************METODOS VARIOS***************************************************************/
/***************************************************************************************************************************/
//Método para generar el código de los empleados y los clientes-->Consistirá en el dni(sin letra)+numero de cliente o de empleado
	public static int CrearCodigoPersona(int a , int b){
		String sA = String.valueOf(a); //Pasamos el entero "a" a String-->sa
		String sB = String.valueOf(b); //Pasamos el entero "b" a String-->sb
		String res = sA + sB; //Concatenamos los dos string de forma que se verá sasb
		int resultado = Integer.parseInt(res); //Pasamos a entero la concatenacion sasb
		return resultado;//Devolvemos el resultado.
	}
//Método para generar el código de los productos-->Consistirá en numero de producto+[000:Vinilo  001:Casette   002:Cd]	
	public static String CrearCodigoMusica(int a , String sB){
		String sA = String.valueOf(a); //Pasamos el entero "a" a String -->sa
		String res = sA + sB; //Concatenamos los dos enteros sasb
		return res;//Devolvemos la concatenacion
	}
//Método para validar una entrada de tipo entero
	public static int ValidarEntero(){
			boolean numok=false; 
			int numero=0;
			
				do{//Este bucle se repetirá mientras que el numok=false, es decir, que el valir de entrada no sea valido
					
					try{
						  numero=teclado.nextInt();//Leemos el dato de entrada esperando que sea un entero
						  numok=true;//Si no salta la excepción ponemos numok=true
					      
					}catch(InputMismatchException e){//Si el dato de entrada es distinto de un entero saltara la excepcion
						System.out.println();
						System.out.println("Error. El dato introducido no es entero");//Escribimos por consola que el dato de entrada es erroneo
						System.out.println();
						System.out.print("Introduzca de nuevo el valor:");//Pedimos de nuevo el valor
						numok=false;//Como el dato no es correcto numok=false
					}
				      finally {//Para finalizar debemos limpiar el buffer de entrada para eliminar el \n que no elimina el metodo next.Int()
					teclado.nextLine();
				    }
					
				}while(!numok);
	     return numero;
	     }
//Metodo para validar un entrada de tipo decimal
	public static float ValidarDecimal(){
		boolean numok=false; 
	    float decimal=0;
		
			do{
				
				try{
					 decimal=teclado.nextFloat();//Leemos el dato de entrada como si fuera un Float
					  numok=true;//Si no salta la excepción ponemos numok=true
				      
				}catch(InputMismatchException e){//Si el dato introducido no es un Float capturamos la excepción
					System.out.println();
					System.out.println("Error. El dato introducido no es decimal");//Escribimos por consola que el dato de entrada es erroneo
					System.out.println();
					System.out.print("Introduzca de nuevo el valor:");//Pedimos de nuevo el valor
					numok=false;//Como el dato no es correcto numok=false
				}
			      finally {
				teclado.nextLine();//Para finalizar debemos limpiar el buffer de entrada para eliminar el \n que no elimina el metodo next.Float()
			    }
				
			}while(!numok);
			return decimal;
	}
//Método para validar una entrada de tipo letra
	public static String ValidarLetra(){
		boolean letraok=false; 
	    String letradni=null;
	    String letras="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		
		do{//Este bucle se ejecutará hasta que el usuario introduzca una letra 
			 letradni=teclado.nextLine();//Leemos el dato de entrada como si fuera un String
			 letradni = letradni.toUpperCase();//Lo pasamos a mayúsculas
			 if(letradni.length()==1 && letras.indexOf(letradni)!=-1){//Si solo hemos leido un caracter y este caracter es uno de los que se encuentran en la cadena letras
				 
				 letraok=true;//Activamos el flag de dato valido
								 
			 }else{//Si es mas de una letra o un dato distinto de los caracteres de la cadena letras
				 System.out.println();
				 System.out.println("Error. El dato introducido debe ser una letra.");//Informamos al usuario
				 System.out.println();
				 System.out.print("Introduzca de nuevo el valor: ");//Pedimos que introduzca de nuevo el valor
				 letraok=false;//desactivamos el flag de dato válido
			 }
			}while(!letraok);
					 
		return letradni;//Devolvemos la letra leida
	}
//Metodo para validar las fechas de entrada-->Comprueba que el formato, los dias, los meses y los años sean correctos.
    public static String ValidarFecha(){
			String barra="/";//Guardamos el caracter especial en una variable llamada barra
			String fecha=null;
			boolean fechaok=false;//Bandera para validar la fecha
			boolean bisiesto=false;//Bandera para saber si el año es bisiesto
		
			do{//Este bucle se ejecutará mientras la fecha introducida no sea válida
				
		   try{
				fecha=teclado.nextLine();//Leemos la fecha como String
		    
				String sdia=fecha.substring(0,2);//Cogemos del String fecha los caracteres 0 y 1  que sera el dia
				String smes=fecha.substring(3,5);//Cogemos del String fecha los caracteres 3 y 4  que sera el mes
				String sanyo=fecha.substring(6,10);//Cogemos del String fecha los caracteres 6,7,8,9  que sera el año
				
				//Pasamos los String dia, mes y año a entero
				int dia = Integer.parseInt(sdia);
				int mes = Integer.parseInt(smes);
				int anyo = Integer.parseInt(sanyo);	
				
			if(barra.equals(fecha.substring(2,3)) && barra.equals(fecha.substring(5,6)) ){//Si el caracter 2 y el caracter 5 son iguales a la barra el formato es adecuado
				if(anyo>1900 && sanyo.length()==4){//Comprobamos que el año introducido es correcto
				  
				   if(mes>0 && mes<13){//Comprabamos que el mes introducido es correcto
					   if( ((dia<31) && (dia>0)) && (mes==4 || mes==6 ||mes==9 || mes==11)){//Vemos que los dias de Abril, Junio, Septiembre y Noviembre no excedan de 31
						 fechaok=true;
					   }
					   else if( ((dia<32) && (dia>0)) && (mes!=4 || mes!=6 ||mes!=9 || mes!=11 || mes!=2)){//Vemos que los dias de los meses que no sean Abril, Junio, Septiembre y Febrero no excedan de 30 dias
						 fechaok=true;  
					   }
					   else if(mes==2){//Si el mes introducido es Febrero
						   bisiesto=DetectarAnyoBisiesto(anyo);//Comprobamos si el año es bisiesto
						   if(dia<30 && dia>0 && bisiesto==true){//Si el año es bisiesto el mes podra tener 29 dias
						   fechaok=true;
						    }
						   else if(dia<29 && dia >0 && bisiesto==false){//Si el año no es bisiesto el mes solo podra tener 28
							   fechaok=true;
						   }
						   else{//El resto de situaciones el dia del mes de Febrero no es correcto
							   fechaok=false;
							   System.out.println();
							   System.out.println("Error. Día introducido incorrecto.");
							   System.out.println();
							   System.out.print("Introduzca de nuevo la fecha: ");
						   }
					   }
					   else{//El resto de situaciones el dia introducido será incorrecto
						   fechaok=false;
						   System.out.println();
						   System.out.println("Error. Dia introducido incorrecto.");
						   System.out.println();
						   System.out.print("Introduzca de nuevo la fecha: ");
						   
					   }
				   }else{//El resto de situaciones el mes introducido será incorrecto
					   System.out.println();
					   System.out.println("Error. Mes introducido incorrecto.");
					   System.out.println();
					   System.out.print("Introduzca de nuevo la fecha: ");
					   fechaok=false;
				   }
				
				}else {//El resto de situaciones el año introducido será incorrecto
					System.out.println();
					System.out.println("Error. Año introducido incorrecto.");
					System.out.println();
					System.out.print("Introduzca de nuevo la fecha: ");
					fechaok=false;
				}
				
		   }else{//Si los caracteres 2 y 5 no son una barra el formato de la fecha introducida es incorrecto
			   System.out.println();
			  System.out.println("Error. Fecha introducida con formato erróneo.");  
			  System.out.println();
			   System.out.print("Introduzca de nuevo la fecha: "); 
		   }
		   }catch(NumberFormatException e){//La excepcion saltará si introducimos algun caracter especial 
			   System.out.println();
			   System.out.println("Error. Algun dato introducido es un caracter especial.");
			   System.out.println();
			   System.out.print("Introduzca de nuevo la fecha: ");
			   fechaok=false;
		  }catch(StringIndexOutOfBoundsException e){//La excepción saltará la fecha tenga menos de 10 caracteres
			  System.out.println();
			   System.out.println("Error. Fecha introducida con formato erróneo.");  
			   System.out.println();
			   System.out.print("Introduzca de nuevo la fecha: ");
			   fechaok=false;
			   
		   }
		}while(!fechaok);
			return fecha;//Retornamos el valor de la fecha validada
	 
}
 //Metodo para detectar si el año es bisiesto
    public static boolean DetectarAnyoBisiesto(int anyo){
    	boolean bisiesto=false;//Bandera para indicar si el año es o no bisiesto
    	    	
			if(((anyo%100!=0)|| (anyo%400==0)) && (anyo%4==0)){//Los años divisibles por 4 son bisiestos, pero cada 400 años se deben eliminar 3 bisiestos. Para ello, no son bisiestos los que se dividen por 100, menos los que se dividen por 400, que sí son bisiestos.
				bisiesto=true;
			}
			else{
				bisiesto=false;
			}
		  	
    	return bisiesto;//Devolvemos true si el año es bisiesto y false si no lo es
    }
//Metodo para validar formato del producto
    public static String ValidarFormatoProducto(){
    	boolean formatook=false;
    	String formato=null;
    	do{//Este bucle se repetirá hasta que no introduzcamos uno de los tres formatos
    	
    		formato=teclado.nextLine();
    		formato=formato.toLowerCase();//Si escribimos el formato en mayusculas lo pasamos a minusculas
    		if(formato.equals("vinilo") ||formato.equals("casette") ||formato.equals("cd")){//Si el formato es cualquiera de los tres permitidos
    			formatook=true;
    		}
    		else{//Si el formato introducido no es permitido
    			System.out.println();
    			System.out.println("Error.El formato introducido es incorrecto.");
    			System.out.println();
    			System.out.print("Por favor introduca de nuevo el formato: ");
    			formatook=false;
    		}
    		
    	}while(!formatook);
    	return formato;//Devolvemos true si el formato introducido es vinilo, casette o cd y false en caso contrario
    }
//Método para preguntar al usuario si desea repetir una opcion
    public static String DeseaRepetir(){
    	String repetir="no";
    	boolean opcion_valida=false;
    	do{ //Preguntaremos al usuario si desea salir hasta que introduzca si o no
			
			repetir=teclado.nextLine();
			repetir=repetir.toLowerCase();//Pasamos el string a minúsculas
			if(repetir.equals("si")){//Si repeptir es si la opcion es valida
				opcion_valida=true;
				
			}else if(repetir.equals("no")){//Si repetir es no lo opcion es valida
				opcion_valida=true;
			}else{//Si repetir no es si ni no la opcion no es valida
				opcion_valida=false;
				System.out.println();
				System.out.print("Opción no válida. Introduzca si o no: ");
			}
			
		}while(opcion_valida==false);
   	return repetir;
    }
//Método para obtener la extensión de un archivo
    public static String getExtension(String filename) {
        int index = filename.lastIndexOf('.');//Buscamos la posicion del caracter '.' dentro del nombre
        if (index == -1) {//Si devuelve un -1 indica que no se encontro el punto y devolvemos un caracter vacío
              return "";
        } else {//Si lo econtro retornamos la cadena a partir del punto, es decir, el formato
              return filename.substring(index + 1);
        }
}
//Método para validar que lo que se introduce es un correo electronico
    public static String ValidarCorreo(){
    	boolean correo_valido=false;
    	String correo;
    	do{//Este bucle se repitirá hasta que el correo introducido por el usuario sea válido
    		correo=teclado.nextLine();//Leemos el correo introducido por el usuario
	    	int posicion_arroba = correo.indexOf("@");//Buscamos el caracter '@'
	    	int posicion_punto=correo.indexOf("."); //Buscamos el caracter '.'
	    	if(posicion_arroba!=-1 && posicion_punto!=-1){//Si encuentra ambos caracteres el dato introducido es un correo electrónico
	    	 correo_valido=true;//Activamos el flag de correo valido
	    	}else{//Si no encuentra los caracteres el correo introducido no es valido y lo volvemos a pedir al usuario
	    		System.out.println();
	    		System.out.println("Error. La dirección de correo introducida no es válida.");
	    		System.out.println();
	    		System.out.print("Introduzca de nuevo la direccion de correo electrónico: ");
	    	}
    	}while(correo_valido==false);
    	return correo;//Devolvemos el correo
    }
//Método obtener la lista de archivos del directorio 
   public static ArrayList<String> ObtenerListaVentas(){
	  
	   File ruta = new File("");//Creamos un archivo que nos servirá para obtener la ruta del directorio donde se guardan los archivos del programa por defecto y no introducirla cuando el programa se ejecute en otro pc
	   String ruta_ficheros= ruta.getAbsoluteFile().toString();//Obtenemos la ruta del directorio
	   File directorio=new File(ruta_ficheros);//Creamos un nuevo archivo que apuntará a la ruta del directorio
	   ruta.delete();//Eliminamos el archivo que nos sirvio para obtener la ruta
	   String[] archivos=directorio.list();//Guardamos en una matriz la lista de archivos que se encuentran en el directorio
	   ArrayList<String> ventas= new ArrayList<String>();//Creamos un array para almacenar los que de los archivos anteriores son ventas
	   int tamano=archivos.length;
	   for(int i=0;i<tamano;i++){//Recorremos la matriz con la lista de archivos
		   String formato=getExtension(archivos[i]);//Vamos viendo el formato de cada uno de ellos
		   if(formato.equals("txt")&& archivos[i].substring(0, 5).equals("venta")){//Si el formato es txt y va precedido de la palabra venta
			   ventas.add(archivos[i]);//añadimos el archivo a la lista de archivos de venta
			   
		   }
		   
	   }
	   
	   return ventas;//Devolvemos la lista de ventas obtenidas
   }
//Método para obtener la ultima venta realizada   
   public static int NumeroUltimaVenta(){
		ArrayList<String> ventas=ObtenerListaVentas();//Obtenemos la lista con el nombre de los archivos de venta
		int numventa=-1;
		if(ventas.size()!=0){//Si hay ventas en la lista
			String ultima_venta=ventas.get(ventas.size()-1);//Cogemos el nombre de la ultima venta de la lista
			int indice_punto=ultima_venta.lastIndexOf('.');//Obtenemos la posicion del punto dentro del nombre de la ultima venta
			String venta=ultima_venta.substring(5, indice_punto);//Cogemos el numero de venta de la ultima venta
			numventa=Integer.parseInt(venta);//Convertimos el numero de string a entero
		}
	
		return numventa;//Devolvemos el numero de la ultima venta, devolverá -1 en caso de que no haya ventas
	} 
   /*****************************METODOS PARA CREAR CLIENTE, EMPLEADO, MUSICA Y VENTA************************************************/
/********************************************************************************************************************************/    
//MÉTODO PARA CREAR UN CLIENTE
	public static void CrearCliente(Tienda tienda) {
		String repetir="no";
		do{
				
			Cliente cliente=new Cliente();//Creamos una instacion una clase Cliente
			
			//Rellenamos todos los parametros de la Clase
			System.out.print("Introduzca el nombre del cliente: ");
			cliente.setNombre(teclado.nextLine());
			System.out.print("Introduzca los apellidos del cliente: ");
			cliente.setApellidos(teclado.nextLine());
			System.out.print("Introduzca la fecha de nacimiento del cliente (dd/mm/aaaa): ");
			cliente.setFechaNacimiento(ValidarFecha()); 
			System.out.print("Introduzca el  numero dni sin letra del cliente: ");
			cliente.setDni(ValidarEntero()); 
			System.out.print("Introduzca el la letra del dni del cliente: ");
			cliente.setLetraDni(ValidarLetra()); 
			System.out.print("Introduzca el domicilio del cliente: ");
			cliente.setDomicilio(teclado.nextLine());
			System.out.print("Introduzca el código postal del cliente: ");
			cliente.setCp(ValidarEntero());
			System.out.print("Introduzca la localidad del cliente: ");
			cliente.setLocalidad(teclado.nextLine()); 
			System.out.print("Introduzca la provincia del cliente: ");
			cliente.setProvincia(teclado.nextLine()); 
			System.out.print("Introduzca el telefono del cliente: ");
			cliente.setTelefono(ValidarEntero());
			System.out.print("Introduzca el  correo electrónico del cliente: ");
			cliente.setCorreo(ValidarCorreo());
				
			// El código de cliente será un número compuesto:dni(sin letra)+ numerodecliente
			cliente.setCodigoCliente(CrearCodigoPersona(cliente.getDni(),tienda.getNumClientes()));
			//Introducimos el cliente nuevo en la lista de clientes de la clase Tienda
			tienda.setListaClientes(cliente);
			//Indicamos que el cliente se creo correctamente con el código correspondiente
			System.out.println();
			System.out.println("Cliente creado correctamente con codigo "+cliente.getCodigoCliente());
			System.out.println();
			System.out.print("¿Desea crear otro cliente?: ");
			repetir=DeseaRepetir();
			System.out.println();
		}while(repetir.equals("si"));
		
		
	}
//METODO PARA CREAR UN EMPLEADO
	public static void CrearEmpleado(Tienda tienda){
		String repetir="no";
		do{//Este bucle se repetira hasta que el usuario diga que no desea crear más empleados
			
			//Creamos una clase empleado nueva donde guardaremos todos los datos de nuestro nuevo empleado
			Empleado empleado=new Empleado();
			
			
			//Pedimos todos los datos del empleado
			System.out.print("Introduzca el nombre del empleado: ");
			empleado.setNombre(teclado.nextLine());
			System.out.print("Introduzca los apellidos del empleado: ");
			empleado.setApellidos(teclado.nextLine());
			System.out.print("Introduzca la fecha de nacimiento del empleado (dd/mm/aaaa): ");
			empleado.setFechaNacimiento(ValidarFecha()); 
			System.out.print("Introduzca el  numero dni sin letra del empleado: ");
			empleado.setDni(ValidarEntero()); 
			System.out.print("Introduzca la letra del dni  del empleado: ");
			empleado.setLetraDni(ValidarLetra()); 
			System.out.print("Introduzca el domicilio del empleado: ");
			empleado.setDomicilio(teclado.nextLine()); 
			System.out.print("Introduzca el código postal del empleado: ");
			empleado.setCp(ValidarEntero());
			System.out.print("Introduzca la localidad del empleado: ");
			empleado.setLocalidad(teclado.nextLine()); 
			System.out.print("Introduzca la provincia del empleado: ");
			empleado.setProvincia(teclado.nextLine());
			System.out.print("Introduzca el  telefono del empleado: ");
			empleado.setTelefono(ValidarEntero()); 
			System.out.print("Introduzca el  correo electrónico del empleado: ");
			empleado.setCorreo(ValidarCorreo());
			System.out.print("Introduzca el numero de la seguridad social del empleado: ");
			empleado.setNumeroSegSocial(teclado.nextLine());
			System.out.print("Introduzca el sueldo mensual que va a percibir el empleado: ");
			empleado.setSueldo(ValidarDecimal());
			System.out.print("Introduzca el puesto a desempeñar por el empleado: ");
			empleado.setPuesto(teclado.nextLine());
			
			//Generamos el código del empleado
			empleado.setCodigoEmpleado(CrearCodigoPersona(empleado.getDni(),tienda.getNumEmpleados()));
			//Mostramos por consola el empleado creado y el puesto que desempeñara
			System.out.println();
			System.out.print("El empleado con identificador "+empleado.getCodigoEmpleado()+" con puesto de "+empleado.getPuesto()+" se ha creado correctamente");
			System.out.println();
			//Iniciamos el numero de ventas del empleado a cero
			empleado.setNumeroVentasEmpleado(0);
			empleado.setTotalPrecioVentas(0);
			
			//Introducimos el empleado en la lista de empleados de la tienda
			tienda.setListaEmpleados(empleado);
			
			//Preguntamos al usuario si desea crear otro empleado
			System.out.println();
			System.out.print("¿Desea registrar otro empleado: ");
			repetir=DeseaRepetir();
			System.out.println();
		}while(repetir.equals("si"));	
	}
//METODO PARA CREAR UN PRODUCTO
	public static void CrearMusica(Tienda tienda){
		 String repetir="no";
		
		 do{//El bucle se reptira hasta que el usuario indique que no desea registrar más productos
			 String codigomusica=null;
			 Musica musica=new Musica();
				
			 //Pedimos el formato del nuevo producto
			 System.out.print("Introduce el formato del producto: ");
			 //Comprobamos que el formato introducido es uno de los permitidos
			 String formato=ValidarFormatoProducto();
			//Introducimos el formato validado
			 musica.setFormato(formato);
			
			//Según el formato elegido se creará el codigo correspondiente
			 switch(formato){
				case "vinilo"://Si el formato es vinilo el codigo será numero_de_producto+000
					codigomusica=CrearCodigoMusica(tienda.getNumProductos(),"000");
					break;
				case "casette"://Si el formato es casette el codigo será numero_de_producto+001
					codigomusica=CrearCodigoMusica(tienda.getNumProductos(),"001");
					break;
				case "cd"://Si el formato es cd el codigo será numero_de_producto+002
					codigomusica=CrearCodigoMusica(tienda.getNumProductos(),"002");
				default:
					break;
				}
			     //Introducimos el codigo creado
			     musica.setCodigoMusica(codigomusica);
			     //Introducimos el resto de datos del producto 
				 System.out.print("Introduce el titulo del "+musica.getFormato()+" : ");
				 musica.setTitulo(teclado.nextLine());
			
				 System.out.print("Introduce el autor del "+musica.getFormato()+" : ");
				 musica.setAutor(teclado.nextLine());
				
				 System.out.print("Introduce el año del "+musica.getFormato()+" : ");
				 musica.setAño(ValidarEntero());
				
				 System.out.print("Introduce el precio del "+musica.getFormato()+" : ");
				 musica.setPrecio(ValidarDecimal());
				
				 System.out.print("Introduce la duracion en minutos del "+musica.getFormato()+" : ");
				 musica.setDuracion(ValidarEntero());
				 
				 System.out.print("Introduce el número de copias del producto: ");
				 musica.setNumeroCopias(ValidarEntero());
								
				 //Introducimos el producto creado en la lista de productos de la tienda
				 tienda.setCatalogo(musica);
				 System.out.println();
				 //Indicamos al usuario que el producto se creó correctamente
				 System.out.println("Producto creado correctamente con codigo "+musica.getCodigoMusica());
				 System.out.println();
				 
				 //Preguntamos al usuario si desea registrar otro producto
				 System.out.print("¿Desea registrar otro producto?: ");
				 repetir=DeseaRepetir();
				 System.out.println();
		}while(repetir.equals("si"));
	}
//METODO PARA CREAR UNA VENTA
	public static void CrearVenta(Tienda tienda){
		String repetir="no";
		boolean  cabecera=true, fin=false;
		RWFichero fichero=new RWFichero();
		
		//Se pide el empleado que va a despachar la venta y se comprueba que es valido, es decir, que existe dicho empleado
		Empleado empleado=ValidarEmpleadoVenta(tienda);
		if(empleado!=null){
			do{//Este bucle se repetirá hasta que el usuario no desee registrar más ventas
					//Se pide el cliente que va a realizar la compra y se comprueba que es valido, es decir, que existe dicho cliente
					Cliente cliente=ValidarClienteVenta(tienda);
					if(cliente!=null){
						do{
							//Se pide el producto que se va a vender  y se comprueba que es valido, es decir, que existe dicho producto y que no esta agotado
							Musica musica=ValidarMusicaVenta(tienda);
							
							if(musica!=null){
								//Obtenemos el número de ventas que lleva realizadas dicho empleado y la incrementamos
								int numerodeventas=empleado.getNumeroVentasEmpleado()+1;
								
								//Actualizamos el número de ventas de este empleado
								empleado.setNumeroVentasEmpleado(numerodeventas);
																
								//Informamos al usuario que el número de ventas del empleado
								System.out.println();
								System.out.println("Numero de productos vendidos por el empleado "+empleado.getCodigoEmpleado()+" : "+empleado.getNumeroVentasEmpleado());
								
								//Informamos al usuario que el producto se asigno a la venta
								System.out.println("Producto "+musica.getCodigoMusica()+" asignada a la venta actual");
															
								//Creamos la Venta con los datos del cliente, el empleado y el producto
								Venta venta=RellenarDatosVenta(empleado, cliente, musica);
								
								//Introducimos en la lista de clientes el cliente con la lista de compras actualizada
								tienda.modificarListaClientes(BuscarCliente(cliente.getCodigoCliente(),tienda), cliente);
							
								//Creamos el fichero
								
								if(cabecera==true){
									fichero=new RWFichero();//Creamos un objeto de la clase RWFichero
									int nuevaventa=NumeroUltimaVenta()+1;//Obtenemos el numero de venta que se va a realizar que será la ultima existente mas 1
									String nombreArchivo="venta"+nuevaventa+".txt";//Creamos el nombre del nuevo fichero de venta con el formato de texto
																	
									//Ponemos nombre al archivo que hemos creado al objeto fichero
									fichero.setNombreArchivo(nombreArchivo);
									
								    RegistrarVenta(venta, fichero, cabecera, fin);//Registramos la cabecera del recibo en el fichero de texto
								    cabecera=false;//Desactivamos el flag de cabecera 
								    
								}
																						
								//Registramos la venta en dicho fichero
								RegistrarVenta(venta, fichero, cabecera, fin);
								System.out.println();
							}
								//Preguntamos al usuario si el cliente va a realizar otra compra
								System.out.print("¿Desea realizar el cliente otra compra?: ");
								repetir=DeseaRepetir();
								System.out.println();
								if (repetir.equals("no")){//Si el cliente no deseara realizar otra compra
										
									fin=true;//Activamos el flag de fin 
									RegistrarVenta(null, fichero, cabecera, fin);//Registramos la parte final del fichero con el precio total en el archivo de texto
									empleado.setTotalPrecioVentas(fichero.getTotalPrecio());
								}
								//Actualizamos el empleado que realizo las ventas
								tienda.modificarListaEmpleados(BuscarEmpleado(empleado.getCodigoEmpleado(),tienda), empleado);
													
						}while(repetir.equals("si"));
						
					}
				//Preguntamos al usuario si este empleado va a realizar otra venta
				System.out.print("¿Desea el empleado realizar otra venta?: ");
				repetir=DeseaRepetir();	
				System.out.println();
				//Activamos el flag de cabecera y desactivamos el flag de fin  por si el empleado fuera a desapachar a otro cliente
				cabecera=true;
			    fin=false;
								
				}while(repetir.equals("si"));
			
		
		
		}
	}
	
/*****************************METODOS PARA VALIDAR QUE EXISTE UN CLIENTE, EMPLEADO, MUSICA Y VENTA***********************************************/
/***********************************************************************************************************************************************/    	
//MÉTODO PARA VALIDAR QUE EXISTE EL EMPLEADO QUE VA A DESPACHAR LA VENTA	
	public static Empleado ValidarEmpleadoVenta(Tienda tienda){
		int posicion_empleado=0;
		Empleado empleado=new Empleado();
		String repetir="no";
		do{//Este bucle se repetira si se introdujo el codigo de un empleado que no existe y se desea introducir uno nuevo
			
			//Pedimos el código del empleado que va a realizar la venta
			System.out.print("Introduce código de empleado: ");
			int codigo_empleado=ValidarEntero();
			//Buscamos la posición del empleado que se corresponde con el código introducido dentro de la lista de empleados
			posicion_empleado=BuscarEmpleado(codigo_empleado, tienda);
			if(posicion_empleado!=-1){//Si la posicion del empleado el distinta de -1 significa que ese empleado esta registrado
				
				//Obtenemos el empleado que atiende la venta de la lista de empleados a través de su posición
				empleado=tienda.getListaEmpleados().get(posicion_empleado);
				
			}else{//Si la posicion del empleado es -1, el empleado asociado al codigo introducido no existe
				
				//Se comunica al usuario que el empleado no existe
				System.out.println();
				System.out.println("El empleado  introducido no existe.");
				System.out.println();
				
				//Se pregunta al usuario si desea introducir otro codigo de empleado
				System.out.print("¿Desea intentarlo de nuevo?: ");
				repetir=DeseaRepetir();
				System.out.println();
			}
		}while(posicion_empleado==-1 && repetir.equals("si"));
	    
		if(posicion_empleado==-1){//Si el usuario no quiere repetir la opcion y el empleado introducido no es valido, la funcion retorna un null
	    	return null;
	    }
	    else{//Si introducimos un empleado valido la funcion devolverá el empleado que va a despachar la venta
	    	return empleado;
	    }
	}
//MÉTODO PARA VALIDAR QUE EL CLIENTE QUE VA A REALIZAR LA COMPRA ESTA REGISTRADO	
	public static Cliente ValidarClienteVenta(Tienda tienda){
		Cliente cliente=new Cliente();
		String repetir="no";
		int posicion_cliente=-1;
		do {//Este bucle se repetira si se introdujo el codigo de un cliente que no existe y se desea introducir uno nuevo
		
			//Pedimos el código del cliente que va comprar
			System.out.print("Introduce código del cliente: ");
			int codigo_cliente=ValidarEntero();
			
			//Buscamos la posición del cliente que se corresponde con el código introducido dentro de la lista de clientes
			 posicion_cliente=BuscarCliente(codigo_cliente, tienda);
			
			 if(posicion_cliente!=-1){//Si la posicion del cliente es distinta de -1 significa que ese cliente esta registrado
				 
				 //Obtenemos el empleado que realiza la compra de la lista de clientes a través de su posición 
				cliente=tienda.getListaClientes().get(posicion_cliente);
			
			 }else{//Si la posicion del cliente es -1, el cliente asociado al codigo introducido no existe
				
				 //Se comunica al usuario que el cliente no existe
				 System.out.println();
				 System.out.println("El cliente  introducido no existe.");
				 System.out.println();
				 //Se pregunta al usuario si desea introducir otro codigo de cliente
				 System.out.print("¿Desea intentarlo de nuevo?: ");
				 repetir=DeseaRepetir();
				 System.out.println();
			}
		
		}while(posicion_cliente==-1 && repetir.equals("si"));
		
		if(posicion_cliente==-1){//Si el usuario no quiere repetir la opcion y el cliente introducido no es valido, la funcion retorna un null
			return null;
		}else{//Si introducimos un cliente válido la función devolverá el cliente que va a realizar la compra
			return cliente;
		}
	}
//MÉTODO PARA VALIDAR QUE UN PRODUCTO ESTE EN CATALOGO	PARA REALIZAR LA VENTA
	public static Musica ValidarMusicaVenta(Tienda tienda){
		
		Musica musica= new Musica();
		int posicion_musica=-1;
		String repetir="no";
		
		do{//Este bucle se repetira si se introdujo el codigo de un producto que no existe y se desea introducir uno nuevo
			
			//Pedimos el código del producto que va a comprar el cliente
			System.out.print("Introduce código del producto: ");
			String codigo_musica=teclado.nextLine();
			
			//Buscamos la posición del producto  que se corresponde con el código introducido dentro de la lista de productos
			posicion_musica=BuscarMusica(codigo_musica, tienda);
			
			if(posicion_musica!=-1){//Si la posicion del producto es distinta de -1 significa que ese producto esta registrado
				
				//Obtenemos el producto que se va a comprar de la lista de productos a través de su posición
				musica=tienda.getCatalogo().get(posicion_musica);
				
				if(musica.getNumeroCopias()>0){//Comprobamos que quedan unidades del producto
					int numero_copias=musica.getNumeroCopias();//Obtenemos el número de copias
					
					if(numero_copias>1){//Si hay mas de una copia
						
						numero_copias--;//Decrementamos el contador porque vamos a vender la copia
						musica.setNumeroCopias(numero_copias);//Establecemos el numero de copias del producto actualizado
						tienda.modificarCatalogo(posicion_musica, musica);//Actualizamos el catálogo
					
					}else if(numero_copias==1){//Si el numero de copias es 1
						tienda.EliminarProductoCatalogo(posicion_musica);//Eliminamos el producto del catalogo	
					}
			
				}
			
			}else{//Si la posicion del producto es -1, el producto asociado al codigo introducido no existe

				//Se comunica al usuario que el producto no existe
				System.out.println();
				System.out.println("El producto  introducido no existe o esta agotado.");
				System.out.println();
				//Se pregunta al usuario si desea introducir otro codigo de producto
				System.out.print("¿Desea intentarlo de nuevo?:  ");
				repetir=DeseaRepetir();
				System.out.println();
				
			}
		}while(posicion_musica==-1 && repetir.equals("si"));
		
		if(posicion_musica==-1 && repetir.equals("no")){//Si el usuario no quiere repetir la opcion y el producto introducido no es valido, la funcion retorna un null
			return null;
		}
		else{//Si introducimos un producto válido la función devolverá el producto que se va a comprar
		return musica;
		}
	}
//METODO PARA VALIDAR LA EXISTENCIA DE UN FICHERO DE VENTA	
	public static boolean ValidarVenta(String nombrearchivo){
		boolean fichero_encontrado=false;//Ponemos el flag de fichero encontrado a false
		ArrayList<String> ventas=ObtenerListaVentas();//Obtenemos la lista de nombres de archivos de venta
		int numventas=ventas.size();//Obtenemos el numero de archivos de ventas
	 	
		for(int i=0; i<numventas;i++){//Vamos a recorrer toda la lista de nombre de archivos de venta
	 		if(nombrearchivo.equals(ventas.get(i))){//Si el nombre introducido coincide con alguno
	 			fichero_encontrado=true;//Activamos el flag de que el fichero ha sido encontrado
	 			i=numventas;//Forzamos salir del bucle
	 		}
	 	}
			
		return fichero_encontrado;//Retornamos el flag de fichero encontrado que será true si existe el fichero y false si no.
	}

/***********************************METODOS PARA RELLENAR LOS DATOS DE UNA VENTA Y REGISTRARLA EN UN FICHERO************************************/
/**********************************************************************************************************************************************/
//MÉTODO PARA RELLENAR LOS DATOS DE UNA VENTA	
    public static Venta RellenarDatosVenta(Empleado empleado, Cliente cliente, Musica musica){
		  //Creamos un objeto de la clase Venta  
		  Venta venta=new Venta();
		 
		  //Asignamos al objeto la fecha y la hora en la que se realiza la venta
		  venta.setFechayHora();
		  
		  //Asignamos al objeto el nombre, apellidos y código del empleado que atendió la venta
		  venta.setNombreEmpleadoVenta(empleado.getNombre());
		  venta.setApellidosEmpleadoVenta(empleado.getApellidos());
		  venta.setCodigoEmpleadoVenta(empleado.getCodigoEmpleado());
		  
		  //Asignamos al objeto el nombre, apellidos y código del cliente que realiza la compra
		  venta.setNombreClienteVenta(cliente.getNombre());
		  venta.setApellidosClienteVenta(cliente.getApellidos());
		  venta.setCodigoClienteVenta(cliente.getCodigoCliente());
		  
		  //Asignamos al objeto el título, autor, año, duración, formato, precio y código del producto que se va a comprar
		  venta.setTitulo(musica.getTitulo());
		  venta.setAutor(musica.getAutor());
		  venta.setAño(musica.getAño());
		  venta.setDuracion(musica.getDuracion());
		  venta.setFormato(musica.getFormato());
		  venta.setPrecio(musica.getPrecio());
		  venta.setCodigoMusica(musica.getCodigoMusica());
		  //Como en cada venta solo puede registrarse un producto
		  venta.setNumeroCopias(1);
		  
		  //Asignamos al objeto el numero de venta que es el numero de la ultima venta realizada mas 1
		
		  venta.setNumVenta(NumeroUltimaVenta()+1);
	
		//Devolvemos el objeto venta creado
		return venta;
	}  
//METODO PARA REGISTRAR LAS VENTAS EN UN FICHERO TXT
	public static void RegistrarVenta(Venta venta, RWFichero fichero, boolean cabecera, boolean fin){
		
		try{
			//Escribimos la venta en el fichero
			fichero.escribirArchivoVenta(venta, cabecera, fin);
		}catch(IOException e){//Si se produce un error al escribir el archivo capturamos la excepción
			System.out.println();
			System.out.println("Error al escribir en el archivo");
			System.out.println();
		}
		if(fin==true){
		try{//Mostramos por pantalla el fichero escrito 
			fichero.leerArchivoVenta(fichero.getNombreArchivo());
		}catch(FileNotFoundException e){//Si se produce un error al abrir el archivo capturamos la excepción
			System.out.println();
			System.out.println("Error al abrir el archivo");
			System.out.println();
		}catch(IOException e){//Si se produce un error al leer el archivo capturamos la excepción
			System.out.println();
			System.out.println("Error al leer el archivo");
			System.out.println();
		}
		}
		
	}

/*****************************METODOS PARA LISTAR CLIENTES, EMPLEADOS, MUSICA Y VENTAS************************************************/	
/************************************************************************************************************************************/
//METODO PARA LISTAR UNO/TODOS LOS CLIENTES O EMPLEADOS
   public static void ListarPersona(Tienda tienda, String tipo, String opcion){
	 //La variable tipo nos indicará que queremos mostrar: clientes o empleados
	 //La variable opcion nos indica si queremos ver todos los clientes o uno en concreto	
	   int posicion_cliente=0, posicion_empleado=0;
	   String repetir="no";
		switch(tipo){
		case "cliente"://Vamos a mostrar clientes
			if (opcion=="todos"){//Vamos a mostrar todos los clientes 
				
				ArrayList<Cliente> listaclientes=tienda.getListaClientes();//Obteneemos la lista de clientes
				System.out.println("------------------------------------------------------");
				for(int i=0;i<listaclientes.size();i++){//Recorremos la lista de clientes
					MostrarCliente(listaclientes.get(i));//Mostramos los clientes uno por uno
			     }
				System.out.println("------------------------------------------------------");
				System.out.println();
			}else if(opcion=="uno"){//Vamos a mostrar un cliente concreto
				
				do{//Este bucle se ejecutará hasta que el usuario desee salir de la opcion
					
					//Pedimos el código del cliente que se desea mostrar
					System.out.print("Introduzca el código del cliente: ");
					int codigo=ValidarEntero();
					
					//Obtenemos la posición del cliente que se corresponde con el codigo
					posicion_cliente=BuscarCliente(codigo, tienda);
					
					if(posicion_cliente!=-1){//Si la posición es distinta -1 indicará que existe el cliente con el código introducido y pasaremos a mostrarlo por consola
						System.out.println();
						System.out.println("------------------------------------------------------");
						MostrarCliente(tienda.getListaClientes().get(posicion_cliente));
						System.out.println("------------------------------------------------------");
					}else{//Si la posición es -1 el cliente con el código introducido no existe y llamaremos de nuevo a la funcion 
						System.out.println();
						System.out.println("El cliente introducido no existe.");
						
					}
					//Preguntamos al usuario si desea buscar otro cliente
					System.out.println();
					System.out.print("¿Desea buscar otro cliente?: ");
					repetir=DeseaRepetir();
					System.out.println();
				}while(repetir.equals("si"));
			}
			
			break;
		case "empleado"://Vamos a mostrar empleados
			if(opcion=="todos"){//Vamos a mostrar a todos los empleados de la tienda
				
				ArrayList<Empleado> listaempleados=tienda.getListaEmpleados();//Obtenemos la lista de empleados de la tienda
				System.out.println("------------------------------------------------------");
				for(int i=0;i<listaempleados.size();i++){//Recorremos la lista de empleados
					MostrarEmpleado(listaempleados.get(i));//Mostramos los empleados uno por uno
				}
				System.out.println("------------------------------------------------------");
				System.out.println();
			}else if(opcion=="uno"){//Vamos a mostrar un empleado concreto de la tienda
				
				do{//Este bucle se ejecutará hasta que el usuario desee salir de la opcion
					
					//Pedimos el código del empleado a mostrar
					System.out.print("Introduzca el código del empleado: ");
					int codigo=ValidarEntero();
					
					////Obtenemos la posición del cliente que se corresponde con el codigo
					posicion_empleado=BuscarEmpleado(codigo, tienda);
					
					
					if(posicion_empleado!=-1){//Si la posición es distinta -1 indicará  que existe el empleado con el código introducido y pasaremos a mostrarlo por consola
						System.out.println();
						System.out.println("------------------------------------------------------");
						MostrarEmpleado(tienda.getListaEmpleados().get(posicion_empleado));
						System.out.println("------------------------------------------------------");
					}else{ //Si la posición es -1 el empleado con el código introducido no existe y llamaremos de nuevo a la funcion 
						System.out.println();
						System.out.println("El empleado introducido no existe.");
						
					}
					//Preguntamos al usuario si desea buscar otro empleado
					System.out.println();
					System.out.print("¿Desea buscar otro empleado?: ");
					repetir=DeseaRepetir();
					System.out.println();
					
				}while(repetir.equals("si"));
			}
			break;
		}
		
					
	}
//METODO PARA LISTAR UNO O TODOS LOS PRODUCTOS DE LA TIENDA
	public static void ListarMusica(Tienda tienda, String opcion){
		String repetir="no";
		switch(opcion){//La variable opcion nos indicara si queremos mostrar uno o todos los productos de la tienda
		
		case "todos"://Vamos a mostrar todos los productos
			ArrayList<Musica> catalogo=tienda.getCatalogo();//Obtenemos la lista de productos
			System.out.println("------------------------------------------------------");
			for(int i=0;i<catalogo.size();i++){//Recorremos toda la lista
				MostrarMusica(catalogo.get(i));	//Vamos mostrando por consola cada producto de la lista
			}
			System.out.println("------------------------------------------------------");
			System.out.println();
			break;
		case "uno"://Vamos a mostrar un producto concreto
			do{//Este bucle se ejecutará hasta que el usuario decida salir de la opcion
				
				//Pedimos el código del producto que vamos a mostrar
				System.out.print("Introduzca el codigo del producto a buscar: ");
				String codigomusica=teclado.nextLine();
				
				//Obtenemos la posición del producto que se corresponde con el código introducido dentro de la lista de productos de la tienda
				int posicion_musica=BuscarMusica(codigomusica,tienda);
				
				if(posicion_musica!=-1){//Si la posición del producto es distinta de -1 significa que el producto existe y lo mostramos por consola
					System.out.println();
					System.out.println("------------------------------------------------------");
					MostrarMusica(tienda.getCatalogo().get(posicion_musica));
					System.out.println("------------------------------------------------------");
				}else{//Si la posición del producto es -1 significará que el producto con el código introducido no existe y llamaremos de nuevo a la función
					System.out.println();
					System.out.println("El producto introducido no existe.");
					
				}
				
				//Preguntamos al usuario si desea buscar otro producto
				System.out.println();
				System.out.print("¿Desea buscar otro producto?: ");
				repetir=DeseaRepetir();
				System.out.println();
			}while(repetir.equals("si"));
			break;
		}
		
	}
//METODO PARA LISTAR LAS VENTAS 
	public static void ListarFicherosVentas(Tienda tienda, String opcion){
		boolean fichero_encontrado=false, hayventas=false;
		
		RWFichero fichero=new RWFichero();//Creamos un objeto de la clase RWFichero
		String repetir="no";
		switch(opcion){
			case "todos"://Si vamos a listar todas las ventas
				ArrayList <String> ventas=ObtenerListaVentas();//Obtenemos la lista de archivos de ventas
				int numventas=ventas.size();//Obtenemos el numero de archivos de ventas
				for(int i=0;i<numventas;i++){//Vamos mostrando mostrando por consola las ventas una por una
						
			    	    fichero.setNombreArchivo(ventas.get(i));//Le asignamos el nombre del archivo de la venta
			    	    MostrarFicheroVenta(fichero);//Mostramos dicho fichero por consola
			    	    hayventas=true;//Activamos el flag que indica que existen archivos de venta
				   }
					
			 	
			 	if(hayventas==false){//Si no se hubiera activa el flag indica que no hay archivos de ventas
			 		
			 		System.out.println("No hay ventas registradas.");//Comunicamos al usuario que no hay ventas registradas
			 		System.out.println();
			 	}
					
				break;
			case "uno"://Si seleccionamos la opción de abrir un archivo de venta concreto
				do{//Este bucle se ejecutará hasta que el usuario decida salir de la opcion
					
					//Pedimos el nombre del archivo que vamos a mostrar
					System.out.print("Introduzca  la venta que desea buscar (ej: venta1): ");
					String nombrearchivo=teclado.nextLine();
					nombrearchivo=nombrearchivo+".txt";//Añadimos el formato 
					
					fichero_encontrado=ValidarVenta(nombrearchivo);	//Comprobamos que el fichero con el nombre introducido por el usuario existe				
					
					if(fichero_encontrado==true){//Si el archivo de texto existe
				 		
						fichero.setNombreArchivo(nombrearchivo);//Le asignamos el nombre del archivo de la venta al objeto RWFichero
				 		MostrarFicheroVenta(fichero);//Mostramos solo ese fichero por consola
				 			 		
				 	}else{//Si el archivo no hubiera sido encontrado
				 		System.out.println();
				 		System.out.println("La venta introducida no existe");//Informamos al usuario de que la venta no existe
				 		System.out.println();
				 	}
					
				 	//Preguntamos al usuario si desea buscar otra venta
				 	System.out.print("¿Desea buscar otra venta?: ");
					repetir=DeseaRepetir();
					System.out.println();
				}while(repetir.equals("si"));
			
			break;
		}
	}

/***************************METODOS PARA BUSCAR A UN CLIENTE, UN EMPLEADO Y UN PRODUCTO CON SU CODIGO********************************/
/***********************************************************************************************************************************/	
//MÉTODO PARA BUSCAR UN CLIENTE TRAVÉS DEL CÓDIGO 
	public static int BuscarCliente(int codigocliente, Tienda tienda ){
		
		//Obtenemos la lista de clientes de la tienda
		ArrayList<Cliente> lista =tienda.getListaClientes();
		//Creamos un objeto de la clase Cliente
		Cliente cliente=new Cliente();
		
		int posicion_cliente=-1;
		
		for(int i=0;i<lista.size();i++){//Recorremos la lista de clientes
			
			//Obtenemos de uno en uno los clientes de la tienda
			cliente=lista.get(i);
			if(cliente.getCodigoCliente()==codigocliente){//Si el código del cliente coincide con el código introducido
				
				posicion_cliente=i;//Guardamos la posición del cliente dentro de la lista de clientes
				i=lista.size();//Forzamos la salida del bucle porque encontramos al cliente asociado al código introducido
			}
		}
	return posicion_cliente;//retornará -1 si no encontro al cliente o la posición de este en la lista de clientes de la tienda
	}
//MÉTODO PARA BUSCAR UN EMPLEADO A TRAVÉS DE SU CÓDIGO
	public static int BuscarEmpleado(int codigoempleado, Tienda tienda ){
				
			//Obtenemos la lista de empleados de la tienda
			ArrayList<Empleado> lista =tienda.getListaEmpleados();
			//Creamos un objeto de la clase Empleado
			Empleado empleado=new Empleado();
			
			int posicion_empleado=-1;
			
			for(int i=0;i<lista.size();i++){//Recorremos la lista de empleados
				
				empleado=lista.get(i);//Obtenemos de uno en uno los empleados de la tienda
				
				if(empleado.getCodigoEmpleado()==codigoempleado){//Si el código del empleado coincide con el código introducido
					
					posicion_empleado=i;//Guardamos la posición del empleado dentro de la lista de empleados
					i=lista.size();	//Forzamos la salida del bucle porque encontramos al empleado asociado al código introducido
				}
			
			}
					
		return posicion_empleado;//retornará -1 si no encontro al empleado o la posición de este en la lista de empleados de la tienda
		}	
//METODO PARA BUSCAR UN PRODUCTO A TRAVÉS DEL CÓDIGO
	public static int BuscarMusica(String codigomusica, Tienda tienda ){
		int posicion_musica=-1;
		
		//Obtenemos la lista de productos de la tienda
		ArrayList<Musica> lista =tienda.getCatalogo();
		//Creamos un objeto de la clase Musica
		Musica musica=new Musica();
		
		for(int i=0;i<lista.size();i++){//Recorremos toda la lista de productos
			musica=lista.get(i);//Vamos cogiendo cada producto uno por uno
			
			if(codigomusica.equals(musica.getCodigoMusica())){//Si el codigo del producto coincide con el código del producto que buscamos guardamos la posición
				
				posicion_musica=i;
				i=lista.size();//Si hemos encontrado el producto salimos del bucle
			}
		}
				
		return posicion_musica;//Devolvemos la posición del producto o un -1 si no lo encontro
	}	

/******************************METODOS PARA MOSTRAR POR CONSOLA UN CLIENTE, UN EMPLEADO, UN PRODUCTO Y UNA VENTA**********************************/
/************************************************************************************************************************************************/
//METODO PARA MOSTRAR UN DETERMINADO CLIENTE POR CONSOLA
 	public static void MostrarCliente(Cliente cliente){
 		System.out.println("------------------------------------------------------");
		System.out.println("Codigo de Cliente: "+cliente.getCodigoCliente() );
		System.out.println("Cliente: "+cliente.getNombre()+" "+cliente.getApellidos());
		System.out.println("Fecha de nacimiento: "+cliente.getFechaNacimiento());
		System.out.println("DNI: "+cliente.getDni()+cliente.getLetraDni());
		System.out.println("Domicilio: "+cliente.getDomicilio());
		System.out.println("Cp: "+cliente.getCp());
		System.out.println("Localidad: "+cliente.getLocalidad());
		System.out.println("Provincia: "+cliente.getProvincia());
		System.out.println("Telefono: "+cliente.getTelefono());
		System.out.println("Correo electrónico: "+cliente.getCorreo());
		System.out.println("------------------------------------------------------");	
	}
//METODO PARA MOSTRAR UN DETERMINADO PRODUCTO POR CONSOLA
	public static void MostrarMusica(Musica musica){
				System.out.println("------------------------------------------------------");
				System.out.println("Codigo de Producto: "+musica.getCodigoMusica() );
				System.out.println("Titulo: "+musica.getTitulo());
				System.out.println("Autor: "+musica.getAutor());
				System.out.println("Año de publicación: "+musica.getAño());
				System.out.println("Duración: "+musica.getDuracion()+" min");
				System.out.println("Formato: "+musica.getFormato());
				System.out.println("Precio: "+musica.getPrecio()+" €");	
				System.out.println("Número de copias: "+musica.getNumeroCopias());	
				System.out.println("------------------------------------------------------");		
			}
//METODO PARA MOSTRAR UN DETERMINADO EMPLEADO POR CONSOLA
	public static void MostrarEmpleado(Empleado empleado){
			System.out.println("------------------------------------------------------");
			System.out.println("Codigo de Empleado: "+empleado.getCodigoEmpleado() );
			System.out.println("Empleado: "+empleado.getNombre()+" "+empleado.getApellidos());
			System.out.println("Fecha de nacimiento: "+empleado.getFechaNacimiento());
			System.out.println("DNI: "+empleado.getDni()+empleado.getLetraDni());
			System.out.println("Domicilio: "+empleado.getDomicilio());
			System.out.println("Cp: "+empleado.getCp());
			System.out.println("Localidad: "+empleado.getLocalidad());
			System.out.println("Provincia: "+empleado.getProvincia());
			System.out.println("Telefono: "+empleado.getTelefono());
			System.out.println("Correo electrónico: "+empleado.getCorreo());
			System.out.println("Nº Seguridad social: "+empleado.getNumeroSegSocial());
			System.out.println("Puesto: "+empleado.getPuesto());
			System.out.println("Numero productos vendidos: "+empleado.getNumeroVentasEmpleado());
			System.out.println("Ventas en euros: "+empleado.getTotalPrecioVentas()+" €");
			System.out.println("------------------------------------------------------");			
		}
//METODO PARA MOSTRAR UN DETERMINADO FICHERO DE VENTA
	public static void MostrarFicheroVenta(RWFichero fichero){
	
		try{//Leemos el fichero y lo mostramos por pantalla
			fichero.leerArchivoVenta(fichero.getNombreArchivo());
		}catch(FileNotFoundException e){//Si se produce un error al abrir el archivo capturamos la excepción
			System.out.println();
			System.out.println("Error al abrir el archivo");
			System.out.println();
		}catch(IOException e){//Si se produce un error al leer el archivo capturamos la excepción 
			System.out.println();
			System.out.println("Error al leer el archivo");
			System.out.println();
		}
		
	}
//METODO PARA MOSTRAR LA LISTA DE POSIBLES INSTRUCCIONES	
	public static void MostrarInstrucciones(){
		System.out.println("Las posibles instrucciones son:");
		System.out.println();
		System.out.println(">>crear cliente");
		System.out.println(">>crear empleado");
		System.out.println(">>crear musica");
		System.out.println(">>crear venta");
		System.out.println();
		System.out.println(">>listar clientes");
		System.out.println(">>listar empleados");
		System.out.println(">>listar musica");
		System.out.println(">>listar ventas");
		
		System.out.println();
		System.out.println(">>buscar cliente");
		System.out.println(">>buscar empleado");
		System.out.println(">>buscar musica");
		System.out.println(">>buscar venta");
		System.out.println();
		System.out.println(">>eliminar cliente");
		System.out.println(">>eliminar empleado");
		System.out.println(">>eliminar musica");
		System.out.println(">>eliminar venta");
		System.out.println();
		System.out.println(">>eliminar todos los clientes");
	    System.out.println(">>eliminar todos los empleados");
		System.out.println(">>eliminar toda la musica");
		System.out.println(">>eliminar todas las ventas");
		System.out.println();
		System.out.println(">>buscar empleado con mas ventas");
		System.out.println();
		System.out.println(">>cerrar");
		System.out.println(">>ayuda");
		System.out.println();
		
	}

/**************************METODOS PARA ELIMINAR UN CLIENTE, EMPLEADO, MUSICA, VENTA Y FICHERO************************************/
/********************************************************************************************************************************/	
//METODO PARA ELIMINAR UN CLIENTE
	public static void EliminarCliente(Tienda tienda){
	String repetir="no";
		do{//Bucle que se ejecutará hasta que deseemos salir de la opción
			
			//Pedimos el código del cliente a eliminar
			System.out.print("Introduzca el código del cliente a eliminar: ");
			int codigo=ValidarEntero();
			
			//Obtenemos la posicion del cliente a eliminar
			int posicion_cliente=BuscarCliente(codigo,tienda);
			
			//Si la posición del cliente es distinto de -1 existirá el cliente con el código introducido
			if(posicion_cliente!=-1){
				//Eliminamos el cliente de la lista de clientes
				tienda.EliminarCliente(posicion_cliente);
				//Informamos al usuario de que el cliente ha sido eliminado
				System.out.println();
				System.out.println("El cliente con codigo "+codigo+" se elimino correctamente");
				System.out.println();
							
			}else{//Si la posición del cliente es -1 el cliente con el codigo introducido no existe
				System.out.println();
				System.out.println("El cliente con codigo "+codigo+" no existe.");
				System.out.println();
			}
			//Preguntamos al usuario si desea eliminar otro cliente
			System.out.print("¿Desea eliminar otro cliente?: ");
			repetir=DeseaRepetir();
			System.out.println();
		}while(repetir.equals("si"));
	}
//METODO PARA ELIMINAR UN EMPLEADO
	public static void EliminarEmpleado(Tienda tienda){
		String repetir="no";
		do{//Bucle que se ejecutará hasta que deseemos salir de la opción
			
			//Pedimos el código del empleado a eliminar
			System.out.print("Introduzca el código del empleado a eliminar: ");
			int codigo=ValidarEntero();

			//Obtenemos la posicion del empleado a eliminar
			int posicion_empleado=BuscarEmpleado(codigo,tienda);
			
			//Si la posición del empleado es distinto de -1 existirá el empleado con el código introducido
			if(posicion_empleado!=-1){
				
				//Eliminamos el empleado de la lista de empleados
				tienda.EliminarEmpleado(posicion_empleado);
				//Informamos al usuario de que el empleado ha sido eliminado
				System.out.println();
				System.out.println("El empleado con codigo "+codigo+" se elimino correctamente");
				System.out.println();
			
			}else{//Si la posición del empleado es -1, el empleado con el codigo introducido no existe
				System.out.println();
				System.out.println("El empleado con codigo "+codigo+" no existe.");
				System.out.println();
			}
		    //Preguntamos al usuario si desea eliminar otro empleado
			System.out.print("¿Desea eliminar otro empleado?: ");
			repetir=DeseaRepetir();
			System.out.println();
		}while(repetir.equals("si"));
	}
//METODO PARA ELIMINAR MUSICA	
	public static void EliminarMusica(Tienda tienda){
		String repetir="no";
		do{//Bucle que se ejecutará hasta que deseemos salir de la opción
			
			//Pedimos el código del producto a eliminar
			System.out.print("Introduzca el código del producto a eliminar: ");
			String codigo=teclado.nextLine();
			
			//Obtenemos la posicion del empleado a eliminar
			int posicion_musica=BuscarMusica(codigo,tienda);
			
			//Si la posición del producto es distinto de -1, existirá el producto con el código introducido
			if(posicion_musica!=-1){
				Musica musica=tienda.getCatalogo().get(posicion_musica);
				
				if(musica.getNumeroCopias()>0){//Si hay copias del producto se descrementa el contador
					
					int numerocopias=musica.getNumeroCopias()-1;//Obtenemos el numero de copias y lo decrementamos
				    if(numerocopias!=0){//Si la copia que vamos a eliminar no es la ultima
				    	musica.setNumeroCopias(numerocopias);//Establecemos el numero de copias actualizado
				    	tienda.modificarCatalogo(posicion_musica, musica);//Incluimos el producto en el catálogo actualizado
				    }else{//Si la copia eliminada es la ultima eliminamos el producto del catálogo
				    	//Eliminamos el producto de la lista de productos
				    	tienda.EliminarProductoCatalogo(posicion_musica);
				    	//Informamos al usuario de que el producto ha sido eliminado
				    }
										
				}
				System.out.println();
				System.out.println("El producto con codigo "+codigo+" se elimino correctamente");
				System.out.println();
			}else{//Si la posición del producto es -1, el producto con el codigo introducido no existe
				System.out.println();
				System.out.println("El producto con codigo "+codigo+" no existe.");
				System.out.println();
			}
			
			//Preguntamos al usuario si desea eliminar otro producto
			System.out.print("¿Desea eliminar otro producto?: ");
			repetir=DeseaRepetir();
			System.out.println();
			
		}while(repetir.equals("si"));
	}
//METODO PARA ELIMINAR UNA VENTA
	public static void EliminarVenta(Tienda tienda){
		String repetir="no";
		boolean fichero_encontrado=false;
		
		do{//Bucle que se ejecutará hasta que deseemos salir de la opción
			
			
			//Pedimos el número de la venta que se desea eliminar
			System.out.print("Introduzca la venta que desea eliminar: ");
			String nombrearchivo=teclado.nextLine();
			nombrearchivo=nombrearchivo+".txt";//Añadimos el formato al nombre del archivo
			
			fichero_encontrado=ValidarVenta(nombrearchivo);
			
			if (fichero_encontrado==true){
				System.out.println();
	 			EliminarArchivoTexto(nombrearchivo);
	 			System.out.println();
			}else{//Si el archivo no se encontrara
		 		System.out.println();
		 		System.out.println("La venta introducida no existe");//Informamos al usuario de que la venta no existe
		 		System.out.println();
		 	}
		 	//Preguntamos al usuario si desea eliminar otra venta
	
			System.out.print("¿Desea eliminar otra venta?: ");
		 	repetir=DeseaRepetir();
		 	System.out.println();
		
		}while(repetir.equals("si"));	
			

	}
//METODO PARA BORRAR EL ARCHIVO DE TEXTO FISICO ASOCIADO A UNA VENTA
	public static void EliminarArchivoTexto(String nombrearchivo){
			
			//Creamos un archivo y lo apuntamos al archivo que queremos borrar
			File fichero_borrar=new File(nombrearchivo);
			
			if(fichero_borrar.delete()){//Eliminamos el archivo, si la acción devuelve un true se borro correctamente
				
				System.out.println("El fichero "+nombrearchivo+" ha sido borrado correctamente" );
				
			}else{//Si devuelve un false es que hubo algún error
				
				System.out.println("El fichero "+nombrearchivo+" no se pudo borrar" );
				
				
			}
		}

/**************************METODOS PARA ELIMINAR TODOS LOS CLIENTES, EMPLEADOS, MUSICA, VENTAS Y FICHEROS************************************/
/*******************************************************************************************************************************************/		
	//MÉTODO PARA ELIMINAR TODAS LAS VENTAS DE LA TIENDA
	public static void EliminarTodasVentas(Tienda tienda){
		ArrayList<String> ventas=ObtenerListaVentas();
		int numventas=ventas.size();
		if(numventas!=0){
			for(int i=0; i<numventas;i++){
			   EliminarArchivoTexto(ventas.get(i));
	    	   
	       }
		System.out.println();
		System.out.println("Se han eliminado "+numventas+" ventas.");//Informamos al usuario del total de ventas eliminadas
		System.out.println();
	     
	
	}else{
		System.out.println("No hay ventas registradas.");
		System.out.println();
		}
	}
//METODO PARA ELIMINAR TODOS LOS EMPLEADOS O TODOS LOS CLIENTES DE LA TIENDA
	public static void EliminarTodasPersonas(String opcion, Tienda tienda){

	switch(opcion){
	case "empleados":
		ArrayList<Empleado> listaempleados=tienda.getListaEmpleados();//Obtenemos la lista de empleados de la tienda
		int totalempleados=listaempleados.size();//Obtenemos el numero de empleados que tiene la tienda
		if(totalempleados!=0){
			for(int i=0;i<totalempleados;i++){
				System.out.println("El empleado con código "+listaempleados.get(i).getCodigoEmpleado()+" se ha eliminado correctamente.");
			}
			listaempleados.clear();//Limpiamos la lista de empleados
			System.out.println();
			System.out.println("Se han eliminado "+totalempleados+" empleados.");//Informamos al usuario del total de empleados eliminados
			System.out.println();
		}else{
		
			System.out.println("No hay empleados registrados.");
			System.out.println();
		}
			break;
	case "clientes":
		ArrayList<Cliente> listaclientes=tienda.getListaClientes();//Obtenemos la lista de clientes de ventas de la tienda
		int totalclientes=listaclientes.size();//Obtenemos el numero de clientes que tiene la tienda 
		if(totalclientes!=0){
			for(int i=0;i<totalclientes;i++){
				System.out.println("El cliente con código "+listaclientes.get(i).getCodigoCliente()+" se ha eliminado correctamente.");
				
			}
			listaclientes.clear();//Limpiamos la lista de clientes
			System.out.println();
			System.out.println("Se han eliminado "+totalclientes+" clientes.");//Informamos al usuario del total de clientes eliminadas
			System.out.println();
		}else{
		
			System.out.println("No hay clientes registrados.");
			System.out.println();
		}
		break;
	}
	}
//METODO PARA ELIMINAR TODOS LOS PRODUCTOS DE LA TIENDA
	public static void EliminarTodosProductos(Tienda tienda){
		int totalcopias=0;
		ArrayList<Musica> catalogo=tienda.getCatalogo();//Obtenemos la lista de productos de la tienda
		int totalproductos=catalogo.size();//Obtenemos el numero de productos que tiene la tienda 
		if(totalproductos!=0){//Si hay productos registrados
			for(int i=0;i<totalproductos;i++){//Recorrremos el catalogo
				totalcopias=totalcopias+catalogo.get(i).getNumeroCopias();//Vamos contandola cantidad de copias de cada producto
			}
			
			catalogo.clear();//Limpiamos la lista de productos
			System.out.println("Se han eliminado "+totalcopias+" productos.");//Informamos al usuario del total de copias eliminadas
			System.out.println();
			
		}else{//Si no hay productos registrados
			System.out.println("No hay productos registrados.");
			System.out.println();
		}
	}

/****************************METODO PARA ENCONTRAR AL EMPLEADO QUE MAS VENTAS REALIZO*****************************************/
/****************************************************************************************************************************/
//METODO PARA ENCONTRAR AL EMPLEADO QUE HA REALIZADO MAS VENTAS	
	public static void BuscarEmpleadoMasVentas(Tienda tienda){
	//Obtenemos la lista de empleados
	ArrayList<Empleado> lista=tienda.getListaEmpleados();
	int posicion_empleado=-1;
	float precioventas=0,precioventasaux=0;
	
	for(int i=0;i<lista.size();i++){//Recorremos toda la lista y vamos comparando que empleado realizo más ventas
		                            // al final obtendremos la posició en la lista del empleado que vendio más
			precioventasaux=lista.get(i).getTotalPrecioVentas();
			if(precioventasaux>=precioventas){
				precioventas=precioventasaux;
				posicion_empleado=i;			
			}
		
	}
	if(posicion_empleado!=-1 && precioventas!=0){
		System.out.println("-----------------EMPLEADO DEL MES---------------------");
		
		//Mostramos por consola el empleado que más ventas realizó
		MostrarEmpleado(lista.get(posicion_empleado));	
		System.out.println("------------------------------------------------------");
		System.out.println();
	}else if(posicion_empleado!=-1 && precioventas==0){//Si hay empleados registrados porque la 
		System.out.println("No hay empleado con más ventas. No se realizaron ventas.");
		System.out.println();
	}else{
		System.out.println("No hay empleados registrados.");
		System.out.println();
	}
	
}

/***************************************************METODO PRINCIPAL*************************************************************/
/*******************************************************************************************************************************/
	//METODO PRINCIPAL		
	public static void main(String[] args) {
		tienda=new Tienda();//Creamos un objeto de la clase Tienda
		
		teclado= new Scanner(System.in);//Creamos un objeto de la Clase Scanner para poder leer los datos de entrada por consola
		String opcion= null;//Variable que nos indicará que orden selecciona el usuario
		System.out.println("Bienvenido a Music Experience!, si desea ver las posibles instrucciones introduzca [ayuda]");
		System.out.println();
		do{//Este bucle se ejecutará hasta que el usuario introduzca por teclado la opción cerrar
			
			System.out.print("Esperando instruccion: ");//Pedimos instrucción al usuario
			opcion=teclado.nextLine();//Leemos la instrucción introducida
			System.out.println();
			opcion=opcion.toLowerCase();//Pasamos el contenido de la variable opción a minúsculas por si se introdujo alguna mayúscula 
			switch (opcion){//En función de la instrucción se ejecutará una u otra función
				case "crear cliente":
					CrearCliente(tienda);
					break;
				case "crear empleado":
					CrearEmpleado(tienda);
					break;
				case "crear musica":
					CrearMusica(tienda);
					break;
				case "crear venta":
					CrearVenta(tienda);
					break;
				case "listar clientes":
					ListarPersona(tienda, "cliente", "todos");
					break;
				case "listar empleados":
					ListarPersona(tienda, "empleado", "todos");
					break;
				case "listar musica":
					ListarMusica(tienda,"todos");
					break;
				case "listar ventas":
					ListarFicherosVentas(tienda,"todos");
					break;
				case "buscar empleado":
					ListarPersona(tienda, "empleado", "uno");
					break;
				case "buscar cliente":
					ListarPersona(tienda, "cliente", "uno");
					break;
				case "buscar musica":
					ListarMusica(tienda,"uno");
					break;
				case "buscar venta":
					ListarFicherosVentas(tienda,"uno");
					break;
				case "eliminar cliente":
					EliminarCliente(tienda);
					break;
				case "eliminar todos los clientes":
					EliminarTodasPersonas("clientes",tienda);
					break;
				case "eliminar empleado":
					EliminarEmpleado(tienda);
					break;
				case "eliminar todos los empleados":
					EliminarTodasPersonas("empleados",tienda);
					break;
				case "eliminar musica":
					EliminarMusica(tienda);
					break;
				case "eliminar toda la musica":
					EliminarTodosProductos(tienda);
					break;
						
				case "eliminar venta":
					EliminarVenta(tienda);
					break;
				case "eliminar todas las ventas":
					EliminarTodasVentas(tienda);
					break;
				case "buscar empleado con mas ventas":
					BuscarEmpleadoMasVentas(tienda);
					break;
				case "ayuda":
					MostrarInstrucciones();
					break;
				default://Si la instrucción introducida no es ninguna de las permitidas y tampoco es cerrar se lo comunicamos la usuario
					if(!opcion.equals("cerrar")){						
					System.out.println("Instrucción no válida");
					System.out.println();
					}
				break;
					
				
			}

	     }while(!opcion.equals("cerrar"));
		 
		teclado.close();//Cerramos el objeto de tipo Scanner

    }
}
