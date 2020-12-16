package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	private static String HOST = "localhost";
	private static int PUERTO = 2017;

	public void startClient() throws IOException {
		Socket socket;
		DataOutputStream mensaje;

		try {
			// Creamos nuestro socket
			socket = new Socket(HOST, PUERTO);

			mensaje = new DataOutputStream(socket.getOutputStream());

			// Enviamos un mensaje
			mensaje.writeUTF("Hola soy un cliente!!");

			// Cerramos la conexi�n
			socket.close();

		} catch (UnknownHostException e) {
			System.out.println("El host no existe o no est� activo.");
		} catch (IOException e) {
			System.out.println("Error de entrada/salida.");
		}

	}
}