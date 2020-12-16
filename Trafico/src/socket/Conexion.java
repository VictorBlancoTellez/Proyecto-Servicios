package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
	private final int PUERTO = 1234;
	private final String HOST = "localhost";
	protected String mensajeServidor;
	protected ServerSocket serverSocket;
	protected Socket socket;
	protected DataOutputStream salidaServidor, salidaCliente;

	public Conexion(String tipo) throws IOException {
		if (tipo.equalsIgnoreCase("servidor")) {
			serverSocket = new ServerSocket(PUERTO);
			socket = new Socket();
		} else {
			socket = new Socket(HOST, PUERTO);
		}
	}
}