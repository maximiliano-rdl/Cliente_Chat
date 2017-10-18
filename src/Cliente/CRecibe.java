package Cliente;

import java.io.BufferedReader;
import java.io.IOException;

import Herramientas.IMensajes;

public class CRecibe extends Thread implements IMensajes {
	private BufferedReader input;
	private boolean run = false;

	public CRecibe(String nombre, BufferedReader input) {
		super(nombre);
		this.input = input;

	}

	public void run() {
		run = true;
		String mensaje = "";

		try {
			mensaje = input.readLine();
			while (run && !mensaje.equals(FIN_CONEXION)) {
				System.out.println(mensaje);
				mensaje = input.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salir() {
		run = false;

	}

}
