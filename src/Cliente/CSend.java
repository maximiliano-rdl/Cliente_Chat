package Cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import Herramientas.IMensajes;

public class CSend extends Thread implements IMensajes{

	private BufferedReader bufferConsola = new BufferedReader( new InputStreamReader(System.in) );
	private PrintWriter salidaSocket;

	public CSend(String nombre,DataOutputStream salidaSocket, String nick) {
		super(nombre);		
		this.salidaSocket = new PrintWriter(salidaSocket, true);		
		
		//salidaSocket.writeUTF(nick);
		this.salidaSocket.println(nick);
		//this.salidaSocket.flush();
		
	}
	
	public void run(){
	   boolean run = true;
	   try 
	   {	
		   
		   while(run)
		   {
				String mensaje = bufferConsola.readLine();	
				if(mensaje.equals(FINALIZAR))
				{	
					run = false;
					salidaSocket.println(FINALIZAR);
				}
				else
					salidaSocket.println(mensaje);
		   } 
	   }
	   catch (IOException e) {
			e.printStackTrace();
	   }
	   finally
	   {
		   /*
		  try{
				salidaSocket.close();
				bufferConsola.close();
		   }
		   catch (IOException e) {
				e.printStackTrace();
		   }*/
	   }
	}
}
