package Cliente;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import Herramientas.Valida;

public class Cliente{

	private String nick;
	private Socket socket;
	
	public Cliente(String ipServer, int puerto, String nick){
		try
		{
			socket = new Socket(ipServer,puerto);			
			this.nick= nick;
			CRecibe oreja = new CRecibe("recibir",new BufferedReader(new InputStreamReader(socket.getInputStream())));
			CSend boca	 = new CSend("enviar",new DataOutputStream(socket.getOutputStream()),nick);
			
			oreja.start();
			boca.start();
			
		}
		catch(Exception e){
			
		}
	}
	
	public static void main(String args[]) throws IOException {

		String puerto;
		String ip;
		String nick;
		BufferedReader buffer = new BufferedReader( new InputStreamReader(System.in) );
		
		do 
		{
			System.out.print("IP Servidor >:");
			ip = buffer.readLine();
		}
		while(!Valida.validateIP(ip));
		
		do 
		{
			System.out.print("Puerto >:");
			puerto = buffer.readLine();
			
		}
		while(!Valida.validaPuerto(puerto));

		do 
		{
			System.out.print("Nick >:");
			nick = buffer.readLine();
			
		}
		while(!Valida.validaPuerto(puerto));
		
		new Cliente(ip, Integer.parseInt(puerto), nick);
		
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}
