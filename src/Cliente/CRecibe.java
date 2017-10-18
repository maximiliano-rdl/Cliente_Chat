package Cliente;

import java.io.BufferedReader;
import java.io.IOException;

import Herramientas.IMensajes;

public class CRecibe extends Thread implements IMensajes{
	private BufferedReader input;
	private boolean run=false;
	
	public CRecibe(String nombre,BufferedReader input ) {
		super(nombre);		
		this.input = input;
		
	}
	
	public void run(){	
		run = true;	
		String mensaje ="";
		while(run&&!mensaje.equals(FIN_CONEXION))
		{
			try 
			{
				mensaje = input.readLine();
				System.out.println(	mensaje );
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
		/*
		try 
		{
			input.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}*/
	}
	
	public void salir(){
		run = false;
		
	}
	
	
	

}
