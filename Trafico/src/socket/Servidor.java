package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion {
	public Servidor() throws IOException {
		super("servidor");
	}

	public void startServer() {
		while (true) {
			try {
				System.out.println("Esperando...");

				socket = serverSocket.accept();

				System.out.println("Cliente en línea");

//				salidaCliente = new DataOutputStream(socket.getOutputStream());

				salidaCliente.writeUTF("Petición recibida y aceptada");

//				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				System.out.println(entrada.readLine());

//				while ((mensajeServidor = entrada.readLine()) != null) {
//
//					System.out.println(mensajeServidor);
//				}

				System.out.println("Fin de la conexión");

				serverSocket.close();
			} catch (Exception e) {
				System.out.println("HOLA HOLA HOLA");
				System.out.println(e.getMessage());
			}
		}

	}
}